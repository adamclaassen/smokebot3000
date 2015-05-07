package util;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
	}
	
	public double readData(){
		return Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
	}
	
	public Double readData(String message){
		return Double.parseDouble(message.split("<|>")[1].split("/")[1]);
	}
	public boolean setMotorSpeed(int pin, double speed){
		try {
			robot.SimpleRobot.arduinoSerial.write(String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d", (int) speed)).getBytes());
			
			int readCount = 0;
			while(robot.SimpleRobot.arduinoSerial.available()<=5){
				if(readCount>100){
					robot.SimpleRobot.arduinoSerial.write(String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)).getBytes());
					readCount = 0;
				}
				readCount++;
			}
			
			if(robot.SimpleRobot.arduinoSerial.read().substring(1, 2).equals("a")){
				return true;
			}
			
			return setMotorSpeed(pin, speed);
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}
}
