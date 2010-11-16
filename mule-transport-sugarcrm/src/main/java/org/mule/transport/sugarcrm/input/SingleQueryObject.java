package org.mule.transport.sugarcrm.input;

public class SingleQueryObject {

	String sessionID;
	String ID;
	String moduleName;
	String[] attributes;
	
	public SingleQueryObject() {

	}
	
	public SingleQueryObject(String sessionID, String ID, String moduleName,
			String[] attributes) {
		super();
		this.sessionID = sessionID;
		this.ID = ID;
		this.moduleName = moduleName;
		this.attributes = attributes;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
	
}
