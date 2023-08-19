package chapter08;

/**
 * 测试加载顺序练习 3
 * 静态代码块的之间的执行顺序以其书写的先后顺序来执行，即：
 * 写在前面的静态变量、代码块先赋值、执行；写在后面的静态变量、代码块后赋值、执行
*/

public class Test04 {
    public static void main(String[] args) {
        new Zi();
    }

    public int addOne(final int x){
        //非法 因为final 修饰的变量一经赋值，就不能再修改其值，此方法被调用时，x引用实参的过程就相当于赋值了
        // return ++x; 
        return x + 1;
    }
}

class Fu{

    public static void print(String str){
        System.out.println(str + "->" + i);
    }

    public static int getNum(String str){
        print(str);
        return ++i;
    }

    private static int i = getNum("(1) i");
    // private int j = getNum("(2) j");

    static {
        print("(3) 父类静态代码块");
    }

    {
        print("(4) 父类非静态代码块，又称构造代码块");
    }

    Fu(){
        print("(5) 父类构造器");
    }
}

class Zi extends Fu{
    public static void print(String str){
        System.out.println(str + "->" + k);
    }
    public static int getNum(String str){
        print(str);
        return ++k;
    }

    private static int k = getNum("(6) k");
    // private int h = getNum("(7) h");

    static {
        print("(8) 子类静态代码块");
    }

    {
        print("(9) 子类非静态代码块，又称构造代码块");
    }

    Zi(){
        print("(10) 子类构造器");
    }
}
