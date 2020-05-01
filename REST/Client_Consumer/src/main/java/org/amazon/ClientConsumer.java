package org.amazon;

import javax.print.attribute.standard.Media;
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
        WebTarget webTarget=client.target("http://localhost:8080/Messenger/webapi/messages");

        Response response=webTarget.request().accept(MediaType.APPLICATION_XML).get(); //Request: Type of msg client sends in its message body. //Accept: Type of msg client expects from the server.

        GenericType<List<String>> stringListType = new GenericType<List<String>>() {};
        System.out.println("Type"+stringListType.getType());
        System.out.println("Type"+stringListType.getRawType());

        if(response.getStatus()==200)
        {
           // System.out.println("Entered response");
           // List<Message> msg= (List<Message>) response.readEntity(Message.class);
            final List<Message> result = response.readEntity(new GenericType<List<Message>>() {});
           // System.out.println(result);
        }
    }

}
