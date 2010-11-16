
package org.mule.transport.sugarcrm.httpexample;

import java.io.IOException;

import org.apache.commons.httpclient.ContentLengthInputStream;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class StreamToUserInput extends AbstractTransformer
{
    public StreamToUserInput()
    {
        registerSourceType(ContentLengthInputStream.class);
        setReturnClass(String[].class);
    }

    @Override
    protected Object doTransform(Object src, String encoding) throws TransformerException
    {
        ContentLengthInputStream inputStream = (ContentLengthInputStream) src;
        String http = "";
        while (true)
        {
            int x = -1;
            try
            {
                x = inputStream.read();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if (x != -1)
                http += String.valueOf((char) x);
            else
                break;
        }

        String[] parsed = new String[3];
        parsed[0] = http.substring(http.indexOf("username=") + 9, http.indexOf("&password"));
        parsed[0] = parsed[0].replace("%40", "@");
        parsed[1] = http.substring(http.indexOf("password=") + 9, http.indexOf("&contactname"));
        parsed[2] = http.substring(http.indexOf("contactname=") + 12, http.length());

        return parsed;
    }
}
