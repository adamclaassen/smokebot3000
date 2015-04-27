package comm;

import com.pi4j.wiringpi.Spi;

public class SPIWrapper {
	public SPIWrapper(){}
	public void write(byte[] data){
		Spi.wiringPiSPIDataRW(0, data);
		
	}
}


