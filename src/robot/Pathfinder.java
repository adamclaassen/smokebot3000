package robot;

import java.util.ArrayList;

public class Pathfinder {
	private Position start;
	private Position end;
	private int currentTurnPoint;
	private ArrayList<Zone> illegalZones;
	private ArrayList<Position> turnPoints;
	
	public Pathfinder(Position start){
		this.start = start;
	}
	
	public Pathfinder(Position start, Position end){
		this(start);
		this.end = end;
	}

	public ArrayList<Position> getTurnPoints(){
		return this.turnPoints;
	}
	
	public void calulateRoute(){
		
	}
	
	public void addIllegalZone(Zone illegalZone){
		this.illegalZones.add(illegalZone);
	}
	
	public Position getNextTurnPoint(){
		return this.turnPoints.get(this.currentTurnPoint+1);
	}
}