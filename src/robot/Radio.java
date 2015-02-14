package robot;
// int radio_id,double x,double y,double head (radians),double timer
public class Radio {
	int txPin;
	int rxPin;
	
	public Radio(int txPin, int rxPin){
		this.txPin = txPin;
		this.rxPin = rxPin;
	}
	
}
