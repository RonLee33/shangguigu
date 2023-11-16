package chapter17.node04;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import chapter17.node01.Person;

/** 本节主要获取运行时对象的完整内部信息之本身，
 * 主要是对象所属类 本身  的属性、方法，
 * 不涉及其父类、父接口、包信息的获取 ,
 * 本节内容了解即可
 * */

public class NewInstanceDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException{
        // demo1();
        // demo2();
        // demo3();
        // demo4();
        demo5();
    }

    public static void demo1() throws InstantiationException, IllegalAccessException{
        /** 创建运行时类的对象 */
        Class<Person> clazz = Person.class;

        // 无Person空参构造器时，报 InstantiationException
        // 有Person空参构造器但权限不够(被private/protected等修饰)时,报IllegalAccessException
        // newInstance()调用条件较多
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    public static void demo2(){
        /** 获取运行时类的内部结构1：
         * 获取所有属性
         */
        Class<Person> clazz = Person.class;

        // getFields()：获取运行时类本身及其所有父类中声明为public权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        
        System.out.println("--------------getDeclaredFields()：获取运行时类本身所有的属性-----------------");
        // getDeclaredFields()：获取运行时类本身声明所有的属性(即便没有对应的权限也会获取),但不包括其父类的属性
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println(field);
        }
    }

    public static void demo3(){
        /** 获取属性的权限信息、数据类型、属性名 */
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            /** 
             * PUBLIC    1
             * PRIVATE   2
             * PROTECTED 4
             * STATIC    8
             * FINAL     16
             * 则10=8+2，即private static
             * ...
             */
            int modifier = field.getModifiers();
            System.out.print(modifier + " -> " + Modifier.toString(modifier) + "\t");

            // 数据类型
            Class<?> type = field.getType();
            System.out.print("Type(" + type.getName() + ")\t");

            // 变量名
            String fieldName = field.getName();
            System.out.println(fieldName);
        }
    }

    public static void demo4(){
        // 获取运行时对象的方法

        Class<Person> clazz = Person.class;
        // getMethods()：获取运行时类本身及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------------getDeclaredMethods()：获取运行时类本身所有的方法-----------------");
        // getDeclaredMethods()：获取运行时类本身声明所有的方法(即便没有对应的权限也会获取),但不包括其父类的属性
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
    }

    public static void demo5(){
        // 获取运行时类的方法、注解相关的详细信息

        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 1.获取方法声明的注解，方法可能被多个注解修饰，故此次用复数形式获取所有注解并打印
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            // 2.权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");

            // 3.返回值类型
            System.out.print(method.getReturnType().getName() + "\t");

            // 4.方法名
            System.out.print(method.getName() + "(");

            // 5.形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }

                    System.out.println(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.print(")");

            // 6.抛出异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0){
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }

    }
}
