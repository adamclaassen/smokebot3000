package sensor;

import com.pi4j.wiringpi.I2C;

public class LidarLite extends Sensor{
	
	//address info
	private int lidarDevice;
	private int lidarDevAddr = 0x62;
	private int enableMeasureReg;
	private int enableMeasureVal;
	private int regHighLow;
	
	//constants 
	private final int nack = 1;
	

	public LidarLite(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		this.lidarDevice = I2C.wiringPiI2CSetup(this.lidarDevAddr);
		I2C.wiringPiI2CWriteReg8(this.lidarDevice, this.enableMeasureReg, this.enableMeasureVal);
	}

	@Override
	public Integer read() {
		int ackStatus = -1;
		I2C.wiringPiI2CWriteReg8(this.lidarDevice, this.enableMeasureReg, this.enableMeasureVal);
		while(ackStatus == nack){
			ackStatus = I2C.wiringPiI2CReadReg16(this.lidarDevice, this.regHighLow);
		}
		
		return ackStatus;
		
	}
}
