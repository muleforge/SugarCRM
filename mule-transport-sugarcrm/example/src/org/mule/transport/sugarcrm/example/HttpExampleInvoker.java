/*
 * $Id: HttpExampleInvoker.java 1029 2010-11-02 09:49:11Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm.example;

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

public class HttpExampleInvoker implements Callable
{

    private IHttpExample iHttpExample;

    public GetEntryResponseType action(String[] parsed) throws IOException
    {

        String temp = iHttpExample.login(parsed[0], parsed[1]);

        String sessionId = "";

        if (temp.startsWith(SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN))
            sessionId = temp.substring(SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN.length());

        GetEntryRequestType entryRequest = new GetEntryRequestType();

        entryRequest.setId("a6700a6f-508f-c449-39e9-4c974d5f0ce7");
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

    public void setIHttpExample(IHttpExample iHttpExample)
    {
        this.iHttpExample = iHttpExample;
    }

    public IHttpExample getIHttpExample()
    {
        return iHttpExample;
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception
    {
        String[] src = (String[]) eventContext.transformMessage();
        return action(src);
    }

}
