package org.mule.transport.sugarcrm.transformers;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.sugarcrm.input.UpdateObject;

import com.sugarcrm.sugarcrm.NameValueList;
import com.sugarcrm.sugarcrm.ObjectFactory;
import com.sugarcrm.sugarcrm.SetEntryRequestType;

public class UpdateTransformer extends AbstractTransformer {

	public UpdateTransformer() {
		super();
		this.registerSourceType(UpdateObject.class);
		
	}
	
	@Override
	protected Object doTransform(Object src, String encoding)
			throws TransformerException {

        SetEntryRequestType entryRequest = new SetEntryRequestType();

        UpdateObject updateObject = (UpdateObject) src;
        
        entryRequest.setSession(updateObject.getSessionID());
        entryRequest.setModuleName(updateObject.getModuleName());
        
        ObjectFactory of = new ObjectFactory();
        NameValueList nameValueList = of.createNameValueList();
        nameValueList.setArrayType("SOAP-ENC:Array");
        
        for(int i = 0; i < updateObject.getNameValueList().getAny().size(); i++){
        	nameValueList.getAny().add(updateObject.getNameValueList().getAny().get(i));
        }
        
        entryRequest.setNameValueList(nameValueList);
        
		return entryRequest;
	}

}
