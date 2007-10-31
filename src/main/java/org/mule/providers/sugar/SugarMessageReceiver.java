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

import org.mule.providers.ConnectException;
import org.mule.providers.AbstractPollingMessageReceiver;
import org.mule.umo.UMOComponent;
import org.mule.umo.endpoint.UMOEndpoint;
import org.mule.umo.lifecycle.InitialisationException;
import org.mule.umo.provider.UMOConnector;

/**
 * <code>SugarMessageReceiver</code> TODO document
 */
public class SugarMessageReceiver extends  AbstractPollingMessageReceiver {

    /* For general guidelines on writing transports see
       http://mule.mulesource.org/display/MULE/Writing+Transports */

    public SugarMessageReceiver(UMOConnector connector, UMOComponent component,
                              UMOEndpoint endpoint, long pollingFrequency)
            throws InitialisationException
    {
        super(connector, component, endpoint, pollingFrequency);
    }
    public void doConnect() throws ConnectException
    {
        /* IMPLEMENTATION NOTE: Should make a connection to the underlying
           transport i.e. connect to a socket or register a soap service. When
           there is no connection to be made this method should be used to
           chack that resources are available. For example the
           FileMessageReceiver checks that the directories it will be using
           are available and readable. The MessageReceiver should remain in a
           'stopped' state even after the doConnect() method is called. This
           means that a connection has been made but no events will be
           received until the start() method is called. Calling start() on the
           MessageReceiver will call doConnect() if the receiver hasn't
           connected. */

        /* IMPLEMENTATION NOTE: If you need to spawn any threads such as
           worker threads for this receiver you can schedule a worker thread
           with the work manager i.e.

             getWorkManager().scheduleWork(worker, WorkManager.INDEFINITE, null, null);
           Where 'worker' implemments javax.resource.spi.work.Work */

        /* IMPLEMENTATION NOTE: When throwing an exception from this method
           you need to throw an ConnectException that accepts a Message, a
           cause exception and a reference to this MessageReceiver i.e.

             throw new ConnectException(new Message(Messages.FAILED_TO_SCHEDULE_WORK), e, this);
        */

        // TODO the code necessay to Connect to the underlying resource
    }

    public void doDisconnect() throws ConnectException
    {
        /* IMPLEMENTATION NOTE: Disconnects and tidies up any rources allocted
           using the doConnect() method. This method should return the
           MessageReceiver into a disconnected state so that it can be
           connected again using the doConnect() method. */

        // TODO release any resources
    }

    public void doStart()
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Should perform any actions necessary to enable
           the reciever to start reciving events. This is different to the
           doConnect() method which actually makes a connection to the
           transport, but leaves the MessageReceiver in a stopped state. For
           polling-based MessageReceivers the start() method simply starts the
           polling thread, for the Axis Message receiver the start method on
           the SOAPService is called. What action is performed here depends on
           the transport being used. Most of the time a custom provider
           doesn't need to override this method. */
    }

    public void doStop()
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Should perform any actions necessary to stop
           the reciever from receiving events. */
    }

    public void doDispose()
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Is called when the Conector is being dispoed
           and should clean up any resources. The doStop() and doDisconnect()
           methods will be called implicitly when this method is called. */
    }

    public void poll() throws Exception
    {
        /* IMPLEMENTATION NOTE: Once you have read the object it can be passed
           into Mule by first wrapping the object with the Message adapter for
           this transport and calling routeMessage i.e.

            UMOMessageAdapter adapter = connector.getMessageAdapter(object);
            routeMessage(new MuleMessage(adapter), endpoint.isSynchronous());
        */

        // TODO request a message from the underlying technology e.g. Read a file
    }

}

