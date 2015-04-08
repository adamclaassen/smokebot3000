package comm;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.pi4j.io.serial.*;

public class SerialWrapper{
	
	final Serial serial;
	
	private ArrayList<String> messages;
	
	public SerialWrapper(){
		this.serial = SerialFactory.createInstance();
		serial.addListener( new SerialDataEventListener() {
			@Override
			public void dataReceived(SerialDataEvent event) {
				try {
					messages.add(event.getString(Charset.defaultCharset()));
				} catch (IOException e) {
					robot.SimpleRobot.eHandler.addError(e);
				}
			}
		}
		);
	}
	
	/**
	 * Returns the last message received, then clears it
	 * @return String
	 */
	public String getNewestMessage(){
		String temp = this.messages.get(this.messages.size()-1);
		this.messages.remove(this.messages.size()-1);
		return temp;
	}
	
	/**
	 * Returns the oldest message, then clears it
	 * @return String
	 */
	public String getOldestMessage(){
		String temp = this.messages.get(0);
		this.messages.remove(0);
		return temp;
	}
	
	/**
	 * Returns ArrayList of all messages, then clears them.
	 * @return ArrayList of Strings
	 */
	public ArrayList<String> getAllMessages(){
		ArrayList<String> temp = this.messages;
		this.messages.clear();
		return temp;
	}
	
	public void clearMessages(){
		this.messages.clear();
	}
}
