package applet;

import javax.swing.*;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class OSVA extends JApplet{

	private static final long serialVersionUID = 2226215276161285417L;
	static int width;
	static int height;
	
	public void init(){
		width = this.getWidth();
		height = this.getHeight();
		URL source = null;
		try {
			source = new URL("http://192.168.1.161");
		} 
		catch (MalformedURLException e) {
			
			String info = "APPLET INITIALIZATION ERROR: " + e.getMessage();
			AppletField field = new AppletField(info);
			field.setBackground(new Color(0,0,0));
			field.setForeground(new Color(255,255,255));
			this.setContentPane(field);
		}
		
		AppletField field = new AppletField(source);	//Creates a new AppletField, field. AppletField is a default content pane for displaying information on the applet
		field.setBackground(new Color(0,0,0));
		field.setForeground(new Color(255,255,255));
		this.setContentPane(field);						//Sets the Applet's content pane to be the default AppletField. 
		
	}
	
	public void stop(){
		
	}
	
	public void destroy(){
		
	}
}
