package robot;

public abstract class Packet{
	
	private String packet;
	
	public Packet(Position pos, MessageTypes mType, Object data){
		packet = new String("<<"+
				pos.toString()+"/"+
				mType.toString()+"/"+
				data.toString()+"/"+
				">>");
	}
	
	public Packet(Position pos){
		this(pos, MessageTypes.POSITION, 0);
	}
	
	public Packet(Position pos, Exception e){
		this(pos, MessageTypes.ERROR_MESSAGE, e.toString());
	}
	
	public String toString(){
		return this.packet;
	}
}