package robot;

import java.util.ArrayList;

public class Pathfinder {
	private Position start;
	private Position end;
	private ArrayList<Zone> illegalZones;
	
	public Pathfinder(Position start){
		this.start = start;
	}
	public Pathfinder(Position start, Position end){
		this(start);
		this.end = end;
	}
	
	
	

}