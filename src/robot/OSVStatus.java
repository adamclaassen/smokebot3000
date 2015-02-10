package robot;

import java.util.ArrayList;

public class OSVStatus{
	private Position currentPos;
	private ArrayList<Position> posMap;
	private Long currentTime;
	private ArrayList<Long> timeMap;
	private int currentBatteryStatus;
	private int currentDirection;

	public OSVStatus(){}
	
	//gets all values from a string of data from the program running on the Pi;
	//If we're using Java though, we can just instantiate it with all the values.
	//Format: "x-Coordinate,y-Coordinate,batteryStatus,direction
	public OSVStatus(String data){
		String[] dataList = data.split(",");
		this.setCurrentPos(Integer.parseInt(dataList[0]),Integer.parseInt(dataList[1]),Integer.parseInt(dataList[2]));
		this.setCurrentBatteryStatus(Integer.parseInt(dataList[3]));
		this.setCurrentDirection(Integer.parseInt(dataList[4]));
	}

	public OSVStatus(Position pos, int batStat, int dir){
		currentPos = pos;
		currentBatteryStatus = batStat;
		currentDirection = dir;
	}
	
	public OSVStatus(int x, int y, int h, int batStat, int dir){
		this.setCurrentPos(x,y,h);
		currentBatteryStatus = batStat;
		currentDirection = dir;
	}
	
	public String getStatus(){
		String status = Integer.toString(this.getCurrentLocation().getX()) + "," + Integer.toString(this.getCurrentLocation().getY()) + "," + Integer.toString(currentBatteryStatus) + "," + Integer.toString(currentDirection);
		return status;
	}
	
	public Position getCurrentLocation(){
		return currentPos;
	}
	
	
	public void setCurrentPos(Position pos){
		if(currentPos==null){
			currentTime = System.currentTimeMillis();
			currentPos = pos;
		}
		else{
			timeMap.add(currentTime);
			posMap.add(currentPos);
			currentTime = System.currentTimeMillis();
			currentPos = pos;
		}
	}
	
	public void setCurrentPos(int x, int y,int h){
		if(currentPos==null){
			currentPos.setPos(x,y,h);
		}
		else{
			posMap.add(currentPos);
			currentPos.setPos(x,y,h);
		}
	}
	
	public int getCurrentBatteryStatus(){
		return currentBatteryStatus;
	}
	
	public void setCurrentBatteryStatus(int batStat){
		currentBatteryStatus = batStat;
	}
	
	public int getCurrentDirection(){
		return currentDirection;
	}
	public void setCurrentDirection(int dir){
		currentDirection = dir;
	}
	
	public float getCurrentSpeed(){
		if(timeMap.size()<2 || posMap.size()<2){
			return 0;
		}
		else{
			double deltaX = Math.hypot((posMap.get(posMap.size()-1).getX()) - (posMap.get(posMap.size()-2).getX()),(posMap.get(posMap.size()-1).getX()) - (posMap.get(posMap.size()-2).getX()));
			long deltaT = timeMap.get(timeMap.size() - 1) - timeMap.get(timeMap.size() - 2);
			return (float)(deltaX/deltaT);
		}
	}
}