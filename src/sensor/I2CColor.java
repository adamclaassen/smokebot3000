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
	
	public Double read(){
		return (double) robot.SimpleRobot.i2c.read(color);
	}

}
