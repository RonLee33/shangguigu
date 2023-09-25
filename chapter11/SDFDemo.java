package chapter11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDFDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS E Z");
        Date date = new Date();
        // Date -> String
        String dateStr = sdf.format(date);
        System.out.println(dateStr);

        // String -> Date
        Date date2 = sdf.parse(dateStr);
        System.out.println(date2);

    }
}
