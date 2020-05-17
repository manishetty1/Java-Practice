package org.amazon;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws IOException
  {
    // get the auth headers

        List<String> authHeaders = containerRequestContext.getHeaders().get("Authorization");
        String authtoken = authHeaders.get(0);
        authtoken = authtoken.replaceFirst("Basic ", "");
        System.out.println("Auth token without basic: " + authtoken);


      // Decode authToken
        String usernameandpasswithcolon = Base64.getDecoder().decode(authtoken);

        // convert to username and password
       /* String[] userandpassArray = usernameandpasswithcolon.split(":");
        if ((userandpassArray[0] == "ManishShetty1") && (userandpassArray[1] == "shivashiva27"))
        {
            System.out.println("Authenticate sucessfully");
        }
        else
        {
            System.out.println("Authenticate failure");
        }*/

    // Authenticate: If true:return. False: return a response failure
  }
}
