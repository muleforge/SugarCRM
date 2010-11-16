package org.mule.transport.sugarcrm.input;

public class ModuleFieldsObject {

	String sessionID;
	String moduleName;
	
	public ModuleFieldsObject(String sessionID, String moduleName) {
		super();
		this.sessionID = sessionID;
		this.moduleName = moduleName;
	}
	
	public ModuleFieldsObject() {
		
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
}
