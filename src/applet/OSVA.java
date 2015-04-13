package applet;
import robot.*;

import javax.swing.*;

import comm.Packet;

import java.applet.*;
import java.awt.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class OSVA extends JApplet{
	static int width;
	static int height;
	
	public void init(){
		width = this.getWidth();
		height = this.getHeight();
		URL bot;
		try {
			bot = new URL("192.168.1.1");
			AppletField field = new AppletField(bot);	//Creates a new AppletField, field. AppletField is a default content pane for displaying information on the applet
			field.setBackground(new Color(0,0,0));
			field.setForeground(new Color(255,255,255));
			this.setContentPane(field);						//Sets the Applet's content pane to be the default AppletField. 
		} catch (MalformedURLException e) {
			String error = e.getMessage();
			
			
		}
		
	}
	
	public void stop(){
		
	}
	
	public void destroy(){
		
	}
}
