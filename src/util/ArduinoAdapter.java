package util;

import java.io.File;


public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
		File dev = new File("/dev/");
		for(String device:dev.list()){
			if(device.contains("ttyACM")){
				fd = robot.SimpleRobot.serial.serialOpen("/dev/" + device, 115200);
			}
		}
		if(fd == -1){
			fd = robot.SimpleRobot.serial.serialOpen("/dev/ttyACM0", 115200);
		}
	}
	
	public double readData(){
		robot.SimpleRobot.serial.serialFlush(fd);
		robot.SimpleRobot.serial.serialPuts(fd, "<r//>");
		
		int readCount = 0;
		while(robot.SimpleRobot.serial.serialDataAvail(fd)<=5){
			if(readCount>100){
				robot.SimpleRobot.serial.serialFlush(fd);
				robot.SimpleRobot.serial.serialPuts(fd,  "<r//>");
				readCount = 0;
			}
			readCount++;
		}
		byte[] serialBytes = robot.SimpleRobot.serial.serialGetAvailableBytes(fd);
		char[] serialChars = new char[serialBytes.length];
		for(int i = 0; i<serialBytes.length; i++){
			serialChars[i] = (char) serialBytes[i];
		}
		
		return Double.parseDouble(new String(serialChars).split("<|>")[1].split("/")[1]);
	}
	
	@SuppressWarnings("deprecation")
	public boolean setMotorSpeed(int pin, double speed){
		robot.SimpleRobot.serial.serialFlush(fd);
		robot.SimpleRobot.serial.serialPuts(fd, String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)));
		
		int readCount = 0;
		while(robot.SimpleRobot.serial.serialDataAvail(fd)<=5){
			if(readCount>100){
				robot.SimpleRobot.serial.serialFlush(fd);
				robot.SimpleRobot.serial.serialPuts(fd, String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)));
				readCount = 0;
			}
			readCount++;
		}
		char[] serialChars = new char[robot.SimpleRobot.serial.serialDataAvail(fd)];
		int i = 0;
		while(robot.SimpleRobot.serial.serialDataAvail(fd)>0){
			serialChars[i] = (char) robot.SimpleRobot.serial.serialGetchar(fd);
		}
		if(serialChars[1] == 'a'){
			return true;
		}
		return setMotorSpeed(pin, speed);
		
	}
}
