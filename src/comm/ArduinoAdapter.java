package comm;

import java.io.File;
import java.io.IOException;


public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
	}
	
	public double readData(){
		return Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, int speed){
		try {
			int readCount = 0;
			boolean timeOut = false;
			boolean ack = false;
			String inMsg;
			String msg = String.format("<m/%d/%d>",pin,speed);
			robot.SimpleRobot.arduinoSerial.write(msg);
			System.out.println("Message: " +msg);
			while(!timeOut && !ack){
				if(robot.SimpleRobot.arduinoSerial.available() > 0){
					inMsg = robot.SimpleRobot.arduinoSerial.readOSVPacket();
					System.out.println(inMsg);
					if(inMsg.length() >= 4){
						if(inMsg.substring(1,2).equals("a")){
							ack = true;
							System.out.println("Message Acknowledged");
							return true;
						}
					}
				}
				if(readCount > 100){
					timeOut = true;
					System.out.println("Timed out");
				}
				System.out.println("Read Count: " + readCount);
				
				readCount++;
			}

			
		} catch (IllegalStateException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return false;
	}
}
