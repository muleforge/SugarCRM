/*
 * $Id: SugarcrmInitialise.java 1009 2010-09-22 15:55:54Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm;

import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;

import com.sugarcrm.sugarcrm.Sugarsoap;

public class SugarcrmInitialise implements Initialisable
{
    private Sugarsoap sugar;
    
    @Override
    public void initialise() throws InitialisationException
    {
        sugar = new Sugarsoap();
    }

    public Sugarsoap getSugar()
    {
        return sugar;
    }

    public void setSugar(Sugarsoap sugar)
    {
        this.sugar = sugar;
    }

}


