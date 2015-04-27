package applet;
import javax.swing.*;

import java.awt.*;

import javax.xml.parsers.ParserConfigurationException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//This is a default OSVA Component used for displaying
//information on the applet. Individual teams will have
//to implement the Field themselves, so that they can 
//have a more individualized applet. Each team can have
//one large Component that takes up the entire applet area,
//or several Components working in conjunction. 


public class AppletField extends JPanel{

	private static final long serialVersionUID = -6824103810267271345L;
	String info = null;
	String posX = null;
	String posY = null;
	String posRot = null;
	String previousPositions = null;
	String path = null;
	String battery = null;
	String sensorData = null;
	
	// Attempts to get information from local server using url provided in constructor
	public AppletField(URL url){
		try {
			/**
			 * Elements of XML Doc:
			 * currentPos
			 * path
			 * previousPositions
			 * battery
			 * sensorData
			 */
			
			InputStream in = new BufferedInputStream(url.openStream());
			Document xml = XMLUtils.readXml(in);
			
			NodeList posNodes = xml.getElementsByTagName("currentPos");
			posX = posNodes.item(0).getTextContent();
			posY = posNodes.item(1).getTextContent();
			posRot = posNodes.item(2).getTextContent();
			
			NodeList all = xml.getElementsByTagName("robot");
			path = all.item(1).getTextContent();
			
			previousPositions = all.item(2).getTextContent();
			
			battery = all.item(3).getTextContent();
			
			sensorData = all.item(4).getTextContent();
		} 
		catch (IOException | ParserConfigurationException | SAXException e) {
			info = "APPLETFIELD ERROR: " + e.toString();
		}
		
	}
	
//	public String getValue(int index){
//		
//	}
	
	public AppletField(String data){
		info = data;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(info == null){
			fancyFormatting(g,20);
		}
		else{
			g.drawString(info, OSVA.width/2, OSVA.height/2);
		}
	}
	
	public void fancyFormatting(Graphics g,int spacing){
		String[] varList = {posX,posY,posRot,previousPositions,battery,sensorData,path};
		int iterator = 0;
		for(String var : varList){
			g.drawString(var, (OSVA.width/2)-(g.getFontMetrics().stringWidth(var)/2), (OSVA.height/2)+(iterator*spacing));
			iterator += 1;
		}
	}
	
	public void setInfo(String data){
		info = data;
	}
	
}
