package motor;



public class ArduinoMotorController extends Motor{
	
	public ArduinoMotorController(int pin) {
		super(pin, 0, 255);
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
		robot.SimpleRobot.ardu.setMotorSpeed(this.pin, speed);
	}
	
	public double getSpeed(){return this.speed;}

}
