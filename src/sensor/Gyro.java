package sensor;

import java.io.IOException;

import com.pi4j.io.i2c.*;

public class Gyro extends Sensor{
	I2CDevice gyro;
	public Gyro(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		try {
			gyro = robot.SimpleRobot.i2c.bus.getDevice(0*68);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		
		
	}

	Object read() {
		return (double) robot.SimpleRobot.i2c.read(gyro);
	}
	
	

}
