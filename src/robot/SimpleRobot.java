package robot;

import java.util.ArrayList;

import motor.Motor;
import sensor.AnalogDigitalConverter;
import util.Pathfinder;
import util.Pid;
import util.Position;
import comm.Gpio;
import comm.Radio;
import comm.SPIWrapper;
import comm.SerialWrapper;

public class SimpleRobot {
	
	// various objects
	private static Pathfinder pathfinder;
	private static Radio radio;
	private static Pid distPid;
	private static Pid turnPid;
	private static Motor leftMotor;
	private static Motor rightMotor;
	private static Gpio gpio;
	private static SPIWrapper spi;
	private static SerialWrapper serial;
	private static Position currentPos;
	private static AnalogDigitalConverter adc;
	
	// various numbers
	static double defaultSpeed = 10;
	
	
	public SimpleRobot(){
		pathfinder = new Pathfinder(currentPos);
	}
	
	public static void main(String[] args) {
		startup();
		driveOnPath(pathfinder.getTurnPoints(), defaultSpeed);
		
	}
	
	/**
	 * fwdSpeed is between -1 (full back) and 1 (full fwd).
	 * turnSpeed is between -1 (full left) and 1 (full right).
	 * The speed of the outside motor in a turn is fwdSpeed+|turnSpeed|.
	 * The speed of the inside motor is fwdSpeed-|turnSpeed|
	 * (technically this is the mathematical equivalent)
	 * @param fwdSpeed
	 * @param turnSpeed
	 */
	public static void drive(double fwdSpeed, double turnSpeed){
		leftMotor.setSpeed((fwdSpeed+turnSpeed));
		rightMotor.setSpeed((fwdSpeed-turnSpeed));
	}
	
	public static void readSensors(){
		double smokeValue = adc.read();
		//radio.send(Double.toString(smokeValue));
	}
	
	/**
	 * driveToPoint drives at speed, adjusting course with turnPid while
	 * also updating currentPosition from radio. 
	 * @param dest
	 * @param speed
	 */
	public static void driveToPoint(Position dest, double speed){
		dest.setNearbyRadius(25);
		turnPid.setSetpoint(currentPos.getHeadTo(dest));
		while(!dest.isNearby(currentPos)){
			drive(speed, turnPid.update(currentPos.getHead()));
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
	public static void driveOnPath(ArrayList<Position> path, double speed){
		path.forEach((pos) -> driveToPoint(pos, speed));
	}
	
	/**
	 * This method should include update calls
	 * to anything that doesn't update some other way. 
	 * Will be depreciated in favor of separate subsystem update calls
	 */
	public static void updateAll(){
		//this.currentPos = radio.getLatestPos();
	}
	
	/**
	 * Any code to be run once at startup.
	 * Behaves the same as arduino's setup()
	 */
	public static void startup(){
		
	}

}
