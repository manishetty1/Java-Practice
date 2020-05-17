package org.amazon;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/messages")
public class MessengerService implements MyResource
{
    Map<Integer, Message> msgMap;
    {
        msgMap = new DatabaseClass().getAllMessages();
        msgMap.put(1, new Message(1, "Manish", "Hello Manish!"));
        msgMap.put(2, new Message(2, "Shetty", "Hello, Shetty!"));
    }

   public Message getMessage(int msgid)
    {
        return msgMap.get(msgid);
    }

}
