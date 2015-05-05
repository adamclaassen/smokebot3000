package comm;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
	}
	
	public double readData(){
		return Double.parseDouble(robot.SimpleRobot.serial.read().split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, int speed){
		try {
			String msg = String.format("<m/%d/%d>",pin,speed);
			robot.SimpleRobot.serial.write(msg.getBytes());
			System.out.println(msg);
			int readCount = 0;
			while(robot.SimpleRobot.serial.available()<=5){
				if(readCount>100){
					robot.SimpleRobot.serial.write(String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d", (int) speed)).getBytes());
					readCount = 0;
				}
				readCount++;
			}
			
			if(robot.SimpleRobot.serial.read().substring(1, 2).equals("a")){
				return true;
			}
			
			return setMotorSpeed(pin, speed);
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}
}
