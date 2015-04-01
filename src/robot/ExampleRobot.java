package robot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExampleRobot extends Robot{
	Motor left = new Motor(0, 0, 0);
	Motor right = new Motor(0, 0, 0);
	Sensor sensor = new ExampleSensor(1);
	
	public ExampleRobot(){
		this.commandList.add(() -> this.drive(1, 0)); // java 8 tip: `() -> method()` is called a lambda.
		this.commandList.add(() -> this.drive(0, 0)); // add lambdas to commandList with the method you want to run
													  // in the order they should be run. You can use the methods
													  // defined below, or define your own. However, they must take no
													  // arguments and be of void return type. You can also replace the commands 
		
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
	
	public void customMethodOne(){
		
	}
	

}
