package org.amazon;

import java.util.HashMap;
import java.util.Map;



class DatabaseClass
{

    private static Map<Integer, Message> messageMap = new HashMap<>();
    private static Map<String,Profile> profileMap = new HashMap<>();


    public Map<Integer, Message> getAllMessages()
    {
        return messageMap;
    }

    public Map<String, Profile> getAllProfile()
    {
        return profileMap;
    }

}
