package util;

import com.pi4j.wiringpi.Serial;

public class ArduinoAdapter {
	
	int fd;
	
	public ArduinoAdapter(){
		fd = Serial.serialOpen("/dev/ttyACM0", 115200);
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
	
	public boolean setMotorSpeed(int pin, int speed){
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
		byte[] serialBytes = Serial.serialGetAvailableBytes(fd);
		char[] serialChars = new char[serialBytes.length];
		for(int i = 0; i<serialBytes.length; i++){
			serialChars[i] = (char) serialBytes[i];
		}
		if(serialChars[1] == 'a'){
			return true;
		}
		return setMotorSpeed(pin, speed);
		
	}
}
