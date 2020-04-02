import javax.ws.rs.ext.ParamConverter;
import java.util.Calendar;

public class MyDateConverter implements ParamConverter
{
    MyDate myDateObj=new MyDate();

    @Override
    public MyDate fromString(String s)
    {

        Calendar rightNowCal=Calendar.getInstance();

        if(s.equals("yesterday"))
        {
            rightNowCal.add(Calendar.DATE,-1);

        }
        else if(s.equals("tommorow"))
        {
            rightNowCal.add(Calendar.DATE,+1);
        }

        myDateObj.setDate(rightNowCal.get(Calendar.DATE));
        myDateObj.setMonth(rightNowCal.get(Calendar.MONTH));
        myDateObj.setYear(rightNowCal.get(Calendar.YEAR));


        return myDateObj;
    }

    @Override
    public String toString(Object o)
    {
        return ((MyDate)o).toString();
    }
}

