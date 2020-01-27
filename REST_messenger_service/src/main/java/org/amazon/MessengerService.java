package org.amazon;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessengerService
{

    public List<Message> getAllMessages()
    {
        Message msg1=new Message("Manish","Hello Manish");
        Message msg2=new Message("Manish","Hello Manish");
        Message msg3=new Message("Manish","Hello Manish");

        List msgList=new ArrayList();
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);

        return msgList;

    }

}
