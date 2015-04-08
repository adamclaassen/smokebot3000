package util;

import java.util.ArrayList;

public class Pathfinder {
	private Position start;
	private ArrayList<Position> goals;
	private ArrayList<Zone> illegalZones;
	private ArrayList<Position> turnPoints;
	
	public Pathfinder(Position start){
		this.start = start;
		//pathfind
	}
	
	public Pathfinder(Position start, ArrayList<Position> goals){
		this(start);
		this.goals = goals;
		this.calculateRoute();
	}

	public ArrayList<Position> getTurnPoints(){
		return this.turnPoints;
	}
	
	public void calculateRoute(){
		
	}
	
	public void addIllegalZone(Zone illegalZone){
		this.illegalZones.add(illegalZone);
	}
	
	public void updateStart(Position newStart){
		this.start = newStart;
		this.calculateRoute();
	}
}