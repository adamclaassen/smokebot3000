package motor;

import comm.SPIWrapper;


public class ArduinoMotorController extends Motor{

	private SPIWrapper spi;
	
	public ArduinoMotorController(int pin, SPIWrapper spibus) {
		super(pin, 0, 255);
		this.spi = spibus;
	}

	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
		//spi.write(appropriate data);
	}

}
