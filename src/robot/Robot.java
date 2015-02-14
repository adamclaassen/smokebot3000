package robot;


public abstract class Robot {
	
	protected Position currentPos;
	protected Pathfinder pathfinder;
	protected Pid pid;
	protected Radio radio;
	protected Gpio gpio;
	public Robot(){
		
	}
	public void startSocket(){
		
	}
	
	public abstract void drive(int speed, int turn);
	
	public abstract void dataCollect();
	
	public abstract void secondaryAction();
	
	public abstract void test();
	
	public void sendPosition(Position currentPos){
		
	}
	
	public void sendBattStatus(){
		
	}
	
	public void sendPath(){
		
	}
	
	public abstract void sendSensorValue();
}
