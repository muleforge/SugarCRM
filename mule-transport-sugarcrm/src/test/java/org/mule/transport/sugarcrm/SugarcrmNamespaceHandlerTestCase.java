/*
 * $Id: SugarcrmNamespaceHandlerTestCase.java 1010 2010-09-22 15:57:51Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm;

import org.mule.tck.FunctionalTestCase;

/**
 * TODO
 */
public class SugarcrmNamespaceHandlerTestCase extends FunctionalTestCase
{
    protected String getConfigResources()
    {
        // TODO You'll need to edit this file to configure the properties specific to
        // your transport
        return "sugarcrm-namespace-config.xml";
    }

    public void testSugarcrmConfig() throws Exception
    {
        SugarcrmConnector c = (SugarcrmConnector) muleContext.getRegistry().lookupConnector(
            "sugarcrmConnector");
        assertNotNull(c);
        assertTrue(c.isConnected());
        assertTrue(c.isStarted());

        // TODO Assert specific properties are configured correctly

    }
}
