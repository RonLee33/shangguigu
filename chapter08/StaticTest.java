package chapter08;

public class StaticTest {
    public static void main(String[] args) {
        // Demo demo = null;
        Demo.hello();// 空示例也能调用静态方法
    }
}

class Demo{
    public static void hello(){
        System.out.println("hello!");
    }
}
