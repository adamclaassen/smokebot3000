package comm;

import java.io.IOException;

import com.pi4j.wiringpi.Spi;
import com.pi4j.io.spi.*;

public class SPIWrapper {
	
	public SPIWrapper(){
		
	}
	public byte[] write(SpiDevice device, byte[] data){
		byte[] ret = null;
		try {
			return device.write(data);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		return ret;
	}
}


