package chapter07;

public class ClassCastTest{
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);
        s.display();
        s.add(1, 2, 3);
        Base b = s;
        System.out.println(b == s);
        System.out.println(b.count);
        b.display();
        b.add(1, 2, 3);
    }
}

class Base{
    int count = 10;

    public void display(){
        System.out.println(this.count);
    }

    public void add(int a, int... arr){
        System.out.println("base");
    }
}

class Sub extends Base{
    int count = 20;

    public void display(){
        System.out.println(this.count);
    }

    // public void add(int a, int[] arr){
    //         System.out.println("base");
    //     }

    public void add(int a, int b, int c){
        System.out.println("sub");
    }
}