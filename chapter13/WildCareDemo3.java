package chapter13;

public class WildCareDemo3 {
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<String>();
        GenericStack<Object> stack2 = new GenericStack<Object>();

        stack1.push("stack1 of Java");
        stack2.push(2);
        stack2.push("Sun");

        System.out.println(stack2);
        // WildCareDemo3.<String>add(stack1, stack2);
        WildCareDemo3.<Object>add(stack1, stack2);
        System.out.println(stack2);

    }

    // public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2){
    public static <T> void add(GenericStack<? extends T> stack1, GenericStack<T> stack2){
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
