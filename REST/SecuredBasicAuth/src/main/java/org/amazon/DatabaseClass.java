package org.amazon;

import java.util.HashMap;
import java.util.Map;


class DatabaseClass
{

    private static Map<Integer, Message> messageMap = new HashMap<>();

    public Map<Integer, Message> getAllMessages()
    {
        return messageMap;
    }

}
