package chapter18.node01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;

/** JDK新特性之Lambda表达式 */

public class LambdaDemo {
    public static void main(String[] args) {
        // demo1();
        // demo2();
        demo3();
    }

    public static void demo1(){
        // 无入参，无返回值的Lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        
        r1.run();

        // Lambda 表达式
        Runnable r2 = () -> {
            System.out.println("Hello Lambda.");
        };

        r2.run();
        
    }

    public static void demo2(){
        // 有入参，有返回值，且方法体只有一句语句时，return 可省略，Lambda
        Comparator<Integer> c1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println("无Lambda：" + c1.compare(12, 21));

        // Lambda 不省略返回值的语句
        Comparator<Integer> c2 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println("不省略return的Lambda：" + c2.compare(12, 21));

        // Lambda 省略返回值的语句
        Comparator<Integer> c3 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("省略return的Lambda：" + c3.compare(12, 21));

        // Lambda的终极简写方式：方法引用
        Comparator<Integer> c4 = Integer::compare;
        System.out.println("Lambda的终极简写方式：方法引用：" + c4.compare(12, 21));

    }

    public static void demo3(){
        /* Java 类型推断
         * Lambda 入参只有一个时，圆括号与形参的类型声明可省略，
         * 借助Java类型推断，编译器可推断出对应的类型
         */

        // s1可写成(String s1) 或 (s1)
        Consumer<String> con1 = s1 -> {System.out.println(s1);};
        con1.accept("Hi, 类型推断");

        // 类型推断的另一个例子

        // new HashMap<>() 无需写成new HashMap<String, Integer>,
        // 编译器可推断出实参泛型，此写法在JDK 7 及之后可使用
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Lee", 26);
        map.put("JuanShi", 24);


        // var 代替推断出的实际类型 Set<Map<K, V>.Entry<String, Integer>>
        // 此写法在JDK 10 及之后可使用
        var entries = map.entrySet();
        for (Entry<String,Integer> entry : entries) {
            System.out.println(entry);
        }
    }
        
        

}
