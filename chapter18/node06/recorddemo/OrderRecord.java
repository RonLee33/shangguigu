package chapter18.node06.recorddemo;

// 此类的内部结构完全等价于Order类的实现，可能hashCode()和equals()的实现会略有不同
// record不能有显示额父类，即，不能写成public record OrderRecord(int orderId, String orderName) extends Object
// 因为record已隐式地声明extends Record
public record OrderRecord(int orderId, String orderName) {
    // 还可以在record声明的类中定义静态字段、静态方法、构造器或实例方法
    static String info = "record Order";

    // 不能在record声明的类中定义实例字段；类不能声明为abstract；不能声明显式的父类等。
    public static void show(){
        System.out.println("订单");
    }

    public OrderRecord(){
        this(0, "盘古");
    }

    public void price(){
        System.out.println("价格");
    }
}
