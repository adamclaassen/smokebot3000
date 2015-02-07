package robot;

import robot.Sensor;


public class AnalogSensor implements Sensor {
	
	private int pin;
	
	public AnalogSensor(int pin){
		this.pin = pin;
	}
	public int read() {
		return 0;
	}

}
