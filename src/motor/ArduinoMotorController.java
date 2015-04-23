package motor;

import com.pi4j.wiringpi.Spi;


public class ArduinoMotorController extends Motor{
	
	public ArduinoMotorController(int pin) {
		super(pin, 0, 255);
	}

	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
		byte scaledSpeed = (byte) this.mapToOutput(speed);
		byte[] dataArray = {scaledSpeed, (byte) this.pin};
		Spi.wiringPiSPIDataRW(Spi.CHANNEL_1, dataArray);
	}
	
	public double getSpeed(){return this.speed;}

}
