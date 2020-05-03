package org.amazon;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ClientConsumer
{
    public static void main(String[] args)
    {
        Client client=ClientBuilder.newClient();
        WebTarget webTarget=client.target("http://localhost:8080/Messenger/webapi/");
        WebTarget messagesURI=webTarget.path("messages");
        WebTarget messageIDURI=webTarget.path("{messageID}");

        Response response=messageIDURI.resolveTemplate("messageID","1").request().accept(MediaType.APPLICATION_JSON).get(); //Request: Type of msg client sends in its message body. //Accept: Type of msg client expects from the server.

        if(response.getStatus()==200)
        {
            // System.out.println("Entered response");
            // List<Message> msg= (List<Message>) response.readEntity(Message.class);
            final List<Message> result = response.readEntity(new GenericType<List<Message>>() {});
            System.out.println(result);
        }

    }
}
