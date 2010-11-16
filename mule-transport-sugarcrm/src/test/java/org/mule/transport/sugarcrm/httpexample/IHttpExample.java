package org.mule.transport.sugarcrm.httpexample;

import com.sugarcrm.sugarcrm.GetEntryRequestType;
import com.sugarcrm.sugarcrm.GetEntryResponseType;

//This interface defines the functions that may be used in the HTTP example
//further functions such as multi query, update and get module fields may be included here
public interface IHttpExample {

    public String login(String username, String password);

    public GetEntryResponseType query(GetEntryRequestType entryRequestType);

}
