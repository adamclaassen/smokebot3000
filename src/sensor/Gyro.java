package sensor;

import java.io.IOException;

import com.pi4j.io.i2c.*;

public class Gyro extends Sensor{
	I2CDevice gyro;
	public Gyro(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		try {

			gyro = robot.SimpleRobot.i2c.bus.getDevice(0x68);
			gyro.write(0x6B, (byte) 0);

		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		
		
	}


	public int[] read() {
		int x = 0, y =0  , z = 0;
		
		try {
			x = gyro.read(0x43) << 8 | gyro.read(0x44);
			y = gyro.read(0x45) << 8 | gyro.read(0x46);
			z = gyro.read(0x47) << 8 | gyro.read(0x48);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
		
		return new int[]{x, y, z};

	}
	
	

}
