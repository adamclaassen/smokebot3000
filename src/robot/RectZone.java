package robot;

public class RectZone {
	private Position pos1;
	private Position pos2;
	
	public RectZone(Position pos1, Position pos2){
		this.setPos1(pos1);
		this.setPos2(pos2);
	}

	public Position getPos1() {
		return pos1;
	}

	public void setPos1(Position pos) {
		this.pos1 = pos;
	}

	public Position getPos2() {
		return pos2;
	}

	public void setPos2(Position pos) {
		this.pos2 = pos;
	}
	
	private boolean isBetweenX(Position pos){
		if(pos2.getX()-pos1.getX()>0){
			if(pos1.getX()<pos.getX() && pos.getX()<pos2.getX()){
				return true;
			}else{
				return false;
			}
		}else{
			if(pos2.getX()<pos.getX() && pos.getX()<pos1.getX()){
				return true;
			}else{
				return false;
			}
		}
	}
	
	private boolean isBetweenY(Position pos){
		if(pos2.getY()-pos1.getY()>0){
			if(pos1.getY()<pos.getY() && pos.getY()<pos2.getY()){
				return true;
			}else{
				return false;
			}
		}else{
			if(pos2.getY()<pos.getY() && pos.getY()<pos1.getY()){
				return true;
			}else{
				return false;
			}
		}
	}
	public boolean isInZone(Position pos){
		if((pos.equals(pos1) && pos.equals(pos2))){
			return true;
		}
		else if(this.isBetweenX(pos) && this.isBetweenY(pos)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean equals(RectZone zone){
		return false;
	}
	

}
