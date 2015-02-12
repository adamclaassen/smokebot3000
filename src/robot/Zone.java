package robot;

import java.util.ArrayList;

public class Zone {
	
	private ArrayList<Position> boundaryPoints;
	
	public Zone(ArrayList<Position> points){
		this.boundaryPoints.addAll(points);
	}
	public Zone(){}
	
	public ArrayList<Position> getPoints(){
		return this.boundaryPoints;
	}
	public Position getPoint(int index){
		return this.boundaryPoints.get(index);
	}
	public void addPoint(Position pos){
		this.boundaryPoints.add(pos);
	}
	public void addPoints(ArrayList<Position> pos){
		this.boundaryPoints.addAll(pos);
	}
	public boolean isInZone(Position pos){
			return false;
	}
	
}
