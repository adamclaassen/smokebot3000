package sensor;
import util.ArduinoAdapter;
public class Salinity extends Sensor{
	ArduinoAdapter ard = new ArduinoAdapter();
	
	public Salinity(float inputHigh, float inputLow){
		super(inputHigh, inputLow);
	}
	
	public Double read(){
		return Double.parseDouble(robot.SimpleRobot.serial.read().split("<|>")[1].split("/")[1]);
	}
	public Double read(String msg){
		return Double.parseDouble(msg.split("<|>")[1].split("/")[1]);
	}
}