package org.amazon;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */

public interface MyResource
{
    @GET
    @Produces(MediaType.APPLICATION_JSON) //Bydefault, JAXB implementation will be used for java object (list<message>) to XML Conversion.
    public List<Message> getMessages();

    @GET
    @Path("/{messageID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageID") int msgid);

    @POST //Adds a "new" resource
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Message addMessage(Message msg);

    @PUT
    @Path("/{messageID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Message putMessage(@PathParam("messageID") int messageID, Message msg);

    @DELETE
    @Path("/{messageID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageID") int msgID);

}
