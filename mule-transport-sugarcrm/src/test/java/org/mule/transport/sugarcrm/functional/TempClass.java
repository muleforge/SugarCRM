package org.mule.transport.sugarcrm.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.sugarcrm.ModuleField;
import org.mule.transport.sugarcrm.SugarCrmHelper;
import org.mule.transport.sugarcrm.SugarcrmProperties;
import org.mule.transport.sugarcrm.input.ModuleFieldsObject;
import org.mule.transport.sugarcrm.input.MultiQueryObject;
import org.mule.transport.sugarcrm.input.SingleQueryObject;
import org.mule.transport.sugarcrm.input.UpdateObject;
import org.mule.transport.sugarcrm.transformers.MultiQueryTransformer;
import org.xmlsoap.schemas.soap.encoding.Item;

import com.sugarcrm.sugarcrm.FieldList;
import com.sugarcrm.sugarcrm.GetEntryListRequestType;
import com.sugarcrm.sugarcrm.GetEntryListResponseType;
import com.sugarcrm.sugarcrm.GetEntryRequestType;
import com.sugarcrm.sugarcrm.GetEntryResponseType;
import com.sugarcrm.sugarcrm.GetModuleFieldsRequestType;
import com.sugarcrm.sugarcrm.GetModuleFieldsResponseType;
import com.sugarcrm.sugarcrm.NameValue;
import com.sugarcrm.sugarcrm.NameValueList;
import com.sugarcrm.sugarcrm.NewModuleFields;
import com.sugarcrm.sugarcrm.ObjectFactory;
import com.sugarcrm.sugarcrm.SelectFields;
import com.sugarcrm.sugarcrm.SetEntryRequestType;
import com.sugarcrm.sugarcrm.SetEntryResponseType;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;

public class TempClass extends FunctionalTestCase {

	String username = "android";
	String password = "android";

	@Override
	protected String getConfigResources() {
		return "sugarcrm-functional-config.xml";
	}

	// test case for a query on a single record
	public void testSingleQueryById() throws Exception {

		MuleClient client = new MuleClient();
		String[] payload = new String[2];

		// login to get session id payload[0] = username; payload[1] = password;
		MuleMessage response = client.send("vm://test.login",
				new DefaultMuleMessage(payload));
		String sessionId = response.getPayloadAsString().substring(
				SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN.length());

		// create an instance of the custom class to hold arguments that are
		// required for a query
		SingleQueryObject singleQuery = new SingleQueryObject();

		// get the session ID
		String sessionID = sessionId;
		// get the ID of an existing record
		String ID = "14eaa711-3838-2bce-0d57-4be403699eb2";
		// set the module name
		String moduleName = "Accounts";
		// set the data fields to return
		String[] attributes = new String[] { "name", "phone_office", "website",
				"industry", "account_id", "email1", "shipping_address_street",
				"shipping_address_city", "shipping_address_state",
				"shipping_address_postalcode", "shipping_address_country" };

		singleQuery.setSessionID(sessionID);
		singleQuery.setID(ID);
		singleQuery.setModuleName(moduleName);
		singleQuery.setAttributes(attributes);

		response = client.send("vm://test.singleQuery", new DefaultMuleMessage(
				singleQuery));

		assertTrue(response.getPayload() instanceof GetEntryResponseType);

		GetEntryResponseType entryResponse = (GetEntryResponseType) response
				.getPayload();

		// the returned result is converted here
		HashMap<String, String> result = SugarCrmHelper
				.convertSugarCrmSingleResult(entryResponse);
		// verify that the returned record is correct
		assertEquals("2 Tall Stores 348380", result.get("name"));
		assertEquals("(390) 308-8299", result.get("phone_office"));
		System.out.println(result.get("phone_office"));
	}

	// test case to demonstrate the function to query for multiple records
	public void testMultiQuery() throws Exception {

		MuleClient client = new MuleClient();
		String[] payload = new String[2];

		// login to get session id payload[0] = username; payload[1] = password;
		MuleMessage response = client.send("vm://test.login",
				new DefaultMuleMessage(payload));
		String sessionId = response.getPayloadAsString().substring(
				SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN.length());

		// create an instance of the custom class that will hold all arguments
		// to perform a multiple query
		MultiQueryObject multiQuery = new MultiQueryObject();

		// set the session ID
		String sessionID = sessionId;
		// set the module name
		String moduleName = "Accounts";
		// set the way in which the returned result is ordered, in this case the
		// results will be ordered according to name
		String orderBy = "accounts.name asc";
		int offset = 0;
		// A query may be specified as an argument, please refer to the SugarCRM
		// SOAP API
		String query = "";
		// A list of attributes to be returned are specified here
		String[] attributes = new String[] { "name", "phone_office", "website",
				"industry", "account_id", "email1", "shipping_address_street",
				"shipping_address_city", "shipping_address_state",
				"shipping_address_postalcode", "shipping_address_country" };

		multiQuery.setSessionID(sessionID);
		multiQuery.setModuleName(moduleName);
		multiQuery.setOrderBy(orderBy);
		multiQuery.setOffset(offset);
		multiQuery.setQuery(query);
		multiQuery.setAttributes(attributes);

		response = client.send("vm://test.multiQuery", new DefaultMuleMessage(
				multiQuery));
		assertTrue(response.getPayload() instanceof GetEntryListResponseType);

		GetEntryListResponseType entryResponse = (GetEntryListResponseType) response
				.getPayload();

		List<HashMap<String, String>> resultList = SugarCrmHelper
				.convertSugarCrmMultipleResult(entryResponse);
		assertTrue(resultList.size() > 0);
		HashMap<String, String> result = resultList.get(0);
		assertEquals("2 Tall Stores 348380", result.get("name"));
		System.out.println(result.get("account_id"));
		assertEquals("(390) 308-8299", result.get("phone_office"));
		System.out.println(result.get("name"));
		System.out.println(result.get("phone_office"));

	}

