package chapter18.node02;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import project03.domain.Employee;

/** 构造器引用
 * 形式 类名::new;
 * 抽象接口方法实现时，其返回值是调用构造器生成的对象时可使用,入参的规则和方法引用一致
 */

public class ConstructorQuote {
    public static void main(String[] args) {
        // conDemo();
        // conDemo1();
        conExer();
    }

    public static void conDemo(){
        // 举例一：Supplier的get(),调用空参构造器
        // Raw
        Supplier<Employee> s1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();// 调用构造器生成对象返回
            }  
        };

        // Lambda
        Supplier<Employee> s2 = () -> new Employee();

        // Constructor Quote
        Supplier<Employee> s3 = Employee :: new; //构造器引用,调用空参构造器

        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
    }

    public static void conDemo1(){
        // 举例二：Function的apply(),调用有参构造器
        Function<Integer, Employee> f1 = new Function<Integer,Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };

        Function<Integer, Employee> f2 = (id) -> new Employee(id);

        /* 虽然形式上和无参构造器的引用一样，
         * 但实际因为 【类型推断】的原因，编译器会依据Function<Integer, Employee>的
         * 入参 Integer会自动匹配Employee中入参为Integer/int(自动装箱)的构造器（即，public Employee(int age)）生成对象
         */
        Function<Integer, Employee> f3 = Employee :: new;

        System.out.println(f1.apply(11).getId());
        System.out.println(f2.apply(12).getId());
        System.out.println(f3.apply(13).getId());
    }

    public static void conExer(){
        /* 练习：
         * 通过二次函数BiFunction<T, U, R>的apply(T,U)，
         * 调用 构造器Employee(int id, String name)
         */ 

        // Raw
        BiFunction<Integer, String, Employee> b1 = new BiFunction<Integer,String,Employee>() {
            @Override
            public Employee apply(Integer id, String name) {
                return new Employee(id, name);
            }
        };

        // Lambda
        BiFunction<Integer, String, Employee> b2 = (id, name) -> new Employee(id, name);

        // Constructor Quote
        BiFunction<Integer, String, Employee> b3 = Employee :: new;

        System.out.println(b1.apply(12, "ZhangSan"));
        System.out.println(b2.apply(13, "LiSi"));
        System.out.println(b3.apply(14, "WangWu"));
    }
}

