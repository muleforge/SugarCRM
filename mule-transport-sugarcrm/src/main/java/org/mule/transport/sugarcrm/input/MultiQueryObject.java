package org.mule.transport.sugarcrm.input;

public class MultiQueryObject {

	String sessionID;
	String moduleName;
	String orderBy;
	int offset;
	String query;
	String[] attributes;
	
	public MultiQueryObject(){
		
	}
	
	public MultiQueryObject(String sessionID, String moduleName,
			String orderBy, int offset, String query, String[] attributes) {
		super();
		this.sessionID = sessionID;
		this.moduleName = moduleName;
		this.orderBy = orderBy;
		this.offset = offset;
		this.query = query;
		this.attributes = attributes;
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
}
