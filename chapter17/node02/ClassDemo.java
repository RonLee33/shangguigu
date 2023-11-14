package chapter17.node02;

import java.lang.annotation.ElementType;

import chapter17.node01.Person;

/** 获取Class对象的四种方式 */

public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException{
        // getClassInstanceDemo();
        classPointableStructure();
    }

    public static void getClassInstanceDemo() throws ClassNotFoundException{
        // 1.调用运行时类的静态属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // 2.调用运行时类的对象的getClass()方法
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();

        // 3.调用Class的静态方法forName(String className)
        String className = "chapter17.node01.Person";
        Class<?> clazz3 = Class.forName(className);

        // 运行时内存中只会存在一个类的被加载到内存中的的.class文件的运行中的对应结构，
        // 此结构即为 Class 类的实例，可把 Class理解为Python中的元类（“类的类”）
        // 由于运行时中同一个类只存在一个Class的示例，因此，不同方式获取的Class对象的引用地址其实是同一个
        // 这就是以下比较均返回 true 的原因
        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz1 == clazz3); // true

        // 4.使用类的加载器的方式（了解）此方法的作用和第3中差不多
        Class<?> clazz4 = ClassLoader.getSystemClassLoader().loadClass(className);
        System.out.println(clazz1 == clazz4);
    }

    // Class对象可反射、指向的结构对象（或数据类型）有哪些，
    // Java中的一切数据类型都可指向，见以下举例
    public static void classPointableStructure() {
        Class c1 = Object.class; // 一般引用类型，即对象（示例）
        Class c2 = Comparable.class; // 接口
        Class c3 = String[].class; // 对象数组
        Class c4 = int[][].class; // 基本数据类型的多维数据（此处为二维）
        Class c5 = ElementType.class; // 枚举
        Class c6 = Override.class; // 注解
        Class c7 = int.class; // 基本数据类型
        Class c8 = void.class; // "无返回值"
        Class c9 = Class.class; // Class

        int[] a = new int[10];
        int[] b = new int[100];
        int[][] c = new int[10][];

        Class ca = a.getClass();
        Class cb = b.getClass();
        Class cc = c.getClass();


        // 同一维度的同数据类型的对象的class实例引用相同，此处表现为 同是int型的一维数据对象的Class引用相同，即便a与b的长度不同
        System.out.println(ca == cb); //true,
        // 反之，不同维度的同数据类型的对象的class实例引用也不同，即便a与c的长度相同，都是10，但a是一维数组，c是二维数组
        System.out.println(ca == cc);
    
    }
}
