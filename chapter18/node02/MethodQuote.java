package chapter18.node02;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import project03.domain.Employee;

/** 方法引用
 * 接口函数的形参列表、返回值
 * 和其实现时方法体语句块(该语句块中只能由一条语句)中【方法】的形参列表、返回值
 * 满足以下条件：
 * 
 * 入参：在同一位置顺序上、各参数的数据类型相同，且形参个数一致
 * 返回值：相同
 */

public class MethodQuote {
    public static void main(String[] args) {
        // quoteDemo();
        // quoteDemo1();
        // quoteDemo2();
        // quoteDemo3();
        // quoteDemo4();
        quoteDemo5();
    }

    public static void quoteDemo(){
        // 方法引用(1):
        // 实例 :: 实例方法
        
        // 1.有入参，无返回值 
        Consumer<String> c1 = s -> System.out.println(s);
        c1.accept("Hello, Lambda");

        // 实例 :: 实例方法
        Consumer<String> c2 = System.out :: println;
        c2.accept("Hello, (instance :: method) of MethodQuote");
    }

    public static void quoteDemo1(){
        // 方法引用(1):
        // 实例 :: 实例方法
        // 2.无入参，有返回值
        Employee employee = new Employee(1, "魁拔", 22, 60000.32);

        Supplier<String> s1 = new Supplier<String>() {
            @Override
            public String get() {
                return employee.getName();
            }
        };
        System.out.println(s1.get());

        // Lambda
        Supplier<String> s2 = () -> employee.getName();
        System.out.println(s2.get());

        // 实例 :: 实例方法
        Supplier<String> s3 = employee::getName;
        System.out.println(s3.get());
    }

    public static void quoteDemo2(){
        // 方法引用(2):
        // 类 :: 静态方法

        // 举例一：Comparator
        // Raw
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        
        // Lambda
        Comparator<Integer> c2 = (o1, o2) -> Integer.compare(o1, o2);
        
        // Method Quote
        Comparator<Integer> c3 = Integer :: compare;

        System.out.println(c1.compare(12, 32));
        System.out.println(c2.compare(12, 32));
        System.out.println(c3.compare(12, 32));

        // 举例二：Function
        Function<Double, Long> f1 = new Function<Double,Long>() {
            @Override
            public Long apply(Double t) {
                return Math.round(t);
            }
        };

        Function<Double, Long> f2 = t -> Math.round(t);

        Function<Double, Long> f3 = Math :: round;

        System.out.println(f1.apply(3.45));
        System.out.println(f2.apply(3.45));
        System.out.println(f3.apply(3.45));
    }

    public static void quoteDemo3(){
        // 方法引用(3):
        // 类 :: 实例方法
        
        // 举例一：Comparator
        // Raw
        Comparator<String> c1 = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        // Lambda
        Comparator<String> c2 = (s1, s2) -> s1.compareTo(s2);

        // Method Quote
        Comparator<String> c3 = String :: compareTo;

        System.out.println(c1.compare("abc", "def"));
        System.out.println(c2.compare("abc", "def"));
        System.out.println(c3.compare("abc", "def"));
    }

    public static void quoteDemo4(){
        // 方法引用(3):
        // 类(写的是调用者实例所属的类，即入参的第一个参数的所属的类) :: 实例方法
        
        // 举例二：BiPredicate
        // Raw
        BiPredicate<String, String> b1 = new BiPredicate<>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };

        // Lambda
        BiPredicate<String, String> b2 = (s1, s2) -> s1.equals(s2);

        // Method Quote
        BiPredicate<String, String> b3 = String :: equals;

        System.out.println(b1.test("null", "null"));
        System.out.println(b2.test("null", "null"));
        System.out.println(b3.test("null", "null"));
    }

    public static void quoteDemo5(){
        // 方法引用(3):
        // 类(写的是调用者实例所属的类，即入参的第一个参数的所属的类) :: 实例方法
        
        // 举例三：Function的apply与Employee的getName
        // Lambda
        Function<Employee, String> f1 = (employee) -> employee.getName();
        // Method Quote
        Function<Employee, String> f2 = Employee :: getName;

        // 测试效果
        Employee liEmployee = new Employee(1001, "LiXiaolong", 24, 9999999999.099);
        System.out.println(f1.apply(liEmployee));
        System.out.println(f2.apply(liEmployee));

    }
}
