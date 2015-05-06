package comm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import util.*;

import com.pi4j.io.serial.*;

public class SerialWrapper {
	
	private final Serial usbSerial = SerialFactory.createInstance();
	private InputStream input;
	private OutputStream output;
	
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
			System.out.println("Error in a write statement");
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
	public String readOSVPacket(){
		String msg = "";
		try{
			while(input.available() > 0){
				char inChar = (char)input.read();
				if(inChar == '<'){
					msg+=inChar;
					while(inChar != '>'){
						inChar = (char)input.read();
						msg+= inChar;
					}
				}
			}
		}
		catch(IOException e){
			robot.SimpleRobot.eHandler.addError(e);
		}
		return msg;
	}
		

	public void write(byte[] bytes) {
		try {
			output.write(bytes);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
	}

	public char readChar(){
		try{
			char inChar = (char)input.read();
			return inChar;
		}
		catch(IOException e){
			robot.SimpleRobot.eHandler.addError(e);
			return 'q';
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
