package comm;

import util.Position;
import com.pi4j.wiringpi.Serial;


// int radio_id,double x,double y,double head (radians),double timer
public class Radio {
	int txPin;
	int rxPin;
	
	public Radio(){}
	
	public Position getCurrentPos(){
		return new Position(0,0,0);
	}
	
}
