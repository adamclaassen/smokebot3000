package comm;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
	}
	
	public double readData(){
		robot.SimpleRobot.arduinoSerial.write("<r//>");
		return Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, int speed){
		String msg = String.format("<m/%d/%d>",pin,speed);
		boolean ack = false;
		try {
			robot.SimpleRobot.arduinoSerial.write(msg);
			while(!ack){
				if(robot.SimpleRobot.arduinoSerial.read().equals("<a//>")){
					return true;
				}
				long time = robot.SimpleRobot.timer.millis();
				if(robot.SimpleRobot.timer.millis()!=time+100){
					return false;
				}
				
			}
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}
}
