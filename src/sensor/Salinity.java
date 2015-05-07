package sensor;
import util.ArduinoAdapter;
public class Salinity extends Sensor{
	ArduinoAdapter ard = new ArduinoAdapter();
	Double sal;
	
	public Salinity(float inputHigh, float inputLow){
		super(inputHigh, inputLow);
	}
	
	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	public Double read(){
		Double sal = Double.parseDouble(robot.SimpleRobot.arduinoSerial.read().split("<|>")[1].split("/")[1]);
		this.sal = sal;
		return this.sal;
	}
	public Double read(String msg){
		Double sal = Double.parseDouble(msg.split("<|>")[1].split("/")[1]);
		this.sal = sal;
		return this.sal;
	}
}