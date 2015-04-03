package applet;
import robot.*;

import javax.swing.*;

import java.awt.*;

public class OSVA extends JApplet{
	static int width;
	static int height;
	
	public void init(){
		width = this.getWidth();
		height = this.getHeight();
		
		AppletField field = new AppletField("Hello World");	//Creates a new AppletField, field. AppletField is a default content pane for displaying information on the applet
		field.setBackground(new Color(0,0,0));
		field.setForeground(new Color(255,255,255));
		this.setContentPane(field);						//Sets the Applet's content pane to be the default AppletField. 
		
	}
	
	public void stop(){
		
	}
	
	public void destroy(){
		
	}
	
	public Packet getPacket(String ip){
		//Do internety things
		Packet defaultPacket = null;
		return defaultPacket;
	}
	
}