	// test case to demonstrate the update function
	// this function may be used to create/update/delete a record
	public void testSingleUpdate() throws Exception {
		MuleClient client = new MuleClient();
		String[] payload = new String[2];

		// login to get session id
		payload[0] = username;
		payload[1] = password;
		MuleMessage response = client.send("vm://test.login",
				new DefaultMuleMessage(payload));
		String sessionId = response.getPayloadAsString().substring(
				SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN.length());

		// Create an instance of the custom class that will contain the update
		// information
		UpdateObject update = new UpdateObject();

		// set the session ID and module name in which to make the update
		update.setSessionID(sessionId);
		update.setModuleName("Accounts");

		// create a NameValueList in which to specify which fields to update
		ObjectFactory of = new ObjectFactory();
		NameValueList nameValueList = of.createNameValueList();
		nameValueList.setArrayType("SOAP-ENC:Array");

		// pass ID as argument, make sure that the ID is correct
		// the ID of a record may from the response returned after a new record
		// is created
		// If a valid ID of a record is passed here, then an update takes place
		// If no ID is passed, then a new record is created
		NameValue nameValue = of.createNameValue();
		nameValue.setName("id");
		nameValue.setValue("14eaa711-3838-2bce-0d57-4be403699eb2");
		nameValueList.getAny().add(nameValue);

		// pass Deleted as argument, if this argument is
		// passed, the record is deleted, if it is not passed,
		// the record is not deleted
		/*
		 * NameValue nameValue2 = of.createNameValue();
		 * nameValue2.setName("deleted"); nameValue2.setValue("1");
		 * nameValueList.getAny().add(nameValue2);
		 */

		// pass attribute to change, here we will change the phone number
		// NameValue nameValue1 = of.createNameValue();
		// nameValue1.setName("phone_office");
		// nameValue1.setValue("(999) 999-9999");
		// nameValue1.setValue("(123) 308-8299");
		// nameValueList.getAny().add(nameValue1);

		update.setNameValueList(nameValueList);

		response = client.send("vm://test.update", new DefaultMuleMessage(
				update));
		assertTrue(response.getPayload() instanceof SetEntryResponseType);

		SetEntryResponseType entryResponse = (SetEntryResponseType) response
				.getPayload();
		String ID = entryResponse.getReturn().getId();
		System.out.println(ID);

	}

	// test case to get the list of attributes for a module field. ex.
	// "Accounts"
	public void testGetModuleFields() throws Exception {

		MuleClient client = new MuleClient();
		String[] payload = new String[2];

		// login to get session id
		payload[0] = username;
		payload[1] = password;
		MuleMessage response = client.send("vm://test.login",
				new DefaultMuleMessage(payload));
		String sessionId = response.getPayloadAsString().substring(
				SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN.length());

		// create an instance of the custom class created, this will
		// contain a session ID and a module name
		ModuleFieldsObject moduleFields = new ModuleFieldsObject();

		// set the session ID
		moduleFields.setSessionID(sessionId);
		// set the module name
		moduleFields.setModuleName("Contacts");

		response = client.send("vm://test.get_module_fields",
				new DefaultMuleMessage(moduleFields));

		assertTrue(response.getPayload() instanceof GetModuleFieldsResponseType);

		GetModuleFieldsResponseType moduleFieldsResponse = (GetModuleFieldsResponseType) response
				.getPayload();

		// an array list that contains the module fields as strings
		// the function convertSugarCrmModuleFieldsResult() converts a
		// ModuleFieldsResponse Type into
		// an array list of strings. This is useful so that one may see the list
		// of fields as strings
		ArrayList<String> myArr = SugarCrmHelper
				.convertSugarCrmModuleFieldsResult(moduleFieldsResponse);

		// a simple loop to print the module fields returned
		 for(int i = 0; i < myArr.size(); i++){
		 System.out.println(myArr.get(i));
		 }

		// verify that the first two fields returned are correct
		assertEquals("id", myArr.get(0));
		assertEquals("name", myArr.get(1));

	}
}
