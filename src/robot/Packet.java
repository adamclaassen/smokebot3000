package robot;

public abstract class Packet{
	
	private String packet;
	
	Position pos;
	MessageTypes mType;
	Object data;
	
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
	
	public Packet(String incoming){
		int posEnd;
		int mTypeEnd;
		int dataEnd;
		
		posEnd = incoming.indexOf("/");
		mTypeEnd = incoming.indexOf("/", posEnd);
		dataEnd = incoming.indexOf(">");
		
		String posString = incoming.substring(2, posEnd);
		String mTypeString = incoming.substring(posEnd+1, mTypeEnd);
		String dataString = incoming.substring(mTypeEnd+1, dataEnd);
		
		this.pos = new Position( //[143,445,449]
				Integer.parseInt(posString.substring(1,2)),
				Integer.parseInt(posString.substring(3,4)),
				Integer.parseInt(posString.substring(5,6))
				);
		switch(mTypeString){
		case "POSITION":
			this.mType = MessageTypes.POSITION; break;
		case "BATT_STATUS":
			this.mType = MessageTypes.BATT_STATUS; break;
		case "CUSTOM_DATA_A":
			this.mType = MessageTypes.CUSTOM_DATA_A; break;
		case "CUSTOM_DATA_B":
			this.mType = MessageTypes.CUSTOM_DATA_B; break;
		case "ERROR_MESSAGE":
			this.mType = MessageTypes.ERROR_MESSAGE; break;
		case "PATH":
			this.mType = MessageTypes.PATH; break;
		case "SENSOR_DATA":
			this.mType = MessageTypes.SENSOR_DATA; break;
		}
		
		data = this.decodeData(dataString);
	}
	
	public abstract Object decodeData(String data);
	
	public String toString(){
		return this.packet;
	}
}