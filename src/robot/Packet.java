package robot;

public class Packet {
	static int nextPacketID = 0;
	String rawPacket;
	String messageType;
	String data;
	String osvPosition;
	String packetID;
	/*tentative packet format: <<packetID/%x%y%head/messageType/data>>
	 * messageType rules:
	 * POSITION: pass integer 0 for 'data', it is ignored
	 * SENSOR_DATA: pass a Sensor object, it must have a properly implemented toString
	 * BATT_STATUS: pass a battery voltage as a float (NOTE: may change in favor of passing batt sensor instance)
	 * PATH: pass the Pathfinder object, this will generate a very large packet
	 * CUSTOM_DATA_A: pass anything with a toString method, this is what the packet will contain
	 * CUSTOM_DATA_B: see CUSTOM_DATA_A
	 */
	public Packet(String rawPacket){
		
	}
	public Packet(Position pos, MessageTypes mType, Object data){
		
		this.packetID = new String(Integer.toString(Packet.nextPacketID));
		this.messageType = new String(mType.toString());
		Packet.nextPacketID++;
		this.osvPosition = new String(
				"%"+
				Integer.toString(pos.getX())+"%"+
				Integer.toString(pos.getY())+"%"+
				Float.toString(pos.getHead())
				);
		this.data = new String(data.toString());
		/*switch(mType){
		case POSITION:
			this.data = new String("0");
			break;
		case SENSOR_DATA:
			break;
		case BATT_STATUS:
			break;
		case PATH:
			break;
		case CUSTOM_DATA_A:
			this.data = new String(data.toString());
			break;
		case CUSTOM_DATA_B:
			this.data = new String(data.toString());
			break;
		}
		this.osvPosition.concat(">>");
		*/
	}
	
	public String toString(){
		String output = new String(
				"<<"+
				Integer.toString(Packet.nextPacketID)+"/"+
				this.osvPosition+"/"+
				this.messageType+"/"+
				this.data+">>");
		return output;
	}
}
