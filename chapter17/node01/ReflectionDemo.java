package chapter17.node01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    
    public static void main(String[] args) throws Exception{
        // beforeReflection();
        reflectionFunc3();
    }

    public static void beforeReflection(){
        /*在使用反射前调用Person类中的结构*/

        // 1. 创建Person类的实例
        // public Person()
        Person person = new Person();

        // 2. 调用属性
        // public int age
        person.age = 10;
        System.out.println(person.age);

        // 3. 调用方法
        // public void show()
        person.show();
    }

    /** 使用反射完成上述操作 */
    public static void reflectionFunc1() throws Exception{
        // 1. 创建Person类的实例
        // public Person()

        Class<Person> clazz = Person.class;
        Person p1 = clazz.newInstance();
        System.out.println(p1);
    }

    public static void reflectionFunc2() throws Exception{
        // 1. 创建Person类的实例
        // public Person()

        Class<Person> clazz = Person.class;
        Person p1 = clazz.newInstance();
        System.out.println(p1);
        
        // 2. 调用属性
        // public int age
        Field ageField = clazz.getField("age");
        ageField.set(p1, 10);
        System.out.println(ageField.get(p1));

        // 3. 调用方法
        // public void show()
        Method showMethod = clazz.getMethod("show");
        showMethod.invoke(p1);
    }

    /**使用反射，越权调用private等修饰的结构*/
    public static void reflectionFunc3() throws Exception{
        // 1. 调用private修饰的构造器，创建Person实例
        // private Person(String name, int age)
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getDeclaredConstructor(String.class, int.class);
        
        /* 解决 java.lang.IllegalAccessException: 
         * class chapter17.node01.ReflectionDemo cannot access
         * a member of class chapter17.node01.Person with modifiers "private"*/
        cons.setAccessible(true);
        Person p1 = cons.newInstance("Tom", 12);
        System.out.println(p1);

        // 2. 调用private修饰的属性 name
        // private String name;
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p1, "Jerry");
        System.out.println(nameField.get(p1));
        System.out.println(p1);

        // 3. 调用private修饰的实例方法 showNation()
        // private String showNation(String nation)
        Method showNationMethod = clazz.getDeclaredMethod("showNation", String.class);
        showNationMethod.setAccessible(true);
        String info = (String) showNationMethod.invoke(p1, "CHN");
        System.out.println(info);

    }
}
