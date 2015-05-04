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
		byte redHigh = 0;
		byte redLow = 0;
		byte blueHigh = 0;
		byte blueLow = 0;
		byte greenHigh = 0;
		byte greenLow = 0;
		
		int red;
		int green;
		int blue;
		
		try {
			redLow = (byte) this.color.read(0x16);
			redHigh = (byte) this.color.read(0x17);
			
			blueLow = (byte) this.color.read(0x1A);
			blueHigh = (byte) this.color.read(0x1B);
			
			greenLow = (byte) this.color.read(0x18);
			greenHigh = (byte) this.color.read(0x19);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		System.out.println(redLow);
		System.out.println(redHigh);
		
		red = redHigh << 8;
		red |= redLow;
		
		green = greenHigh << 8;
		green |= greenLow;
		
		blue = blueHigh << 8;
		blue |= blueLow;
		int[] ret = {red, green, blue};
		return ret;
	}

}
