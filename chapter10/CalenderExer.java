package chapter10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**输入年份和月份，输出该月日历。
 * 
闰年计算公式：
年份可以被4整除但不能被100整除，
或者可以被400整除。
*/

public class CalenderExer {
    public static void main(String[] args) throws ParseException {
        CalenderExer exer = new CalenderExer();

        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = input.nextInt();

        System.out.print("请输入月份：");
        int month = input.nextInt();

        exer.showCalender(year, month);

        input.close();
    }

    private String getHeader(){
        String head = "日\t一\t二\t三\t四\t五\t六\t";
        return head;
    }

    public boolean isLeapYear(int year){
        boolean condition1 = year % 4 == 0 && year % 100 != 0;
        boolean condition2 = year % 400 != 0;
        return condition1 && condition2;
    }

    private int GetNumberOfDay(int year, int month){
        int[] dayOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)){
            dayOfMonths[1] = 29;
        }
        return dayOfMonths[month - 1];
        
    }

    private String getBody(int year, int month) throws ParseException{
        String body = "";

        // int -> Date
        String dateStr = String.format("%d-%02d-01", year, month);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);

        // Date -> Calender
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);


        int weekday = calendar.get(Calendar.DAY_OF_WEEK);

        String space = "";
        for (int i = 1; i < weekday; i++) {
            space = space + " \t";
        }

        body = body + space;
        for (int i = 1; i <= GetNumberOfDay(year, month); i++){
            body = body + i + '\t';
            if ((i + weekday - 1) % 7 == 0){
                body = body + "\n";
            }
        }

        return body;
    }

    public void showCalender(int year, int month) throws ParseException{
        String head = getHeader();
        System.out.println(head);

        String body = getBody(year, month);
        System.out.println(body);
    }
}
