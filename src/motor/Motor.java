package motor;

public abstract class Motor {
	protected int pin;
	protected int outputLow;
	protected int outputHigh;
	protected double speed;
	protected util.ArduinoAdapter ard = new util.ArduinoAdapter();
	
	public Motor(int pin, int outputLow, int outputHigh){
		this.pin = pin;
		this.outputLow = outputLow;
		this.outputHigh = outputHigh;
	}
	
	public void setSpeed(double speed){
		ard.setMotorSpeed(pin, speed);
	}
	
	public double getSpeed(){
		return this.speed;
	}
	public int getPin(){
		return this.pin;
	}
	protected double mapToOutput(double x){
		  return (x - 0) * (this.outputHigh - this.outputLow) / (100 - 0) + this.outputLow;
	}
	
}
