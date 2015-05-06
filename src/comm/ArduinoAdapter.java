package comm;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
		
	public ArduinoAdapter(){
	}
	
	public double readData(){
		robot.SimpleRobot.arduinoSerial.write("<r//>");
		return Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, int speed){
		String msg = String.format("<m/%d/%d>",pin,speed);
		boolean ack = false;
		int readCount = 0;
		try {
			robot.SimpleRobot.arduinoSerial.write(msg);
			System.out.println("The serial write happened");
			while(robot.SimpleRobot.arduinoSerial.read() != "<a//>"){
				long time = robot.SimpleRobot.timer.millis();
				while(time < robot.SimpleRobot.timer.millis()+10){
					
				}
				readCount++;
				if(readCount == 40){
					System.out.println("Timed out, I guess");
					return false;
				}
			}
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}
}
