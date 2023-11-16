package chapter17.node04;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/** (熟悉) 
 * 获取运行时类的内部结构2：
 * 父类、接口们、包、带泛型的父类、父类的泛型等
*/

public class ReflectionGetParent {
    public static void main(String[] args) throws ClassNotFoundException{
        func1();
    }

    public static void func1() throws ClassNotFoundException{
        // 1.获取运行时类的父类
        Class<?> clazz = Class.forName("chapter17.node01.Person");
        Class<?> superClass = clazz.getSuperclass();
        System.out.println(superClass);

        // 2.获取运行时类的带泛型的父类
        Type genericSuperClass = clazz.getGenericSuperclass();
        System.out.println(genericSuperClass);

        // 3.获取运行时类实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> class1 : interfaces) {
            System.out.println(class1);
        }

        // 4.获取运行时所在的包
        Package package1 = clazz.getPackage();
        System.out.println(package1);

        // 5.获取运行时类的父类的泛型(不易) 与 2是有区别的
        // 需要通过 2 的带泛型的父类来获取 泛型实参
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
        Type[] arguments = parameterizedType.getActualTypeArguments(); // 获取父类泛型实参，可能有多个，因此是数组
        System.out.println(((Class<?>) arguments[0]).getName());// 得到Creature<String>中的String


        
    }
}
