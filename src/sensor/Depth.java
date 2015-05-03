package sensor;

public class Depth extends Sensor{
	Double depth;
	public Depth(int inputHigh, int inputLow){
		super(inputHigh, inputLow);
	}
	public Double read(){
		Double d = Double.parseDouble(robot.SimpleRobot.serial.read().split("<|>")[1].split("/")[1]);
		depth = d;
		return depth;
	}
	public Double read(String msg){
		Double d = Double.parseDouble(msg.split("<|>")[1].split("/")[1]);
		depth = d;
		return depth;
	}
	public Double getDepth(){
		return depth;
	}
	
	public void setDepth(Double d){
		depth = d;
	}
}
