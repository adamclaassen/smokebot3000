package pathfinder;

import pathfinder.AStarHeuristic;
import pathfinder.ClosestHeuristic;

public class TestAStar {
	
	private static int mapWith = 20;
	private static int mapHeight = 20;
	
	private static int[][] obstacleMap =   {{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
											{0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
											{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
											{0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,0,0},
											{0,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0},
											{0,0,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,0},
											{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0},
											{0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0},
											{0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0},
											{0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
	
	private static int startX = 0;
	private static int startY = 1;
	private static int goalX = 15;
	private static int goalY = 15;
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Map initializing...");
		AreaMap map = new AreaMap(mapWith, mapHeight, obstacleMap);
		
		System.out.println("Heuristic initializing...");
		AStarHeuristic heuristic = new ClosestHeuristic();
		
		System.out.println("Pathfinder initializing...");
		AStar pathFinder = new AStar(map, heuristic);
		
		System.out.println("Calculating shortest path...");
		pathFinder.calcShortestPath(startX, startY, goalX, goalY);
		
		
		
		System.out.println("Printing map of shortest path...");
		pathFinder.printPath();
		
		System.out.println("Path points");
		Path tester = new Path();
		System.out.println(tester.getPath());
		
	}

}