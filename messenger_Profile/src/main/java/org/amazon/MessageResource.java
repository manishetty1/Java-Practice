package org.amazon;

import org.glassfish.jersey.message.internal.MediaTypeProvider;
import sun.security.krb5.internal.MethodData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MessageResource
{

    MessengerService msgService=new MessengerService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON) //Bydefault, JAXB implementation will be used for java object (list<message>) to XML Conversion.
    public List<Message> getMessages()
    {
        return msgService.getAllMessages();
    }

    @GET
    @Path("/{messageID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageID") int msgid)
    {
        return msgService.getMessage(msgid);
    }

    @POST //Adds a "new" resource
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Message addMessage(Message msg)
    {
        return msgService.addMessage(msg);
    }

    @PUT
    @Path("/{messageID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Message putMessage(@PathParam("messageID") int messageID, Message msg)
    {
        msg.setId(messageID);
        msgService.updateMessage(msg);
        return msg;
    }


    @DELETE
    @Path("/{messageID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageID") int msgID)
    {
        return msgService.deleteMessage(msgID);
    }

}
