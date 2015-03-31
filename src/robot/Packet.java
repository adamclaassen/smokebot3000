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

		this.mType = MessageTypes.valueOf(mTypeString);
		
		switch(this.mType){
		case POSITION:      break;
		case BATT_STATUS:   data = Integer.getInteger(dataString); break;
		case SENSOR_DATA:   data = decodeSensorData(dataString); break;
		case CUSTOM_DATA_A: data = decodeCustomA(dataString); break;
		case CUSTOM_DATA_B: data = decodeCustomB(dataString); break;
		default:
			break;
		}
		
	}
	
	public abstract Object decodeSensorData(String data);
	public abstract Object decodeCustomA(String data);
	public abstract Object decodeCustomB(String data);
	
	public String toString(){
		return this.packet;
	}
}