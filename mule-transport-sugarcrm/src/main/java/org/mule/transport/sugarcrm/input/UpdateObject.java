package org.mule.transport.sugarcrm.input;

import com.sugarcrm.sugarcrm.NameValueList;

public class UpdateObject {

	String sessionID;
	String moduleName;
	NameValueList nameValueList;
	
	public UpdateObject() {

	}
	
	public UpdateObject(String sessionID, String moduleName,
			NameValueList nameValueList) {
		super();
		this.sessionID = sessionID;
		this.moduleName = moduleName;
		this.nameValueList = nameValueList;
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

	public NameValueList getNameValueList() {
		return nameValueList;
	}

	public void setNameValueList(NameValueList nameValueList) {
		this.nameValueList = nameValueList;
	}
	
}
