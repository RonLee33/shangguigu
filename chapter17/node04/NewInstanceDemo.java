package chapter17.node04;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import chapter17.node01.Person;

public class NewInstanceDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException{
        // demo1();
        // demo2();
        demo3();
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
         * 获取所有属性、所有方法、所有构造器
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
        /** 获取属性的权限信息 */
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
}
