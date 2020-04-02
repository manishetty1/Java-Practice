package org.amazon;

import java.util.HashMap;
import java.util.Map;



class DatabaseClass
{

    private static Map<Integer, Message> messageMap = new HashMap<>();
    private static Map<Integer,Profile> profileMap = new HashMap<>();


    public Map<Integer, Message> getAllMessages()
    {
        return messageMap;
    }

    public Map<Integer, Profile> getAllProfile()
    {
        return profileMap;
    }

}
