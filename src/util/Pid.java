package util;

public class Pid {
	private double setpoint = 0;
	private double error = 0;
	private double prevError = 0;
	private double accumError = 0;
	private double kp;
	private double ki;
	private double kd;
	
	public Pid(double p, double i, double d){
		this.kp = p; this.ki = i; this.kd = d;
	}
	
	public void setSetpoint(double d){this.setpoint=d;}
	public double getSetpoint(){return this.setpoint;}
	public void setKp(float kp){this.kp = kp;}
	public double getKp(){return this.kp;}
	public void setKi(float ki){this.ki = ki;}
	public double getKi(){return this.ki;}
	public void setKd(float kd){this.kd = kd;}
	public double getKd(){return this.kd;}
	public double update(int signal){
		this.prevError = this.error;
		this.error = this.setpoint-signal;
		double diffError = this.error-this.prevError;
		this.accumError += this.error;
		return ((this.error*this.kp)+(diffError*this.kd)+(this.accumError*this.ki) + 0.5);
	}
}
