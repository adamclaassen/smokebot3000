package applet;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;

public class OSVA extends JApplet{

	private static final long serialVersionUID = 2226215276161285417L;
	static int width;
	static int height;
	
	public void init(){
		width = this.getWidth();
		height = this.getHeight();
		
		URL source = null;
		try {
			source = new URL("http://www.kangaroocg.com");
			AppletField field = new AppletField(source);	//Creates a new AppletField, field. AppletField is a default content pane for displaying information on the applet
			field.setBackground(new Color(0,0,0));
			field.setForeground(new Color(255,255,255));
			this.setContentPane(field);						//Sets the Applet's content pane to be the default AppletField. 
		} 
		catch (MalformedURLException e) {
			String info = "APPLET INITIALIZATION ERROR: " + e.toString();
			AppletField field = new AppletField(info);
			field.setBackground(new Color(0,0,0));
			field.setForeground(new Color(255,255,255));
			this.setContentPane(field);
			
		}
		
	}
	
	public void stop(){
		
	}
	
	public void destroy(){
		
	}
}
