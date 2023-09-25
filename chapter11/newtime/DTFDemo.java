package chapter11.newtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DTFDemo {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 1, 23, 12, 2);
        System.out.println("未指定日期格式之前：" + localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

        // DateTime -> String
        String dateStr = dateTimeFormatter.format(localDateTime);
        System.out.println("指定日期格式之后：" + dateStr);

        // String -> DateTime
        dateStr = "2027年10月01日 23时12分02秒";
        TemporalAccessor TemporalAccessor = dateTimeFormatter.parse(dateStr);
        LocalDateTime transtoLDT = LocalDateTime.from(TemporalAccessor);
        System.out.println(transtoLDT);

        

    }
}
