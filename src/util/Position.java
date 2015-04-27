package util;

import org.w3c.dom.Element;

import pathfinder.Node;


public class Position {
	private int x,y,head;
	private int nearbyRadius = 100;
	
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
	public int getNearbyRadius(){return this.nearbyRadius;}
	public int[] getCoord(){ int[] coord = {this.x, this.y}; return coord;}
	public int[] getPos(){ int[] pos = {this.x, this.y, this.head}; return pos;}
	public void setCoord(int x, int y){this.x=x; this.y=y;}
	public void setPos(int x, int y, int head){setCoord(x, y); this.head = head;}
	public void setNearbyRadius(int radius){this.nearbyRadius = radius;}
	public void setHead(int head){this.head = head;}
	public boolean equals(Position pos){
		if(this.x==pos.x && this.y==pos.y){
			return true;
		}
		return false;
	}
	public boolean isNearby(Position pos){
		if(this.getDist(pos)<this.nearbyRadius){
			return true;
		}
		return false;
	}
	public String toString(){
		return String.format("[%d,%d,%f]", this.getX(), this.getY(), this.getHead());
	}
	public int getDist(Position pos){
		return (int) Math.sqrt((this.x-pos.getX())^2 + (this.y-pos.getY())^2);
	}
	public double getHeadTo(Position pos){
		return Math.acos((this.getX()-pos.getX())/this.getDist(pos));
	}
	
	public boolean matchesNode(Node node){
		if(this.x==node.getX()&&this.y==node.getY()){
			return true;
		}
		return false;
	}
	

	
}
