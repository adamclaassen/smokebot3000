package pathfinder;

import java.util.ArrayList;

import util.Position;
import util.Zone;

public class Pathfinder {
	private Position start;
	private ArrayList<Position> goals;
	private ArrayList<Zone> illegalZones;
	private ArrayList<Position> turnPoints;
	
	private AreaMap map;
	private AStarHeuristic heuristic;
	private AStar astar;
	
	public Pathfinder(Position start, ArrayList<Position> goals, ArrayList<Zone> illegalZones){
		this.goals = goals;
		this.illegalZones = illegalZones;
		map = new AreaMap(4000, 2000, this.illegalZones);
		heuristic = new ClosestHeuristic();
		astar = new AStar(map, heuristic);
		this.calculateRoute();
	}

	public ArrayList<Position> getTurnPoints(){
		return this.turnPoints;
	}
	
	public void calculateRoute(){
		this.astar.calcShortestPath(this.start.getX(), this.start.getY(), 
				this.goals.get(0).getX(), this.goals.get(0).getY());
	}
	
	public void addIllegalZone(Zone illegalZone){
		this.illegalZones.add(illegalZone);
	}
	
	public void updateStart(Position newStart){
		this.start = newStart;
		this.calculateRoute();
	}
	
	public void switchToNextGoal(){
		this.goals.remove(0);
	}
}