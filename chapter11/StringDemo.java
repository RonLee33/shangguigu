package chapter11;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = (s1 + s2).intern();

        System.out.println(s3 == s1); // false
        System.out.println(s3 == s4); // true 实际 false
        System.out.println(s3 == s5); // true 实际 false
        System.out.println(s4 == s5); // true 实际 false
        System.out.println(s3 == s6); // true
    }
}
