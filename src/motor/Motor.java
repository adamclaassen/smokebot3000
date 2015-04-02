package motor;

public abstract class Motor {
	protected int pin;
	protected int outputLow;
	protected int outputHigh;
	protected double speed;
	
	public Motor(int pin, int outputLow, int outputHigh){
		this.pin = pin;
		this.outputLow = outputLow;
		this.outputHigh = outputHigh;
	}
	
	public abstract void setSpeed(double speed);
	
	public double getSpeed(){
		return this.speed;
	}
	public int getPin(){
		return this.pin;
	}
	private double mapToOutput(double x){
		  return (x - 0) * (this.outputHigh - this.outputLow) / (100 - 0) + this.outputLow;
	}
	
}
