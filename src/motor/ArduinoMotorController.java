package motor;



public class ArduinoMotorController extends Motor{
	
	public ArduinoMotorController(int pin) {
		super(pin, 0, 255);
	}

	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
		
	}
	
	public double getSpeed(){return this.speed;}

}
