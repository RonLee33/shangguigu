package chapter17.node05;

import java.lang.reflect.Field;

/** 通过反射来使用注解的示例 */

public class AnnotionUseDemoByReflection {
    public static void main(String[] args) throws Exception {
        getAnnotionDeclaredInClass();
        getAnnotionDeclaredInField();
    }

    public static void getAnnotionDeclaredInClass(){
        // 获取声明在类上的注解
        Class<Customer> clazz = Customer.class;

        // 通过“类”来调用获取注解
        Table annotion = clazz.getDeclaredAnnotation(Table.class);
        System.out.println(annotion.value()); // t_customer
    }

    public static void getAnnotionDeclaredInField() throws Exception{
        // 获取声明在属性上的注解
        Class<Customer> clazz = Customer.class;
        // 获取属性
        Field nameField = clazz.getDeclaredField("name");
        // 获取属性上的注解
        Column nameColumn = nameField.getDeclaredAnnotation(Column.class);

        System.out.println(nameColumn.columnName());
        System.out.println(nameColumn.columnType());

    }
}
