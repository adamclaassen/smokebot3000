package sensor;

import com.pi4j.wiringpi.I2C;

public class LidarLite extends Sensor{
	
	private int lidarDevice;
	private int lidarDevAddr = 0x62;
	private int enableMeasureReg;
	private int enableMeasureVal;
	private int regHighLow;

	public LidarLite(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		this.lidarDevice = I2C.wiringPiI2CSetup(this.lidarDevAddr);
		I2C.wiringPiI2CWriteReg8(this.lidarDevice, this.enableMeasureReg, this.enableMeasureVal);
	}

	@Override
	public Integer read() {
		return I2C.wiringPiI2CReadReg16(this.lidarDevice, this.regHighLow);
	}
}
