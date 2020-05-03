package org.amazon;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Message
{
    private int Id;
    private String author;
    private String message;
    private Date Created;

    public Message()
    {

    }

    public Message(int msgID, String author, String message)
    {
        this.Id=msgID;
        this.author = author;
        this.message = message;

    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
