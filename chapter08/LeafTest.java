package chapter08;

/**
 * 分析加载顺序练习 1
 * 先将静态代码中的所有块从根父类起依次加载，
 * 将继承树中的所有静态执行完后，就一个父类一个父类的执行非静态代码块
*/
public class LeafTest {
    public static void main(String[] args) {
        new Leaf();
    }
}

class Root{
    static {
        System.out.println("Root的静态初始化块");
    }

    {
        System.out.println("Root的普通初始化块");
    }

    public Root(){
        System.out.println("Root的无参构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid的静态初始化块");
    }

    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid(){
        System.out.println("Mid的无参构造器");
    }

    public Mid(String msg){
        this();
        System.out.println("Mid的带参数构造器，其参数值：" + msg);
    }
}


class Leaf extends Mid{
    static {
        System.out.println("Leaf 的静态初始化块");
    }

    {
        System.out.println("Leaf 的普通初始化块");
    }

    public Leaf(){
        super("尚硅谷");
        System.out.println("Leaf 的无参构造器");
    }
}