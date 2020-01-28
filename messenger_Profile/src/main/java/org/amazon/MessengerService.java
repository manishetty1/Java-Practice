package org.amazon;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MessengerService
{

    Map<Integer,Message> msgMap = new DatabaseClass().getAllMessages();

    public MessengerService()
    {
        msgMap.put(1, new Message(1, "Manish", "Hello Manish!"));
        msgMap.put(2, new Message(2, "Shetty", "Hello, Shetty!"));
    }

    public List<Message> getAllMessages()
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

    public Message updateMessage(Message msg)
    {
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
