package robot;

public class pid {
	private int setpoint = 0;
	private int error = 0;
	private int prevError = 0;
	private int accumError = 0;
	private float kp = 0;
	private float ki = 0;
	private float kd = 0;
	
	public pid(float kp, float ki, float kd){
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
	}
	
	public void setSetpoint(int setpoint){
		this.setpoint=setpoint;
	}
	public int getSetpoint(){
		return this.setpoint;
	}
	public void setKp(float kp){
		this.kp = kp;
	}
	public float getKp(){
		return this.kp;
	}
	public void setKi(float ki){
		this.ki = ki;
	}
	public float getKi(){
		return this.ki;
	}
	public void setKd(float kd){
		this.kd = kd;
	}
	public float getKd(){
		return this.kd;
	}
	public int update(int signal){
		this.prevError = this.error;
		this.error = this.setpoint-signal;
		int diffError = this.error-this.prevError;
		this.accumError += this.error;
		return (int) ((this.error*this.kp)+(diffError*this.kd)+(this.accumError*this.ki) + 0.5);
	}
	
	
	
}
