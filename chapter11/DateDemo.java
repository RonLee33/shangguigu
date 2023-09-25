package chapter11;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
    }
}
