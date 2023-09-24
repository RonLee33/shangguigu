package chapter10;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        // 获取星期时：1是星期日，2是星期一，以此类推，7是星期六
        // 获取月份时：一月是0，二月是1，以此类推，12月是11
        c.get(Calendar.MONTH);
        System.out.println("修改前的月份：" + c.getTime());
        System.out.println("修改前的c.MONTH=" + c.get(Calendar.MONTH));
        // 设置属性
        c.set(Calendar.MONTH, 0);
        System.out.println("修改后的月份：" + c.getTime());
        System.out.println("修改后的c.MONTH=" + c.get(Calendar.MONTH));

        // 为属性进行加减,两个月前
        c.add(Calendar.MONTH, -2);
        System.out.println("两个月：" + c.getTime());
        System.out.println("c.add(Calendar.MONTH, -2)后：" + c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.YEAR));

        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar c1 = Calendar.getInstance(timeZone);

        // Calender -> Date
        Date date = c1.getTime();
        System.out.println(date);
    }
}
