package robot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExampleRobot extends Robot{
	Motor left = new Motor(0, 0, 0);
	Motor right = new Motor(0, 0, 0);
	Sensor sensor = new ExampleSensor(1);
	Runnable command1;
	Runnable command2;
	
	public ExampleRobot(){
		this.commandList.add(command1 = () -> this.drive(0, 0));
	}
	
	public void drive(int speed, int turn) {
		//make sure drive is out-of-bounds safe
	}
	
	
	public void dataCollect() {
		
	}

	
	public void secondaryAction() {
		
	}

	
	public void test() {
				
	}

	
	public void sendSensorValue() {
		
		
	}

	@Override
	public void sendBattStatus() {
		// TODO Auto-generated method stub
		
	}
	

}
