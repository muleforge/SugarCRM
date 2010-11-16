/*
 * $Id: EntryResponseToHtml.java 1029 2010-11-02 09:49:11Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm.example.transformers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.xpath.XPathExpressionException;

import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.sugarcrm.SugarCrmHelper;
import org.mule.util.FileUtils;

import com.sugarcrm.sugarcrm.GetEntryResponseType;

public class EntryResponseToHtml extends AbstractTransformer
{

    private String htmlFormatter;

    public EntryResponseToHtml()
    {
        registerSourceType(GetEntryResponseType.class);
        setReturnClass(String.class);
    }

    @Override
    public void initialise() throws InitialisationException
    {
        super.initialise();
        try
        {
            htmlFormatter = FileUtils.readFileToString(new File("example/resources/result.html"));
        }
        catch (IOException e)
        {
            new InitialisationException(e, this);
        }
    }

    @Override
    protected Object doTransform(Object src, String encoding) throws TransformerException
    {

        GetEntryResponseType entryResponse = (GetEntryResponseType) src;
        StringBuilder html = new StringBuilder("");

        HashMap<String, String> result;
        try
        {
            result = SugarCrmHelper.convertSugarCrmSingleResult(entryResponse);

            html.append("<br/>" + result.get("name") + " : " + result.get("phone_office") + "<br/>");
        }
        catch (XPathExpressionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       // return String.format(htmlFormatter, html.toString());
        return  html.toString();
    }

}
