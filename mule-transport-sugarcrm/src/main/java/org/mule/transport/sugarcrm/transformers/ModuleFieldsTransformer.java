package org.mule.transport.sugarcrm.transformers;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.sugarcrm.input.ModuleFieldsObject;

import com.sugarcrm.sugarcrm.GetModuleFieldsRequestType;

public class ModuleFieldsTransformer extends AbstractTransformer {

	public ModuleFieldsTransformer() {
		super();
		this.registerSourceType(ModuleFieldsObject.class);
		
	}
	
	@Override
	protected Object doTransform(Object src, String encoding)
			throws TransformerException {
		
		GetModuleFieldsRequestType moduleFieldsRequest = new GetModuleFieldsRequestType();
		
		ModuleFieldsObject moduleFieldsObject = (ModuleFieldsObject) src;
		
		moduleFieldsRequest.setSession(moduleFieldsObject.getSessionID());
		moduleFieldsRequest.setModuleName(moduleFieldsObject.getModuleName());
		
		return moduleFieldsRequest;
	}

}
