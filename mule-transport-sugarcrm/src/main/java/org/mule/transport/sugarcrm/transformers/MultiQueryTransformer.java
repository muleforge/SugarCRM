package org.mule.transport.sugarcrm.transformers;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.sugarcrm.input.MultiQueryObject;
import org.xmlsoap.schemas.soap.encoding.Item;

import com.sugarcrm.sugarcrm.GetEntryListRequestType;
import com.sugarcrm.sugarcrm.ObjectFactory;
import com.sugarcrm.sugarcrm.SelectFields;


public class MultiQueryTransformer extends AbstractTransformer {
	
	public MultiQueryTransformer() {
		super();
		this.registerSourceType(MultiQueryObject.class);
		
	}
	
	@Override
	protected Object doTransform(Object src, String encoding)
			throws TransformerException {
		
		GetEntryListRequestType entryListRequest = new GetEntryListRequestType();
		
		MultiQueryObject multiQuery = (MultiQueryObject) src;
		
		entryListRequest.setSession(multiQuery.getSessionID());
		entryListRequest.setModuleName(multiQuery.getModuleName());
		entryListRequest.setOrderBy(multiQuery.getOrderBy());
		entryListRequest.setOffset(multiQuery.getOffset());
		entryListRequest.setQuery(multiQuery.getQuery());
		
		String[] attributes = multiQuery.getAttributes();
        
        ObjectFactory of = new ObjectFactory();
        SelectFields selectFields = of.createSelectFields();
        selectFields.setArrayType("SOAP-ENC:Array");
        
        for (int i = 0; i < attributes.length; i++){
        	
        	Item item = new Item();
            item.setValue(attributes[i]);
        	selectFields.getAny().add(item);
        	
        }
        
        entryListRequest.setSelectFields(selectFields);
		
		return entryListRequest;
	}

}
