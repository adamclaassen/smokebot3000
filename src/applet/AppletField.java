package applet;
import javax.swing.*;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
//This is a default OSVA Component used for displaying
//information on the applet. Individual teams will have
//to implement the Field themselves, so that they can 
//have a more individualized applet. Each team can have
//one large Component that takes up the entire applet area,
//or several Components working in conjunction. 


public class AppletField extends JPanel{
	String info;
	
	public AppletField(URL xml){
		try {
			InputStream in = new BufferedInputStream(xml.openStream());
		} catch (IOException e) {
			info = e.getMessage();
		}
	}
	
	public AppletField(String error){
		info = error;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawString(info, OSVA.width/2, OSVA.height/2);
	}
	
	public void setInfo(String data){
		info = data;
	}
	
}
