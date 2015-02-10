package robot;

import java.util.ArrayList;

public class OSVStatus{
<<<<<<< HEAD
	private Position currentPos;
	private ArrayList<Position> posMap;
=======
	private Position currentLoc;
	private ArrayList<Position> locMap;
>>>>>>> FETCH_HEAD
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
		this.setCurrentPos(Integer.parseInt(dataList[0]),Integer.parseInt(dataList[1]),Integer.parseInt(dataList[2j]));
		this.setCurrentBatteryStatus(Integer.parseInt(dataList[3]));
		this.setCurrentDirection(Integer.parseInt(dataList[4]));
	}
	
<<<<<<< HEAD
	public OSVStatus(Position pos, int batStat, int dir){
		currentPos = pos;
=======
	public OSVStatus(Position loc, int batStat, int dir){
		currentLoc = loc;
>>>>>>> FETCH_HEAD
		currentBatteryStatus = batStat;
		currentDirection = dir;
	}
	
	public OSVStatus(int x, int y, int batStat, int dir){
		this.setCurrentPosition(x,y);
		currentBatteryStatus = batStat;
		currentDirection = dir;
	}
	
	public String getStatus(){
		String status = Integer.toString(this.getCurrentLocation().getX()) + "," + Integer.toString(this.getCurrentLocation().getY()) + "," + Integer.toString(currentBatteryStatus) + "," + Integer.toString(currentDirection);
		return status;
	}
	
	public Position getCurrentLocation(){
<<<<<<< HEAD
		return currentPos;
	}
	
	public void setCurrentCoord(Position pos){
		currentTime = System.currentTimeMillis();
		currentPos = pos;
		posMap.add(currentPos);
		timeMap.add(currentTime);
	}
	
	public void setCurrentCoord(int x, int y, int h){
		
=======
		return currentLoc;
	}
	
	public void setCurrentLocation(Position loc){
		if(currentLoc==null){
			currentTime = System.currentTimeMillis();
			currentLoc = loc;
		}
		else{
			timeMap.add(currentTime);
			locMap.add(currentLoc);
			currentTime = System.currentTimeMillis();
			currentLoc = loc;
		}
	}
	
	public void setCurrentLocation(int x, int y){
		if(currentLoc==null){
			currentLoc.setCoord(x,y);
		}
		else{
			locMap.add(currentLoc);
			currentLoc.setCoord(x, y);
		}
>>>>>>> FETCH_HEAD
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
		if(timeMap.size()<2 || locMap.size()<2){
			return 0;
		}
		else{
			double deltaX = Math.hypot((locMap.get(locMap.size()-1).getX()) - (locMap.get(locMap.size()-2).getX()),(locMap.get(locMap.size()-1).getX()) - (locMap.get(locMap.size()-2).getX()));
			long deltaT = timeMap.get(timeMap.size() - 1) - timeMap.get(timeMap.size() - 2);
			return (float)(deltaX/deltaT);
		}
	}
}