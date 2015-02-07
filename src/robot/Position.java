package robot;

public class Position {
	private int x,y,head;
	
	public Position(){}
	public Position(int x, int y){
		this(x,y,0);
	}
	public Position(int x, int y, int head){
		this.x = x;
		this.y = y;
		this.head = head;
	}
	
	public int getX(){ return this.x;}
	public int getY(){ return this.y;}
	public int getHead(){ return this.head;}
	public int[] getCoord(){ int[] coord = {this.x, this.y}; return coord;}
	public int[] getPos(){ int[] pos = {this.x, this.y, this.head}; return pos;}
	public void setCoord(int x, int y){this.x=x; this.y=y;}
	public void setPos(int x, int y, int head){setCoord(x, y); this.head = head;}
	public void setHead(int head){this.head = head;}
	
}
