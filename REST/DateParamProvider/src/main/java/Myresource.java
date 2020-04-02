import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("date/{daystring}")
public class Myresource
{
    // http://localhost:8080/advanced-jaxrs/webapi/date/today


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRequestedDate(@PathParam("daystring") MyDate myDateObj)
    {
        return "Got " + myDateObj.toString();

    }

}