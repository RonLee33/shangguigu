package chapter17.node06.exer;

public class Banana implements Fruit{
    public Banana(){
        System.out.println("拿到香蕉，已放入榨汁机中");
    }

    @Override
    public void squeeze() {
        System.out.println("正在榨香蕉汁...");
        
    }
}
