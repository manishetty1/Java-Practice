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
    @Path("/{messageID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageID") int msgid);
}
