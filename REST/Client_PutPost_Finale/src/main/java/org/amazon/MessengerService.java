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

    public List<Message> getMessages()
    {
        return new ArrayList<Message>(msgMap.values());
    }

   public Message getMessage(int msgid)
    {
        return msgMap.get(msgid);
    }

    public Message addMessage(Message msg)
    {
        msg.setId(msgMap.size()+1);
        msgMap.put(msg.getId(),msg);
        return msg;
    }

    public Message putMessage(int messageID, Message msg)
    {
        msg.setId(messageID);
        if(msg.getId()<=0)
        {
            return null;
        }
        msgMap.put(msg.getId(),msg);
        return msg;
    }

    public Message deleteMessage(int msgID)
    {
        return (msgMap.remove(msgID));
    }

}
