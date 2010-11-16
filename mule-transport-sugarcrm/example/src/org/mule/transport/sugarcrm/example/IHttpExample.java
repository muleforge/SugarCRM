/*
 * $Id: IHttpExample.java 1029 2010-11-02 09:49:11Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm.example;

import com.sugarcrm.sugarcrm.GetEntryRequestType;
import com.sugarcrm.sugarcrm.GetEntryResponseType;

//This interface defines the functions that may be used in the HTTP example
//further functions such as multi query, update and get module fields may be included here
public interface IHttpExample
{

    public String login(String username, String password);

    public GetEntryResponseType query(GetEntryRequestType entryRequestType);

}
