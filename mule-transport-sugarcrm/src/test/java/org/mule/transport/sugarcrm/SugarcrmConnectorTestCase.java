/*
 * $Id: SugarcrmConnectorTestCase.java 1010 2010-09-22 15:57:51Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm;

import org.mule.api.transport.Connector;
import org.mule.transport.AbstractConnectorTestCase;

public class SugarcrmConnectorTestCase extends AbstractConnectorTestCase
{

    /*
     * For general guidelines on writing transports see
     * http://mule.mulesource.org/display/MULE/Writing+Transports
     */

    public Connector createConnector() throws Exception
    {
        /*
         * IMPLEMENTATION NOTE: Create and initialise an instance of your connector
         * here. Do not actually call the connect method.
         */

        SugarcrmConnector c = new SugarcrmConnector();
        c.setName("Test");
        // TODO Set any additional properties on the connector here
        return c;
    }

    public String getTestEndpointURI()
    {
        return "sugarcrm://192.168.2.14/sugarcrm";
    }

    public Object getValidMessage() throws Exception
    {
        String soapMessage = "<soap></soap>";
        return soapMessage;
    }

    public void testProperties() throws Exception
    {
        // TODO test setting and retrieving any custom properties on the
        // Connector as necessary
    }

}
