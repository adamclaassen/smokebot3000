package web;

import java.util.ArrayList;

import util.Position;
import comm.Packet;
import robot.SimpleRobot;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InternetWrapper {
	
	private Document doc;
	private Element currentPosition;
	private Element pastPositions;
	private Element path;
		
	public InternetWrapper(){
		DocumentBuilderFactory unnessecaryAbstraction = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = unnessecaryAbstraction.newDocumentBuilder();
			this.doc = docBuilder.newDocument();
		} catch (ParserConfigurationException e) {
			SimpleRobot.eHandler.addError(e);
		}
		
		currentPosition = doc.createElement("currentPosition");
		pastPositions = doc.createElement("pastPositions");
		path = doc.createElement("path");
		
		
	}
	
	public void addPathElement(Position pos){
		
	}
	
	public void addPastPosElement(Position pos){
		
	}
	
	public Position updateCurrentPosElement(Position pos){
		Element x = doc.createElement("x");
		currentPosition.appendChild(x);
		x.
	}
	
	
	
}
