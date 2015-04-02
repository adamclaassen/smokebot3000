package motor;

import comm.SPI;


public class ArduinoMotorController extends Motor{

	private SPI spi;
	
	public ArduinoMotorController(int pin, SPI spibus) {
		super(pin, 0, 255);
		this.spi = spibus;
	}

	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
		//spi.write(appropriate data);
	}

}
