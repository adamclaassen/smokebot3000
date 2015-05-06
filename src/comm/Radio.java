package comm;

import util.Position;
import comm.SerialWrapper;


// int radio_id,double x,double y,double head (radians),double timer
public class Radio {
	
	public SerialWrapper radioSer;
	
	public Radio(){
		radioSer = new SerialWrapper("/dev/ttyAMA0");
	}
	
	public Position getCurrentPos(){
		
		String rawInput = this.radioSer.read(); 
		String lastPos = rawInput.substring(rawInput.lastIndexOf('[')+1, rawInput.lastIndexOf(']'));
		String[] splitData = lastPos.split(",");
		return new Position(
				(int) (1000* Double.parseDouble(splitData[1])),
				(int) (1000* Double.parseDouble(splitData[2])),
				(int) Double.parseDouble(splitData[3])
				);
	}
	
}
