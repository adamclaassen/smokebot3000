
public class sensor {
	int pin;
	int inputLow;
	int inputHigh;
	
	public sensor(int pin, int inputLow, int inputHigh){
		this.pin = pin;
		this.inputLow = inputLow;
		this.inputHigh = inputHigh;
	}
	public int read(){
		return 0;
	}
	public int getPin(){
		return this.pin;
	}
}
