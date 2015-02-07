package robot;

import java.io.IOException;

public class Gpio {
	private int pin;
	private int value;
	private String direction;
	
	public Gpio(int pin, String direction){
		this.pin = pin;
		this.direction = direction;
		
		try{
			Process makePin = Runtime.getRuntime().exec(String.format("echo %d > /sys/class/gpio/export", this.pin));
			makePin.waitFor();
			Process setDir = Runtime.getRuntime().exec(String.format("echo %s > /sys/class/gpio/gpio%d/direction",this.direction, this.pin));
			setDir.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Gpio(int pin, String direction, int value){
		
	}
	
	public void set(int value){
		this.value = value;
		try {
			Process setValue = Runtime.getRuntime().exec(String.format("echo %d > /sys/class/gpio/gpio%d/value", this.value, this.pin));
			setValue.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int get(){
		return this.value;
	}
	public void destroy(){
		Process destroy;
		try {
			destroy = Runtime.getRuntime().exec(String.format("echo %d > /sys/class/gpio/unexport", this.pin));
			destroy.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
