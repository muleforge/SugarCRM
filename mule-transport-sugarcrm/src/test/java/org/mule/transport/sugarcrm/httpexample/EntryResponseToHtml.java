
package org.mule.transport.sugarcrm.httpexample;

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
            htmlFormatter = FileUtils.readFileToString(new File("src/test/resources/result.html"));
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

        return String.format(htmlFormatter, html.toString());

    }

}
