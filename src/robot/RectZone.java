package robot;

import java.util.ArrayList;

public class RectZone {
	private Position upperLeft;
	private Position upperRight;
	private Position lowerLeft;
	private Position lowerRight;
	
	public RectZone(Position center, int distToEdge){
		this.upperLeft.setCoord(center.getX()-distToEdge, center.getY()+distToEdge);
		this.upperRight.setCoord(center.getX()+distToEdge, center.getY()+distToEdge);
		this.lowerLeft.setCoord(center.getX()-distToEdge, center.getY()-distToEdge);
		this.lowerRight.setCoord(center.getX()+distToEdge, center.getY()-distToEdge);
	}
	
	public RectZone(Position upperLeft, Position lowerRight){
		this.upperLeft = upperLeft;
		this.lowerRight = lowerRight;
		this.upperRight.setCoord(this.lowerRight.getX(), this.upperLeft.getY());
		this.lowerLeft.setCoord(this.upperLeft.getX(), this.lowerRight.getY());
	}
	
	public ArrayList<Position> getWallPositions(){
		ArrayList<Position> walls = new ArrayList<Position>();
		for(int i = 0; i<(this.upperRight.getX()-this.upperLeft.getX()); i++){
			walls.add(new Position( i, upperRight.getY() ));
		}
		for(int i = 0; i<(this.upperRight.getY()-this.lowerRight.getY()); i++){
			walls.add(new Position(this.upperRight.getX(), i));
		}
		for(int i = 0; i<(this.lowerRight.getX()-this.lowerLeft.getX()); i++){
			walls.add(new Position(i, this.lowerRight.getY()));
		}
		for(int i = 0; i<(this.upperLeft.getY()-this.lowerLeft.getY()); i++){
			walls.add(new Position(this.lowerLeft.getY(), i));
		}
		return walls;
	}

}
