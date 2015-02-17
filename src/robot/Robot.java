package robot;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public abstract class Robot {
	
	protected Position currentPos;
	protected Pathfinder pathfinder;
	protected Pid distPid;
	protected Pid turnPid;
	protected Radio radio;
	
	private int inetPort;
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedWriter writer;
	
	public Robot(){
		this.radio = new Radio(0,0);
		//this.currentPos = new Position(Radio.something);
		this.pathfinder = new Pathfinder(this.currentPos);
		this.distPid = new Pid(0.0, 0.0, 0.0);
		this.turnPid = new Pid(0.0, 0.0, 0.0);
	}
	
	public void startSocket(){
		try {
			this.serverSocket = new ServerSocket(this.inetPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.socket = this.serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
