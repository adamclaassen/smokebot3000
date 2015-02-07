package robot;

import robot.sensor;


public class analogSensor implements sensor {
	
	private int pin;
	
	public analogSensor(int pin){
		this.pin = pin;
	}
	public int read() {
		return 0;
	}

}
