package org.mule.transport.sugarcrm.httpexample;

import java.io.IOException;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.transport.sugarcrm.SugarcrmProperties;
import org.xmlsoap.schemas.soap.encoding.Item;

import com.sugarcrm.sugarcrm.GetEntryResponseType;
import com.sugarcrm.sugarcrm.GetEntryRequestType;
import com.sugarcrm.sugarcrm.ObjectFactory;
import com.sugarcrm.sugarcrm.SelectFields;

import org.mule.transport.sugarcrm.input.SingleQueryObject;

//import org.mule.transport.salesforce.SalesforceProperties;

public class HttpExampleInvoker implements Callable {

	private IHttpExample iHttpExample;

	public GetEntryResponseType action(String[] parsed) throws IOException {

/*		String ID = "14eaa711-3838-2bce-0d57-4be403699eb2";
		String moduleName = "Accounts";
		String[] attributes = new String[] { "name", "phone_office", "website",
				"industry", "account_id", "email1", "shipping_address_street",
				"shipping_address_city", "shipping_address_state",
				"shipping_address_postalcode", "shipping_address_country" };
*/
		String temp = iHttpExample.login(parsed[0], parsed[1]);

		String sessionId = "";

		if (temp.startsWith(SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN))
			sessionId = temp.substring(SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN.length());
	
		////Invoke the single record query function
	//	SingleQueryObject singleQuery = new SingleQueryObject();

		GetEntryRequestType entryRequest = new GetEntryRequestType();
		
		entryRequest.setId("14eaa711-3838-2bce-0d57-4be403699eb2");
        entryRequest.setSession(sessionId);
        entryRequest.setModuleName("Accounts");

        ObjectFactory of = new ObjectFactory();
        SelectFields selectFields = of.createSelectFields();
        selectFields.setArrayType("SOAP-ENC:Array");
        
        Item item = new Item();
        item.setValue("name");
        selectFields.getAny().add(item);
        item = new Item();
        item.setValue("phone_office");
        selectFields.getAny().add(item);
			
        entryRequest.setSelectFields(selectFields);
        
        GetEntryResponseType r = iHttpExample.query(entryRequest);
        
        return r;
		
	}

	public void setIHttpExample(IHttpExample iHttpExample) {
		this.iHttpExample = iHttpExample;
	}

	public IHttpExample getIHttpExample() {
		return iHttpExample;
	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String[] src = (String[]) eventContext.transformMessage();
		return action(src);
	}

}
