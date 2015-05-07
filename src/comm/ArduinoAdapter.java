package comm;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
		
	public ArduinoAdapter(){
	}
	
	public double readData(){
		robot.SimpleRobot.arduinoSerial.write("<r//>\n");
		return Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, int speed){
		String msg = String.format("<m/%d/%d>\n",pin,speed);
		boolean ack = false;
		int readCount = 0;
		try {
			robot.SimpleRobot.arduinoSerial.write(msg);
			System.out.println("The serial write happened");
			while(robot.SimpleRobot.arduinoSerial.available()<5){
				System.out.println("Still waiting for serial data return");
			}
			if(robot.SimpleRobot.arduinoSerial.read().equals("<a//>")){
				System.out.println("Acked");
				return true;
				
			}else{
				setMotorSpeed(pin, speed);
			}
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}
}
