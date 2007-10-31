/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.providers.sugar;

import org.mule.tck.providers.AbstractMessageAdapterTestCase;
import org.mule.umo.provider.UMOMessageAdapter;
import org.mule.umo.MessagingException;

public class SugarMessageAdapterTestCase extends AbstractMessageAdapterTestCase
{

    /* For general guidelines on writing transports see
       http://mule.mulesource.org/display/MULE/Writing+Transports */

    public Object getValidMessage() throws Exception
    {
    	// TODO Create a valid message for your transport
    	throw new UnsupportedOperationException("getValidMessage");
    }

    public UMOMessageAdapter createAdapter(Object payload) throws MessagingException
    {
        return new SugarMessageAdapter(payload);
    }

}
