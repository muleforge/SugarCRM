package org.mule.transport.sugarcrm.transformers;


import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.sugarcrm.input.SingleQueryObject;

import com.sugarcrm.sugarcrm.GetEntryRequestType;
import com.sugarcrm.sugarcrm.ObjectFactory;
import com.sugarcrm.sugarcrm.SelectFields;
import org.xmlsoap.schemas.soap.encoding.Item;

public class SingleQueryTransformer extends AbstractTransformer {
	
	public SingleQueryTransformer() {
		super();
		this.registerSourceType(SingleQueryObject.class);
		
	}

	@Override
	protected Object doTransform(Object src, String encoding)
			throws TransformerException {		
		
		//create the result object
		GetEntryRequestType entryRequest = new GetEntryRequestType();
		
		SingleQueryObject singleQuery = (SingleQueryObject) src;
		
		entryRequest.setId(singleQuery.getID());
        entryRequest.setSession(singleQuery.getSessionID());
        entryRequest.setModuleName(singleQuery.getModuleName());
        
        String[] attributes = singleQuery.getAttributes();
        
        ObjectFactory of = new ObjectFactory();
        SelectFields selectFields = of.createSelectFields();
        selectFields.setArrayType("SOAP-ENC:Array");
        
        for (int i = 0; i < attributes.length; i++){
        	
        	Item item = new Item();
            item.setValue(attributes[i]);
        	selectFields.getAny().add(item);
        	
        }
        
        entryRequest.setSelectFields(selectFields);
		
		return entryRequest;
	}
}
