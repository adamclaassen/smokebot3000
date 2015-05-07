package util;

import java.util.ArrayList;

public class Zone {
	
	private Position center;
	private int radius;
	
	public Zone(Position center, int radius){
		this.center = center;
		this.radius = radius;
	}

	public Zone(int x, int y, int radius){
		this(new Position(x,y),radius);
	}
	
	public boolean isInZone(Position pos){
		if(this.getDistance(pos)<this.radius){
			return true;
		}
		return false;
	}
	
	private int getDistance(Position pos){
		return  (int) Math.sqrt((pos.getX()-this.center.getX())^2 + (pos.getY()-this.center.getY())^2);
	}
}