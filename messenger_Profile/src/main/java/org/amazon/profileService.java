package org.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class profileService
{
    Map<String,Profile> profileMap = new DatabaseClass().getAllProfile();

    public profileService()
    {
        profileMap.put("Manish", new Profile(1, "Manish", "Shetty!", "Manishprofile"));
    }

    public List<Profile> getAllProfiles()
    {
        return new ArrayList<Profile>(profileMap.values());
    }

    public Profile getProfile(String profileName)
    {
        return profileMap.get(profileName);
    }

    public Profile addMessage(Profile profile)
    {
        profile.setID(profileMap.size()+1);
        profileMap.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile updateMessage(Profile profile)
    {
        profileMap.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile deleteMessage(String profileName)
    {
        return (profileMap.remove(profileName));
    }

}
