package comm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import util.*;

import com.pi4j.io.serial.*;

public class SerialWrapper {
	
	private static final Serial usbSerial = SerialFactory.createInstance();
	private static InputStream input;
	private static OutputStream output;
	
	public SerialWrapper(String device){
		try {
			usbSerial.open(device, 9600);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		input = usbSerial.getInputStream();
		output = usbSerial.getOutputStream();
	}
	
	public void write(String data){
		try {
			output.write(data.getBytes());
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
	}
	
	public String read(){
		byte[] b = null;
		try {
			b = new byte[input.available()];
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			robot.SimpleRobot.eHandler.addError(e1);
		}
		try {
			input.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			robot.SimpleRobot.eHandler.addError(e);
		}
		char[] data = new char[b.length];
		for(int i = 0; i<b.length; i++){
			data[i] = (char) b[i];
		}
		return String.copyValueOf(data);
		
	}

	public void write(byte[] bytes) {
		try {
			output.write(bytes);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
	}

	public int available() {
		try {
			return input.available();
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return -1;
	}	
}
