package pathfinder;

import java.util.ArrayList;

import util.Position;
import util.Zone;
import pathfinder.Node;

public class Pathfinder {
	private Position start;
	private Position[] goals;
	private Zone[] illegalZones;
	private ArrayList<Position> turnPoints;
	
	private AreaMap map;
	private AStarHeuristic heuristic;
	private AStar astar;
	
<<<<<<< HEAD
	public Pathfinder(Position start, Zone[] iz, Position[] goals){
		this.goals = goals;
		illegalZones = iz;
=======
	public Pathfinder(Position start, ArrayList<Position> goals, ArrayList<Zone> illegalZones){
		this.goals = goals;
		this.illegalZones = illegalZones;
>>>>>>> origin/master-develop
		map = new AreaMap(4000, 2000, this.illegalZones);
		heuristic = new ClosestHeuristic();
		astar = new AStar(map, heuristic);	
	}

	public ArrayList<Position> getTurnPoints(){
		return this.astar.shortestPath.getPathAsTurnPositions();
	}
	
	public void calculateRoute(int currentGoal){
		this.astar.calcShortestPath(this.start.getX(), this.start.getY(), 
				this.goals[currentGoal].getX(), this.goals[currentGoal].getY());
	}
	
}