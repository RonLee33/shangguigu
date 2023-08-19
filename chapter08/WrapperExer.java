package chapter08;

import java.util.Scanner;
import java.util.Vector;

/**
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
 *  提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类java.util.Vector可以根据需要动态伸缩.
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(Object obj); //obj必须是对象
 * 取出向量中的元素：Object obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等

*/
public class WrapperExer {
    public static void main(String[] args) {
        Vector grades = new Vector();
        Scanner scanner = new Scanner(System.in);
        Double grade = scanner.nextDouble();
        while (grade >= 0) {
            grades.addElement(grade);
            //读入下一个成绩
            // 漏写这一步导致无限循环了
            grade = scanner.nextDouble();
        }
        
        // 找出最高分
        double max = (Double)grades.elementAt(0);
        double tmp;
        for (int i = 1; i < grades.size(); i++) {
            tmp = (Double)grades.elementAt(i);
            if (tmp > max) {
                max = tmp;
            }
        }

        for (Object object : grades) {
            tmp = (Double) object;
            if (tmp >= max - 10){
                System.out.println(tmp + " -> " + "A");
            } else if (tmp >= max - 20) {
                System.out.println(tmp + " -> " + "B");
            } else if (tmp >= max - 30) {
                System.out.println(tmp + " -> " + "C");
            } else {
                System.out.println(tmp + " -> " + "D");
            }
        }

        scanner.close();
    }
}
