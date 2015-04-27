package pathfinder;

import java.util.ArrayList;

import util.Position;

public class Path {
        // The waypoints in the path (list of coordiantes making up the path)
        private ArrayList<Node> waypoints = new ArrayList<Node>();
        private ArrayList<Position> turnPoints = new ArrayList<Position>();
        
        public Path() {
        }
        
        public int getLength() {
                return waypoints.size();
        }
        
        public ArrayList<Node> getPathAsNodes(){
        	return waypoints;
        }
        
        public ArrayList<Position> getPathAsTurnPositions(){
        	//implement path vector change detections
        	//check if node position relation changes
        	//return list of nodes where it does, as positions
        	ArrayList<Position> turnPoints = new ArrayList<Position>();
        	ArrayList<Position> waypointPos = new ArrayList<Position>();
        	
        	for(Node node:this.waypoints){
        		waypointPos.add(new Position(node.getX(), node.getY()));
        	}
        	
        	for(int i = 1; i<waypointPos.size()-1; i++){
        		if(waypointPos.get(i).getHeadTo(waypointPos.get(i-1)) == waypointPos.get(i).getHeadTo(waypointPos.get(i+1))){
        			turnPoints.add(waypointPos.get(i));
        		}
        	}
        	
        	return waypointPos;
        }

        public Node getWayPoint(int index) {
                return waypoints.get(index);
        }

        /**
         * Get the x-coordinate for the waypoiny at the given index.
         * 
         * @param index The index of the waypoint to get the x-coordinate of.
         * @return The x coordinate at the waypoint.
         */
        public int getX(int index) {
                return getWayPoint(index).getX();
        }

        /**
         * Get the y-coordinate for the waypoint at the given index.
         * 
         * @param index The index of the waypoint to get the y-coordinate of.
         * @return The y coordinate at the waypoint.
         */
        public int getY(int index) {
                return getWayPoint(index).getY();
        }

        /**
         * Append a waypoint to the path.  
         * 
         * @param x The x coordinate of the waypoint.
         * @param y The y coordinate of the waypoint.
         */
        public void appendWayPoint(Node n) {
                waypoints.add(n);
        }

        /**
         * Add a waypoint to the beginning of the path.  
         * 
         * @param x The x coordinate of the waypoint.
         * @param y The y coordinate of the waypoint.
         */
        public void prependWayPoint(Node n) {
                waypoints.add(0, n);
        }

        /**
         * Check if this path contains the WayPoint
         * 
         * @param x The x coordinate of the waypoint.
         * @param y The y coordinate of the waypoint.
         * @return True if the path contains the waypoint.
         */
        public boolean contains(int x, int y) {
                for(Node node : waypoints) {
                        if (node.getX() == x && node.getY() == y)
                                return true;
                }
                return false;
        }

}