import javax.print.attribute.standard.Media;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

/* The custom MessageBodyWriter that converts Data object to OutputStream */
@Provider
@Produces(MediaType.TEXT_PLAIN)
public class SampleMessageBodyWriter implements MessageBodyWriter<Date>
{

    /**
     * Ascertain if the MessageBodyWriter supports a particular type.
     *
     * @param type        the class of instance that is to be written.
     * @param genericType the type of instance to be written, obtained either
     *                    by reflection of a resource method return type or via inspection
     *                    of the returned instance. {@link GenericEntity}
     *                    provides a way to specify this information at runtime.
     * @param annotations an array of the annotations attached to the message entity instance.
     * @param mediaType   the media type of the HTTP entity.
     * @return {@code true} if the type is supported, otherwise {@code false}.
     */
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
    {
        return Date.class.isAssignableFrom(type); //Determines if the class or interface represented by this Class object (Date) is either the same as, or is a superclass or superinterface of, the class or interface represented by the specified Class parameter (type). It returns true if so; otherwise it returns false.
    }

    /**
     * Originally, the method has been called before {@code writeTo} to ascertain the length in bytes of
     * the serialized form of {@code t}. A non-negative return value has been used in a HTTP
     * {@code Content-Length} header.
     * <p>
     * As of JAX-RS 2.0, the method has been deprecated and the value returned by the method is ignored
     * by a JAX-RS runtime. All {@code MessageBodyWriter} implementations are advised to return {@code -1}
     * from the method. Responsibility to compute the actual {@code Content-Length} header value has been
     * delegated to JAX-RS runtime.
     * </p>
     *
     * @param date        the instance to write
     * @param type        the class of instance that is to be written.
     * @param genericType the type of instance to be written. {@link GenericEntity}
     *                    provides a way to specify this information at runtime.
     * @param annotations an array of the annotations attached to the message entity instance.
     * @param mediaType   the media type of the HTTP entity.
     * @return length in bytes or -1 if the length cannot be determined in advance.
     */
    @Override
    public long getSize(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
    {
        return 0;
    }

    /**
     * Write a type to an HTTP message. The message header map is mutable
     * but any changes must be made before writing to the output stream since
     * the headers will be flushed prior to writing the message body.
     *
     * @param date         the instance to write.
     * @param type         the class of instance that is to be written.
     * @param genericType  the type of instance to be written. {@link GenericEntity}
     *                     provides a way to specify this information at runtime.
     * @param annotations  an array of the annotations attached to the message entity instance.
     * @param mediaType    the media type of the HTTP entity.
     * @param httpHeaders  a mutable map of the HTTP message headers.
     * @param outputStream the {@link OutputStream} for the HTTP entity. The
     *                     implementation should not close the output stream.
     * @throws IOException             if an IO error arises.
     * @throws WebApplicationException if a specific HTTP error response needs to be produced.
     *                    Only effective if thrown prior to the message being committed.
            */
        @Override
        public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream) throws IOException, WebApplicationException
        {

        try
        {

            outputStream.write(date.toString().getBytes()); //get the byte stream and write it to the output stream.

            /*Marshaller marsshaller=JAXBContext.newInstance().createMarshaller();
            marsshaller.marshal(date,outputStream); convert to xml and push to the output streams*/

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
