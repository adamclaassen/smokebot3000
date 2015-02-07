package robot;

public class Motor {
	private int pin;
	private int outputLow;
	private int outputHigh;
	private int speed;
	
	public Motor(int pin, int outputLow, int outputHigh){
		this.pin = pin;
		this.outputLow = outputLow;
		this.outputHigh = outputHigh;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
		mapToOutput(speed);
	}
	public int getSpeed(){
		return this.speed;
	}
	public int getPin(){
		return this.pin;
	}
	private int mapToOutput(int x){
		  return (x - 0) * (this.outputHigh - this.outputLow) / (100 - 0) + this.outputLow;
		}
}
