package it.unibo.contact.DroneControlDashboardSystem;

import it.unibo.is.interfaces.IContentSegmentable;
import it.unibo.iss.group2.interfaces.messages.MessageLabels;

import java.util.HashMap;

public class CmdDisplay extends CmdDisplaySupport {

	public CmdDisplay(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HashMap<String, MessageLabels> initLabels() throws Exception {
		HashMap<String, MessageLabels> labels = new HashMap<String, MessageLabels>();
		for (MessageLabels bl : MessageLabels.values()) {
			labels.put(bl.name(), bl);
		}
		return labels;
	}

	@Override
	protected String getDestFilePath(String receivedFileName) throws Exception {		
		if( receivedFileName.startsWith("'")) 
			receivedFileName = receivedFileName.substring(1, receivedFileName.length()-1);
		return "files/received_"+receivedFileName;
	}

	@Override
	protected IContentSegmentable createFileToBuild(String fileDestPath) throws Exception {
		return new it.unibo.contact.platformuv.ContentSegmentable(
				new java.io.FileOutputStream( fileDestPath ) );
	}

}
