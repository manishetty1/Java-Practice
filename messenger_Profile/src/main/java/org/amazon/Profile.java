package org.amazon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@XmlRootElement
public class Profile
{
    private int ID;
    private String firstName;
    private String secondName;
    private String profileName;

    Profile()
    {

    }

    public Profile(int ID, String firstName, String secondName, String profileName)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.secondName = secondName;
        this.profileName = profileName;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public String getProfileName()
    {
        return profileName;
    }

    public void setProfileName(String profileName)
    {
        this.profileName = profileName;
    }
}
