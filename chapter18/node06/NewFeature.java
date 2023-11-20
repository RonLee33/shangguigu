package chapter18.node06;

public class NewFeature {
    public static void main(String[] args) {
        instanceofDemo();
    }

    public static void instanceofDemo(){
        // JDK14新特性：instanceof的模式匹配
        
        Object obj = new String("Hello, Java 14");
        System.out.println("******************JDK14 之前***********************");
        // JDK 14之前
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.contains("Java"));
        } else {
            System.out.println("非String类型");
        }
        System.out.println("******************JDK14 之后***********************");
        // JDK14 之后
        if (obj instanceof String s1){
            System.out.println(s1.contains("Java"));
        } else {
            System.out.println("非String类型");
        }
    }
}
