package applet;
import robot.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;


public class OSVA extends java.applet.Applet{
	int width;
	int height;
	
	public void init(){
		//connect to server somehow, get initial packet 
		width  = this.getSize().width;
		height = this.getSize().height;
		this.setBackground(Color.black);
		
		
	}
	
	public void paint(Graphics g){
		g.setFont(Font.SANS_SERIF);
		//retrieve packet (getPacket) and draw strings, generate map overlay once path is determined
		Packet data = getPacket("192.168.0.11");
		g.drawString(data.toString(), 0, 0);
	}
	
	public Packet getPacket(String ip){
		//Do internety things
		Packet defaultPacket = new Packet("<<[1,2,2]>>");
		return defaultPacket;
		
	}
	
}
