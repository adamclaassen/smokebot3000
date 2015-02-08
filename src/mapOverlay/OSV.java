package mapOverlay;
import java.util.ArrayList;

public class OSV{
	private Location currentLoc;
	private ArrayList<Location> locMap;
	private Long currentTime;
	private ArrayList<Long> timeMap;
	private int currentBatteryStatus;
	private int currentDirection;

	public OSV(){}
	
	//gets all values from a string of data from the program running on the Pi;
	//If we're using Java though, we can just instantiate it with all the values.
	//Format: "x-Coordinate,y-Coordinate,batteryStatus,direction
	public OSV(String data){
		String[] dataList = data.split(",");
		this.setCurrentLocation(Integer.parseInt(dataList[0]),Integer.parseInt(dataList[1]));
		this.setCurrentBatteryStatus(Integer.parseInt(dataList[2]));
		this.setCurrentDirection(Integer.parseInt(dataList[3]));
	}
	
	public OSV(Location loc, int batStat, int dir){
		currentLoc = loc;
		currentBatteryStatus = batStat;
		currentDirection = dir;
	}
	
	public OSV(int x, int y, int batStat, int dir){
		this.setCurrentLocation(x,y);
		currentBatteryStatus = batStat;
		currentDirection = dir;
	}
	
	public String getStatus(){
		String status = Integer.toString(this.getCurrentLocation().getX()) + "," + Integer.toString(this.getCurrentLocation().getY()) + "," + Integer.toString(currentBatteryStatus) + "," + Integer.toString(currentDirection);
		return status;
	}
	
	public Location getCurrentLocation(){
		return currentLoc;
	}
	
	public void setCurrentLocation(Location loc){
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
			currentLoc.setLocation(x,y);
		}
		else{
			locMap.add(currentLoc);
			currentLoc.setLocation(x, y);
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