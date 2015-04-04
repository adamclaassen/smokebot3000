package web;

import java.util.ArrayList;

import comm.Packet;

public class InternetWrapper {
	
	private ArrayList<Packet> incomingPackets;
	
	public InternetWrapper(int port){
		 
	}
	 
	public void sendPacket(Packet packet){
		 
	}
	 
	public Packet getLatestPacket(){
		Packet temp = this.incomingPackets.get(this.incomingPackets.size()-1);
		this.incomingPackets.remove(this.incomingPackets.size()-1);
		return temp;
	}
	 
	public Packet getOldestPacket(){
		Packet temp = this.incomingPackets.get(0);
		this.incomingPackets.remove(0);
		return temp;
	}
}
