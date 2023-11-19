package chapter18.node02;

import java.util.function.Function;

import project03.domain.Employee;

/** 数组引用
 * 格式：
 * 数组名[] :: new;
 */

public class ArrayQuote {
    public static void main(String[] args) {
        arrayDemo();
    }

    public static void arrayDemo(){
        /* 通过Function的apply() 返回指定长度的数组
         * 注意区分本例与ConstructorQuote.conDemo1()中举例的区别（形式上和含义上的）
         */
        // raw
        Function<Integer, Employee[]> f1 = new Function<Integer,Employee[]>() {
            @Override
            public Employee[] apply(Integer length) {
                return new Employee[length];
            }
        };

        // lambda
        Function<Integer, Employee[]> f2 = (length) -> new Employee[length];

        // array quote
        Function<Integer, Employee[]> f3 = Employee[]::new;

        System.out.println(f1.apply(10).length);
        System.out.println(f2.apply(20).length);
        System.out.println(f3.apply(30).length);

    }
}
