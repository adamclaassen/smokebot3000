package comm;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.pi4j.io.serial.*;

public class SerialWrapper{
	
	final Serial serial;
	//private ArrayList<String> messages;

	public  SerialWrapper() {
		serial = SerialFactory.createInstance();
		serial.addListener(new SerialDataEventListener() {
			@Override
			public void dataReceived(SerialDataEvent event) {
				try {
					System.out.println("We got some data");
					System.out.print("[HEX DATA]   " + event.getHexByteString());
					System.out.print("[ASCII DATA] " + event.getAsciiString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void read() {
		try {
			System.out.println("Message: " + serial.read());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void write(String message) {
		 try {
	            // open the default serial port provided on the GPIO heade
	            serial.open(Serial.DEFAULT_COM_PORT, Baud._38400, DataBits._8, Parity.NONE, StopBits._1, FlowControl.NONE);
	           if (serial.isOpen())
	        	   System.out.println("Serial is open");
	           else{
	        	   System.out.println("Not open");
	           }
	                       
	                try {
	                    // write a formatted string to the serial transmit buffer
	                    serial.write(message);
	    
	                               }
	                catch(IllegalStateException ex){
	                    ex.printStackTrace();                    
	                }
	                
	                // wait 1 second before continuing
	                Thread.sleep(1000);
	            
	            
	        }
	        catch(IOException | InterruptedException ex) {
	            System.out.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
	            return;
	        }
	
		 

	}
}
