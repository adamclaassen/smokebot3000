package comm;

import util.Position;
import com.pi4j.wiringpi.Serial;


// int radio_id,double x,double y,double head (radians),double timer
public class Radio {
	int txPin;
	int rxPin;
	int fd;
	
	public Radio(){
		fd = Serial.serialOpen("/dev/ttyAMA0", 115200);
		Serial.serialFlush(fd);
		
	}
	
	@SuppressWarnings("deprecation")
	public Position getCurrentPos(){
		int dataAvail = Serial.serialDataAvail(this.fd);
		char[] serialChars = new char[dataAvail];
		
		for(int i = 0; i< dataAvail; i++){
			serialChars[i] = (char) Serial.serialGetchar(fd);
		}
		
		String[] splitData = String.copyValueOf(serialChars).split(",");
		return new Position(
				(int) (1000* Double.parseDouble(splitData[1])),
				(int) (1000* Double.parseDouble(splitData[2])),
				(int) Double.parseDouble(splitData[3])
				);
	}
	
}
