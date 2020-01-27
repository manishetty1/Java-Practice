package org.amazon;

import org.eclipse.yasson.internal.properties.Messages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MyResource
{

    MessengerService msgService=new MessengerService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_XML) //Bydefault, JAXB implementation will be used for java object (list<message>) to XML Conversion.
    public List<Message> getMessages()
    {

        return msgService.getAllMessages();
    }
}
