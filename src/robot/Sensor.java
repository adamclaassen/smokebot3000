package robot;

public abstract class Sensor {
	
	private float inputHigh;
	private float inputLow;
	
	public Sensor(float inputHigh, float inputLow){
		this.inputHigh = inputHigh;
		this.inputLow = inputLow;
	}
	abstract Object read();
	
	@SuppressWarnings("unused")
	private int mapFromInput(float input){
		  return (int) ((input - this.inputLow) * (100 - 0) / (this.inputHigh - this.inputLow) + 0 + 0.5);
	}
}
