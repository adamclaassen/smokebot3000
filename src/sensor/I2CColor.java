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
		int red = 0, green = 0, blue = 0;
		
		try {
			red = color.read(0x17) << 8 | color.read(0x16);
			green = color.read(0x18) << 8 | color.read(0x19);
			blue = color.read(0x20) << 8 | color.read(0x21);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		//System.out.println("debug 1");

		int[] ret = {red, green, blue};
		return ret;
	}

}
