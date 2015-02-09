package applet;

public class Location {
	 private int x,y;
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
	public int[] getCoords(){
		int[] coords = {x,y};
		return coords;
	}
}
