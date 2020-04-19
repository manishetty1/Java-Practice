import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("date/{daystring}")
public class Myresource
{
    // http://localhost:8080/SampleMessageBody_war/webapi/date/today
    @GET
    @Produces(MediaType.TEXT_PLAIN) //JAXRS looks at this and sees if there are any "providers" who can convert date -> MediaType.Text_Plain. Since date to text_plain is not a default conversion which JAXRS suppports.
    public Date getRequestedDate()
    {
        return Calendar.getInstance().getTime();
    }

}