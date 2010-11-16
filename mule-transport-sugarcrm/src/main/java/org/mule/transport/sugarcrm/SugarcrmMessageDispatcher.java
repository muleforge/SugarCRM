/*
 * $Id: SugarcrmMessageDispatcher.java 1009 2010-09-22 15:55:54Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.transport.AbstractMessageDispatcher;
import org.mule.util.StringUtils;

import com.sugarcrm.sugarcrm.GetEntryListRequestType;
import com.sugarcrm.sugarcrm.GetEntryListResponseType;
import com.sugarcrm.sugarcrm.GetEntryRequestType;
import com.sugarcrm.sugarcrm.GetEntryResponseType;
import com.sugarcrm.sugarcrm.GetModuleFieldsRequestType;
import com.sugarcrm.sugarcrm.GetModuleFieldsResponseType;
import com.sugarcrm.sugarcrm.LoginRequestType;
import com.sugarcrm.sugarcrm.LoginResponseType;
import com.sugarcrm.sugarcrm.LogoutRequestType;
import com.sugarcrm.sugarcrm.LogoutResponseType;
import com.sugarcrm.sugarcrm.SetEntriesRequestType;
import com.sugarcrm.sugarcrm.SetEntriesResponseType;
import com.sugarcrm.sugarcrm.SetEntryRequestType;
import com.sugarcrm.sugarcrm.SetEntryResponseType;
import com.sugarcrm.sugarcrm.Sugarsoap;
import com.sugarcrm.sugarcrm.SugarsoapPortType;
import com.sugarcrm.sugarcrm.UserAuth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.ws.soap.SOAPFaultException;

/**
 * <code>SalesforceMessageDispatcher</code> TODO document
 */
public class SugarcrmMessageDispatcher extends AbstractMessageDispatcher
{

    /*
     * For general guidelines on writing transports see
     * http://mule.mulesource.org/display/MULE/Writing+Transports
     */

    protected SugarcrmConnector connector;
    protected Sugarsoap sugarSoap;

    public SugarcrmMessageDispatcher(OutboundEndpoint endpoint)
    {
        super(endpoint);
        connector = (SugarcrmConnector) getConnector();

        /*
         * IMPLEMENTATION NOTE: If you need a reference to the specific connector for
         * this dispatcher use: SalesforceConnector cnn =
         * (SalesforceConnector)endpoint.getConnector();
         */
        sugarSoap = new Sugarsoap();
    }

    public void doConnect() throws Exception
    {
        /*
         * IMPLEMENTATION NOTE: Makes a connection to the underlying resource. Where
         * connections are managed by the connector this method may do nothing
         */

        // If a resource for this Dispatcher needs a connection established,
        // then this is the place to do it
    }

    public void doDisconnect() throws Exception
    {
        /*
         * IMPLEMENTATION NOTE: Disconnect any conections made in the connect method
         */

        // If the connect method did not do anything then this method
        // shouldn't do anything either
    }

    public void doDispatch(MuleEvent event) throws Exception
    {
        /*
         * IMPLEMENTATION NOTE: This is invoked when the endpoint is asynchronous. It
         * should invoke the transport but not return any result. If a result is
         * returned it should be ignorred, but if the underlying transport does have
         * a notion of asynchronous processing, that should be invoked. This method
         * is executed in a different thread to the request thread.
         */

        // TODO Write the client code here to dispatch the event over this
        // transport

        throw new UnsupportedOperationException("doDispatch");
    }

