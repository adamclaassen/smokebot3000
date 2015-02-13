package robot;


public abstract class Robot {
	
	
	public Robot(){
		
	}
	
	public abstract void drive(int speed, int turn);
	
	public abstract void dataCollect();
	
	public abstract void secondaryAction();
	
	public abstract void test();
}
