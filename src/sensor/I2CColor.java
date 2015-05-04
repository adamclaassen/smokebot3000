package sensor;

import com.pi4j.io.i2c.*;
import com.pi4j.io.i2c.impl.I2CDeviceImpl;

public class I2CColor extends Sensor{
	I2CDeviceImpl color;

	public I2CColor(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		color = new I2CDeviceImpl(robot.SimpleRobot.i2c.bus, 0x29);
	}
	
	public Double read(){
		return (double) robot.SimpleRobot.i2c.read(color);
	}

}
