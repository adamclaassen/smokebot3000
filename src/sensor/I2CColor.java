package sensor;

import java.io.IOException;

import com.pi4j.io.i2c.*;

public class I2CColor extends Sensor{
	I2CDevice color;
	public I2CColor(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		try {
			color = robot.SimpleRobot.i2c.bus.getDevice(0x29);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
	}
	
	public int[] read(){
		byte redLow, redHigh, greenLow, greenHigh, blueLow, blueHigh;
		
		int red, green, blue;
		
		try {
			
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		System.out.println("debug 1");

		int[] ret = {red, green, blue};
		return ret;
	}

}
