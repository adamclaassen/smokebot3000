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
		byte[] data = null;
		
		int red;
		int green;
		int blue;
		
		try {
			this.color.read(0x16, data, 0, 2);
			this.color.read(0x18, data, 2, 2);
			this.color.read(0x1A, data, 4, 2);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		
		red = data[0] << 8;
		red |= data[1];
		
		green = data[2] << 8; 
		green |= data[3];
		
		blue = data[4] << 8;
		blue |= data[5];
		
		int[] ret = {red, green, blue};
		return ret;
	}

}
