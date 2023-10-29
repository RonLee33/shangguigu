package chapter13;

public class GenericDemoTest {
    public static void main(String[] args) {
        GenericStack<String> strStack = new GenericStack<String>();
        strStack.push("London");
        strStack.push("Paris");
        strStack.push("Berlin");
        System.out.println(strStack);
    }
}
