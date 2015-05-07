package comm;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
		
	public ArduinoAdapter(){
	}
	
	public void readData(){
		robot.SimpleRobot.arduinoSerial.write("<r//>\n");
		//return Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, int speed){
		String msg = String.format("<m/%d/%d>\n",pin,speed);
		boolean ack = false;
		int readCount = 0;
		try {
			while(!ack){
				robot.SimpleRobot.arduinoSerial.write(msg);
				System.out.println("The serial write happened");
				while(robot.SimpleRobot.arduinoSerial.available()<5 && readCount<= 200){
					System.out.println("Still waiting for serial data return");
					readCount++;
				}
				if(robot.SimpleRobot.arduinoSerial.read().equals("<a//>\n")){
					System.out.println("Acked");
					ack =  true;
				
				}else{
					if(robot.SimpleRobot.arduinoSerial.read().equals("<a//>")){
						System.out.println("Acked");
						ack = true;
					}
				}
			}
			return true;
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}

public boolean sendSerialMessage(String mesg){
	String msg = mesg;
	boolean ack = false;
	int readCount = 0;
	try {
		while(!ack){
			robot.SimpleRobot.arduinoSerial.write(msg);
			System.out.println("The serial write happened");
			while(robot.SimpleRobot.arduinoSerial.available()<5 && readCount<= 200){
				//System.out.println("Still waiting for serial data return");
				readCount++;
			}
			/*if(robot.SimpleRobot.arduinoSerial.read().equals("<a//>\n")){
				System.out.println("Acked");
				ack =  true;
			
			}else{
				if(robot.SimpleRobot.arduinoSerial.read().equals("<a//>")){
					System.out.println("Acked");
					ack = true;
				}
			}*/
		}
		return true;
	} catch (IllegalStateException e) {
		robot.SimpleRobot.eHandler.addError(e);
	}
	return false;
	}
}