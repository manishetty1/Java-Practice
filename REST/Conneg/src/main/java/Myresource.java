import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("date/{shortdate}")
public class Myresource
{
        // http://localhost:8080/Conneg_war/webapi/date/shortdate
        @GET
        @Produces(value={MediaType.TEXT_PLAIN, "text/ShortDate"}) //Redirect the call based on the "Accept header" in the GET request. If accept header = text/shortdate, then redirect the call to the shortdateProvider else the textPlainProvider.
        public Date getRequestedDate()
        {
            return Calendar.getInstance().getTime();
        }
}