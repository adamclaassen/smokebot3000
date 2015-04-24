package pathfinder;

import java.util.ArrayList;

import util.Position;
import util.Zone;

public class Pathfinder {
	private Position start;
	private Position[] goals;
	private Zone[] illegalZones;
	private ArrayList<Position> turnPoints;
	
	private AreaMap map;
	private AStarHeuristic heuristic;
	private AStar astar;
	
	public Pathfinder(Position start, Zone[] iz, Position[] goals){
		this.goals = goals;
		illegalZones = iz;
		map = new AreaMap(4000, 2000, this.illegalZones);
		heuristic = new ClosestHeuristic();
		astar = new AStar(map, heuristic);	
	}

	public ArrayList<Position> getTurnPoints(){
		return this.turnPoints;
	}
	
	public void calculateRoute(int currentGoal){
		this.astar.calcShortestPath(this.start.getX(), this.start.getY(), 
				this.goals[currentGoal].getX(), this.goals[currentGoal].getY());
	}
	
}