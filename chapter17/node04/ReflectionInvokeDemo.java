package chapter17.node04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import chapter17.node01.Person;

/** 反射：调用指定的属性、方法和构造器 */
public class ReflectionInvokeDemo {
    public static void main(String[] args) throws Exception{
        // getRefField();
        invokeRefMethod();
        // invokeRefConstructor();
    }

    public static void getRefField() throws Exception{
        /* 获取及设置属性的值 */ 
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();
        System.out.println("-------------获取运行时类 有权限 的 特定名称的属性------------");
        // 获取运行时类 有权限 的 特定名称的属性
        Field ageField = clazz.getField("age");
        // 获取实例person的属性 age, 相当于 person.age
        System.out.println(ageField.get(person));
        // 设置实例person的属性 age，相当于 person.age = 22
        ageField.set(person, 22);
        System.out.println(person.age);

        System.out.println("-------------暴力访问无权限的【实例】属性------------");
        // 2. 暴力访问无权限的实例属性
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true); // 暴力获权
        
        // get name
        System.out.println(nameField.get(person));
        // set name
        nameField.set(person, "Cribug");
        System.out.println(nameField.get(person));

        System.out.println("-------------暴力访问无权限的【静态】属性------------");
        // 3. 暴力访问无权限的静态属性 Person的 private static String descrition = "nothing";
        Field descriptionField = clazz.getDeclaredField("description");
        descriptionField.setAccessible(true); // 暴力获权
        
        // get description
        // 因为是静态变量，所以可以传入null,表示与具体的实例无关，当然也可将null 换为 具体的实例person
        System.out.println(descriptionField.get(null));
        // set description
        descriptionField.set(null, "Static Field");
        System.out.println(descriptionField.get(null));

    }

    public static void invokeRefMethod() throws Exception{
        /* 调用运行时类指定的方法 */
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();

        /* 调用 private String showNation(String nation, int age)时：
         * 注意 int.class 不能写成 Integer.class！
         * 虽然 int 型数据 能被装箱成 Integer型数据，
         * 但某数的数据类型是不同的，即，int是基本数据类型，Integer是引用数据类型
         * “类型”不一样，因此不能混淆。
         */
        Method showNationMethod = clazz.getDeclaredMethod("showNation", String.class, int.class);
        showNationMethod.setAccessible(true);

        // invoke()返回值与运行时类对应方法声明的返回值一样， showNation()返回String类型的，因此可强转成 String类型
        System.out.println("showNation()返回类型是：" + showNationMethod.getReturnType().getName());
        // 与静态属性类似，若方法是静态方法，则可把person换为null，表示与具体的类无关
        String nation = (String) showNationMethod.invoke(person, "中国", 16); 
        System.out.println(nation);
    }

    public static void invokeRefConstructor() throws Exception{
        /* 调用运行时类指定的构造器 */
        Class<Person> clazz = Person.class;

        // 调用 private Person(String name, int age)
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);// 暴力获权

        Person person = constructor.newInstance("Cribug", 25);
        System.out.println(person);
    }

}
