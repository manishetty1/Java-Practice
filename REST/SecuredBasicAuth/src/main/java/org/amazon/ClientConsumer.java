package org.amazon;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
        WebTarget messagesTarget=webTarget.path("messages");
        WebTarget messageIDTarget=messagesTarget.path("{messageID}");


      Message msg=new Message(7,"CuteBoi", "Manish");

      //Post
     // Response response=messagesTarget.request().post(Entity.json(msg)); //Request: Type of msg client sends in its message body. //Accept: Type of msg client expects from the server.

      //Put
      Response response=messageIDTarget.resolveTemplate("messageID",4).request().put(Entity.json(msg)); //Request: Type of msg client sends in its message body. //Accept: Type of msg client expects from the server.



      if(response.getStatus()==200)
        {
            // System.out.println("Entered response");
            // List<Message> msg= (List<Message>) response.readEntity(Message.class);
            final Message result = (Message) response.readEntity(new GenericType<Message>() {});
            System.out.println(result);
        }
    }
}
