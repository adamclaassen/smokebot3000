package pathfinder;

import java.util.ArrayList;

import util.Position;
import util.Zone;
import pathfinder.Node;

public class Pathfinder {
	private Position start;

	private Position goals;
	private ArrayList<Zone> illegalZones;
	private ArrayList<Position> turnPoints;
	
	private AreaMap map;
	private AStarHeuristic heuristic;
	private AStar astar;
	

	public Pathfinder(Position start, Position goals, ArrayList<Zone> illegalZones){
		this.goals = goals;
		this.illegalZones = illegalZones;
		map = new AreaMap(4000, 2000, this.illegalZones);
		heuristic = new ClosestHeuristic();
		astar = new AStar(map, heuristic);	
	}

	public ArrayList<Position> getTurnPoints(){
		return this.astar.shortestPath.getPathAsTurnPositions();
	}
	
	public void calculateRoute(int currentGoal){
		this.astar.calcShortestPath(this.start.getX(), this.start.getY(), 
				this.goals.getX(), this.goals.getY());
	}
	
	public void addIllegalZone(Zone illegalZone){
		this.illegalZones.add(illegalZone);
	}
	
	public void updateStart(Position newStart){
		this.start = newStart;
		this.calculateRoute();
	}
}