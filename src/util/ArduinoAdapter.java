package util;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
	}
	
	public double readData(){
		try {
			robot.SimpleRobot.serial.flush();
			
		} catch (IllegalStateException | IOException e1) {
			e1.printStackTrace();
		}
		
		byte[] serialBytes = null;
		try {
			serialBytes = robot.SimpleRobot.serial.read();
		} catch (IllegalStateException | IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		char[] serialChars = new char[serialBytes.length];
		for(int i = 0; i<serialBytes.length; i++){
			serialChars[i] = (char) serialBytes[i];
		}
		
		return Double.parseDouble(new String(serialChars).split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, double speed){
		byte[] serialChars;
		try {
			robot.SimpleRobot.serial.flush();;
			robot.SimpleRobot.serial.write(String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)).getBytes());
			
			int readCount = 0;
			while(robot.SimpleRobot.serial.available()<=5){
				if(readCount>100){
					robot.SimpleRobot.serial.flush();;
					robot.SimpleRobot.serial.write(String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)).getBytes());
					readCount = 0;
				}
				readCount++;
			}
			
			serialChars = robot.SimpleRobot.serial.read();
			if(serialChars[1] == 'a'){
				return true;
			}
			return setMotorSpeed(pin, speed);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
