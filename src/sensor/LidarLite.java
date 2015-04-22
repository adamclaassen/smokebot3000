package sensor;

import com.pi4j.wiringpi.I2C;

public class LidarLite extends Sensor{
	
	private I2C i2cbus;

	public LidarLite(I2C i2cBus, float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		this.i2cbus = i2cBus;
	}

	@Override
	Object read() {
		// TODO Auto-generated method stub
		return null;
	}

}
