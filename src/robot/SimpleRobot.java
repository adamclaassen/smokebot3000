package robot;


import java.util.ArrayList;
import java.io.IOException;
import java.time.Clock;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javafx.geometry.Pos;

import org.w3c.dom.*;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialFactory;

import pathfinder.Pathfinder;
import motor.*;
import sensor.*;
import comm.*;
import util.*;





public class SimpleRobot {
	
	// various private objects
	private static Pathfinder pathfinder;
	private static ArrayList<Position> routeTaken;
	private static ArrayList<Zone> obsticleMap;
	private static ArrayList<Position> destinations;
	private static Radio radio;
	private static Pid distPid;
	private static Pid turnPid;
	private static Motor leftMotor;
	private static Motor rightMotor;
	private static Position currentPos;
	private static AnalogDigitalConverter adc;
	private static int currentDriveSpeed = 0;
	private static Clock timer;
	private static DocumentBuilderFactory dbf;
	private static DocumentBuilder db;
	private static Document xmldoc;
	private static I2CColor color;
	private static Gyro gyro;
	
	//public objects
	public static ErrorHandler eHandler;
	public static SerialWrapper arduinoSerial;
	public static ArduinoAdapter ardu;
	public static SPIWrapper spi;
	public static I2CWrapper i2c;
	
	private static int obsDist = 50;
	private Zone[] obs = {
			new Zone(1200,1400,obsDist),
			new Zone(1200,600 ,obsDist),
			new Zone(2100,1800,obsDist),
			new Zone(2400,1800,obsDist),
			new Zone(2200,8000,obsDist),
			new Zone(2200,800 ,obsDist),
			new Zone(3200,700 ,obsDist)
	};
	

	
	// constants
	private final static int defaultSpeed = 1;
	
	public static void main(String[] args) {
		
		//pathfinder = new Pathfinder(currentPos, destinations, obsticleMap);
		eHandler = new ErrorHandler();
		routeTaken = new ArrayList<Position>();
		obsticleMap = new ArrayList<Zone>();
		destinations = new ArrayList<Position>();
		//radio = new Radio();
		distPid = new Pid(1, 1, 1);
		turnPid = new Pid(1, 1, 1);
		leftMotor = new ArduinoMotorController(9);
		rightMotor = new ArduinoMotorController(10);
		//currentPos = radio.getCurrentPos();
		currentPos = new Position(0,0,0);
		adc = new AnalogDigitalConverter(0, 1024);
		arduinoSerial = new SerialWrapper("/dev/ttyACM0");
		ardu = new ArduinoAdapter();
		spi = new SPIWrapper();
		//i2c = new I2CWrapper();
		System.out.println(eHandler.getErrors().toString());
		//color = new I2CColor(0, 0);
		//gyro = new Gyro(0,0);
		//xml doc stuff
		dbf = DocumentBuilderFactory.newInstance();
		db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			eHandler.addError(e);
		}
		
		//System.out.println(color.read()[0]);
		//System.out.println(color.read()[1]);
		//System.out.println(color.read()[2]);
		//System.out.println(gyro.read()[0]);
		//System.out.println(gyro.read()[1]);
		//System.out.println(gyro.read()[2]);
		
		//leftMotor.setSpeed(150);
		leftMotor.setSpeed(150);
		/*xmldoc = db.newDocument();
		
		System.out.println("All objects initialized");
		
		generateXML(xmldoc);
		
		leftMotor.setSpeed(150);
		driveToPoint(new Position(2000, 1000), 1);
		System.out.println("Drove to point");*/
		//driveOnPath(pathfinder.getTurnPoints(), defaultSpeed); 
	}
	
	/**
	 * fwdSpeed is between -1 (full back) and 1 (full fwd).
	 * turnSpeed is between -1 (full left) and 1 (full right).
	 * The speed of the outside motor in a turn is fwdSpeed+|turnSpeed|.
	 * The speed of the inside motor is fwdSpeed-|turnSpeed|.
	 * The actual math below is mathematically equivalent to the steps above,
	 * but requires less code to implement. (I think)
	 * @param fwdSpeed
	 * @param turnSpeed
	 */
	public static void drive(int fwdSpeed, int turnSpeed){
		leftMotor.setSpeed((fwdSpeed+turnSpeed)/2);
		rightMotor.setSpeed((fwdSpeed-turnSpeed)/2);
	}
	
	public static void readSensors(){
		
		//radio.send(Double.toString());
	}
	
	/**
	 * driveToPoint drives at speed, adjusting course with turnPid while
	 * also updating currentPosition from radio. 
	 * @param dest
	 * @param speed
	 */
	public static void driveToPoint(Position dest, int speed){
		dest.setNearbyRadius(25);
		turnPid.setSetpoint(currentPos.getHeadTo(dest));
				
		while(!dest.isNearby(currentPos)){
			drive(speed, (int)turnPid.update(currentPos.getHead()));
			updateAll();
		}
	}
	
	/**
	 * This method takes an ArrayList of Positions from Pathfinder,
	 * and runs driveToPoint on each of them. Read about 'java 8 lambdas' for
	 * a better explanation of the code here.
	 * @param path
	 * @param speed
	 */
	public static void driveOnPath(ArrayList<Position> path, int speed){
		path.forEach((pos) -> driveToPoint(pos, speed));
	}
	
	/**
	 * This method should include update calls
	 * to anything that doesn't update some other way. 
	 */
	public static void updateAll(){
		//this.currentPos = radio.getLatestPos();
	}
	
	/**
	 * Elements of XML Doc:
	 * currentPos
	 * path
	 * previousPositions
	 * battery
	 * sensorData
	 */
	private static void generateXML(Document docXML){

		//declare elements
		Element robotXML = docXML.createElement("robot");
		Element currentPosXML = docXML.createElement("current-position");
		Element pathXML = docXML.createElement("path");
		Element routeTakenXML = docXML.createElement("route-taken");
		Element batteryStatusXML = docXML.createElement("battery");
		Element sensorValueXML = docXML.createElement("sensor-data");
		Element errors = docXML.createElement("errors");
		
		//append all sub-elements of root
		robotXML.appendChild(currentPosXML);
		robotXML.appendChild(pathXML);
		robotXML.appendChild(routeTakenXML);
		robotXML.appendChild(batteryStatusXML);
		robotXML.appendChild(sensorValueXML);
		robotXML.appendChild(errors);
		
		
		
		//create structures for all positional elements
		addPositionXML(docXML, currentPosXML, radio.getCurrentPos());
		routeTaken.forEach((routePoint) -> addPositionXML(docXML, routeTakenXML, routePoint));
		pathfinder.getTurnPoints().forEach((turnPoint) -> addPositionXML(docXML, pathXML, turnPoint));
		
		//add data for all other elements
		batteryStatusXML.appendChild(docXML.createTextNode(Double.toString(10)));
		sensorValueXML.appendChild(docXML.createTextNode(Double.toString(20)));
		
		//Append to errors node a string representation.
		eHandler.getErrors().forEach((e) -> errors.appendChild(docXML.createTextNode(e.toString())));
		
	}
	
	private static void addPositionXML(Document doc, Element parent, Position pos){
		Element x = doc.createElement("x");
		Element y = doc.createElement("y");
		Element rot = doc.createElement("rot");
		
		x.appendChild(doc.createTextNode(Integer.toString(pos.getX())));
		y.appendChild(doc.createTextNode(Integer.toString(pos.getY())));
		rot.appendChild(doc.createTextNode(Double.toString(pos.getHead())));
		
		parent.appendChild(x);
		parent.appendChild(y);
		parent.appendChild(rot);
	}

}
