package chapter11.newtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate nowLD = LocalDate.now();
        System.out.println("nowLD=" + nowLD);

        LocalTime nowLT = LocalTime.now();
        System.out.println("nowLT=" + nowLT);

        LocalDateTime nowLDT = LocalDateTime.now();
        System.out.println("nowLDT=" + nowLDT);

        LocalDate localDate = LocalDate.of(2023, 9, 25);
        System.out.println("localDate=" + localDate);
        LocalTime localTime = LocalTime.of(16, 4, 5);
        System.out.println("localTime=" + localTime);
        LocalDateTime localDateTime = LocalDateTime.of(2023, 9, 25, 16, 4, 5);
        System.out.println("localDateTime=" + localDateTime);

        
        System.out.println(localDate.getDayOfMonth());// 月份天数 [1, 31]
        System.out.println(localDate.getDayOfWeek()); // 获取星期几

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(localDate.format(dtf));

        System.out.println("2023是否为闰年：" + localDate.isLeapYear());
        System.out.println(localDate.minusMonths(1));
        
    }
}