    public MuleMessage doSend(MuleEvent event) throws Exception
    {
        
        event.transformMessage();
        MuleMessage msg = event.getMessage();

        String url = "http://" + this.getEndpoint().getEndpointURI().getHost() + ":" + this.getEndpoint().getEndpointURI().getPort() + this.getEndpoint().getEndpointURI().getPath();
        String operation = (String)this.getEndpoint().getProperties().get(SugarcrmProperties.SUGARCRM_OPERATION);

        if (StringUtils.equals(operation, SugarcrmProperties.SUGARCRM_OPERATION_LOGIN))
        {
            try
            {
                Object[] payload = (Object[]) msg.getPayload();
                String username = (String) payload[0];
                String password = performMd5((String) payload[1]);

                SugarsoapPortType sugarSoapPort = sugarSoap.getSugarsoapPort(url);

                
                LoginRequestType loginRequest = new LoginRequestType();
                UserAuth userAuth = new UserAuth();
                userAuth.setUserName(username);
                userAuth.setPassword(password);
                loginRequest.setUserAuth(userAuth);
                LoginResponseType loginResponse = sugarSoapPort.login(loginRequest);
                
                String sessionId = loginResponse.getReturn().getId();

                if (logger.isDebugEnabled())
                {
                    logger.debug("Successfully logged on to Sugar CRM. Session Id is "
                                 + sessionId);
                }


                return new DefaultMuleMessage(SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN + sessionId);
            }
            catch (SOAPFaultException loginFault)
            {
                return new DefaultMuleMessage(loginFault.getMessage());
            }
        }
        else if (StringUtils.equals(operation, SugarcrmProperties.SUGARCRM_OPERATION_QUERY))
        {
        	Object payload = msg.getPayload();
        	SugarsoapPortType sugarSoapPort = sugarSoap.getSugarsoapPort(url);
        	
        	if (payload instanceof GetEntryRequestType)
        	{
        	    GetEntryRequestType entryRequestType = (GetEntryRequestType) payload;
        	    GetEntryResponseType response = sugarSoapPort.getEntry(entryRequestType);
        	    
        	    return new DefaultMuleMessage(response);
        	}
        	else if (payload instanceof GetEntryListRequestType)
        	{
        	    GetEntryListRequestType entriesRequestType = (GetEntryListRequestType) payload;
                GetEntryListResponseType response = sugarSoapPort.getEntryList(entriesRequestType);
                
                return new DefaultMuleMessage(response);
        	}
        }
        //update a field or a list of fields
        else if (StringUtils.equals(operation, SugarcrmProperties.SUGARCRM_OPERATION_UPDATE))
        {
        	Object payload = msg.getPayload();
        	SugarsoapPortType sugarSoapPort = sugarSoap.getSugarsoapPort(url);
        	
        	if (payload instanceof SetEntryRequestType)
        	{
        		SetEntryRequestType entryRequestType = (SetEntryRequestType) payload;
        		SetEntryResponseType response = sugarSoapPort.setEntry(entryRequestType);
        	    
        	    return new DefaultMuleMessage(response);
        	}
        	else if (payload instanceof SetEntriesRequestType)
        	{
        		SetEntriesRequestType entriesRequestType = (SetEntriesRequestType) payload;
        		SetEntriesResponseType response = sugarSoapPort.setEntries(entriesRequestType);
                
                return new DefaultMuleMessage(response);
        	}
        }
        //Get the fields for a module
        else if (StringUtils.equals(operation, SugarcrmProperties.SUGARCRM_OPERATION_GET_FIELDS))
        {
        	Object payload = msg.getPayload();
        	SugarsoapPortType sugarSoapPort = sugarSoap.getSugarsoapPort(url);
        	
        	if (payload instanceof GetModuleFieldsRequestType)
        	{
        		GetModuleFieldsRequestType moduleFieldsRequestType = (GetModuleFieldsRequestType) payload;
        		GetModuleFieldsResponseType response = sugarSoapPort.getModuleFields(moduleFieldsRequestType);
        	    
        	    return new DefaultMuleMessage(response);
        	}
        }
        //LOGOUT
        if (StringUtils.equals(operation, SugarcrmProperties.SUGARCRM_OPERATION_LOGOUT))
        {
        	Object payload = msg.getPayload();
        	SugarsoapPortType sugarSoapPort = sugarSoap.getSugarsoapPort(url);
        	
        	if (payload instanceof LogoutRequestType)
        	{
        		LogoutRequestType logoutRequestType = (LogoutRequestType) payload;
        		LogoutResponseType logoutResponseType = sugarSoapPort.logout(logoutRequestType);
        	    
        	    return new DefaultMuleMessage(logoutResponseType);
        		//return new DefaultMuleMessage(SugarcrmProperties.SUGARCRM_SUCCESSFULL_LOGIN);
        	}
            
        }

        return null;
        
    }
    
    protected String performMd5(String value) throws NoSuchAlgorithmException
    {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        algorithm.reset();
        algorithm.update(value.getBytes());
        byte messageDigest[] = algorithm.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++)
        {
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        }

        return hexString.toString();

    }

    public void doDispose()
    {
        // Optional; does not need to be implemented. Delete if not required

        /*
         * IMPLEMENTATION NOTE: Is called when the Dispatcher is being disposed and
         * should clean up any open resources.
         */
    }

}
