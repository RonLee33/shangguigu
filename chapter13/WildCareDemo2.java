package chapter13;

public class WildCareDemo2 {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<Integer>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        print(intStack);
        
    }

    public static void print(GenericStack<?> stack){
        while (!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
