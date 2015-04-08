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
	
	public InternetWrapper(){
		DocumentBuilderFactory unnessecaryAbstraction = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = unnessecaryAbstraction.newDocumentBuilder();
			this.doc = docBuilder.newDocument();
		} catch (ParserConfigurationException e) {
			SimpleRobot.eHandler.addError(e);
		}
	}
	
}
