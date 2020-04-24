import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

/* The custom MessageBodyWriter that converts Data object to OutputStream */
@Provider
@Produces("text/ShortDate")
public class ShortDateSampleMessageBodyWriter implements MessageBodyWriter<Date>
{
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
    {
        return Date.class.isAssignableFrom(type); //Determines if the class or interface represented by this Class object (Date) is either the same as, or is a superclass or superinterface of, the class or interface represented by the specified Class parameter (type). It returns true if so; otherwise it returns false.
    }


    @Override
    public long getSize(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }


    @Override
    public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream) throws IOException, WebApplicationException
    {
        try
        {
            final String time = String.valueOf(date.getDate());
            outputStream.write(time.getBytes()); //get the byte stream and write it to the output stream.
            /*Marshaller marsshaller=JAXBContext.newInstance().createMarshaller();
            marsshaller.marshal(date,outputStream); convert to xml and push to the output streams*/

        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
