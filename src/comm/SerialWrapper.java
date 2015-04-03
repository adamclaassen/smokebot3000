package comm;

import com.pi4j.io.serial.*;

public class SerialWrapper {
	
	final Serial serial;
	
	public SerialWrapper(){
		this.serial = SerialFactory.createInstance();
		serial.addListener();
	}
}
