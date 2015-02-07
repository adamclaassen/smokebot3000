package mapOverlay;

public class Location {
	int x,y;
	public Location(int xCoord, int yCoord){
		x = xCoord;
		y = yCoord;
	}
	public void setLocation(int xCoord, int yCoord){
		x = xCoord;
		y = yCoord;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public float[] getCoords(){
		float[] coords = {x,y};
		return coords;
	}
}
