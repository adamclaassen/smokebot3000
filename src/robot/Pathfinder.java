package robot;

import java.util.ArrayList;

public class Pathfinder {
	private Position start;
	private ArrayList<Position> goals;
	private int currentTurnPoint;
	private ArrayList<Zone> illegalZones;
	private ArrayList<Position> turnPoints;
	
	public Pathfinder(Position start){
		this.start = start;
	}
	
	public Pathfinder(Position start, ArrayList<Position> goals){
		this(start);
		this.goals = goals;
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
	
	public void reachedTurnPoint(){
		this.currentTurnPoint++;
	}
	
	public boolean isAtGoal(Position pos){
		for(Position goal:this.goals){
			if(pos.isNearby(goal)){
				return true;
			}
		}
		return false;
	}
}