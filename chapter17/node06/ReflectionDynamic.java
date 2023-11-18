package chapter17.node06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import chapter17.node01.Person;

public class ReflectionDynamic {
    public static void main(String[] args) throws Exception{

        System.out.println("举例一的验证：根据输入动态地生成实例，生成的实例是动态变化的");
        System.out.println(getStaticInstanct("chapter17.node01.Person"));
        System.out.println(getStaticInstanct("chapter11.comparepack.Person"));

        System.out.println("*****************************************");

        Object obj = ReflectionDynamic.getDynamicInstanct("chapter17.node01.Person");
        System.out.println(obj);

        obj = ReflectionDynamic.getDynamicInstanct("chapter11.comparepack.Person");
        System.out.println(obj);

        System.out.println("举例二的验证：根据输入动态地生成实例，并调用动态方法，返回动态结果，生成的实例是动态变化的");
        dynamicInvokeTest();
    }

    /* 静态型，很明确地知道方法返回类型是什么,
     * 即返回类型是固定的，与具体入参的输入无关
     */
    public static Person getStaticInstanct(String className){
        System.out.println("static " + className);
        return new Person();
    }

    /* 动态型，在确认输入前，并不知道方法返回类型是什么,
     * 即返回类型是动态变化，
     * 受具体入参的输入影响的，需视具体的逻辑确定返回类型是什么
     */
    public static <T> T getDynamicInstanct(String className) throws Exception{
        // System.out.println("dynamic the " + className);
        Class<?> clazz = Class.forName(className);

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (T) constructor.newInstance();
    }

    /* 反射的动态性举例之二：
     * 根据输入动态地创建指定地对象，并执行指定地方法
     * 这些输入可能是来自配置文件地读取，也可能是来自客户端地请求来按需、动态地创建实时对象；
     * 避免 实现创建所有类的对象，再按需查询获取相应对象实例的低效且可能造成内存泄漏的 硬编码
     */
    public static Object dynamicInvoke(String className, String methodName) throws Exception{
        Class<?> clazz = Class.forName(className);

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 构建动态对象
        Object obj = constructor.newInstance();

        // 获取并调用运行时类指定的方法, 本示例为简单起见，假设调用的是无入参的方法，有入参的可适当扩展
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(obj);
    }

    public static void dynamicInvokeTest() throws Exception{
        // 实际使用中：
        // className、methodName可能是来自配置文件地读取，也可能是来自客户端地请求来按需、动态地创建实时对象
        // 本例省去这些获取和判断的逻辑，
        // 详见 B站 尚硅谷宋红康 Java 从入门到精通 2023 Java 17的P192中约第20分钟到29分钟之间的讲解
        String className = "chapter17.node01.Person"; 
        String methodName = "show";

        Object result = dynamicInvoke(className, methodName);
        System.out.println(result);

    }
}
