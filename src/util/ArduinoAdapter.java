package util;

import java.io.File;

import com.pi4j.wiringpi.Serial;

public class ArduinoAdapter {
	
	int fd = -1;
	
	public ArduinoAdapter(){
		File dev = new File("/dev/");
		for(String device:dev.list()){
			if(device.contains("ttyACM")){
				fd = Serial.serialOpen("/dev/" + device, 115200);
			}
		}
		if(fd == -1){
			fd = Serial.serialOpen("/dev/ttyACM0", 115200);
		}
	}
	
	public double readData(){
		Serial.serialFlush(fd);
		Serial.serialPuts(fd, "<r//>");
		
		int readCount = 0;
		while(Serial.serialDataAvail(fd)<=5){
			if(readCount>100){
				Serial.serialFlush(fd);
				Serial.serialPuts(fd,  "<r//>");
				readCount = 0;
			}
			readCount++;
		}
		byte[] serialBytes = Serial.serialGetAvailableBytes(fd);
		char[] serialChars = new char[serialBytes.length];
		for(int i = 0; i<serialBytes.length; i++){
			serialChars[i] = (char) serialBytes[i];
		}
		
		return Double.parseDouble(new String(serialChars).split("<|>")[1].split("/")[1]);
	}
	
	public boolean setMotorSpeed(int pin, double speed){
		Serial.serialFlush(fd);
		Serial.serialPuts(fd, String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)));
		
		int readCount = 0;
		while(Serial.serialDataAvail(fd)<=5){
			if(readCount>100){
				Serial.serialFlush(fd);
				Serial.serialPuts(fd, String.format("<m/{0}/{1}>", String.format("%05d",pin), String.format("%05d",speed)));
				readCount = 0;
			}
			readCount++;
		}
		char[] serialChars = new char[Serial.serialDataAvail(fd)];
		int i = 0;
		while(Serial.serialDataAvail(fd)>0){
			serialChars[i] = (char) Serial.serialGetByte(fd);
		}
		if(serialChars[1] == 'a'){
			return true;
		}
		return setMotorSpeed(pin, speed);
		
	}
}
