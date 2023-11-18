package chapter17.node06.exer;

public class Apple implements Fruit{

    public Apple(){
        System.out.println("拿到苹果，已放入榨汁机中");
    }

    @Override
    public void squeeze() {
        System.out.println("正在榨苹果汁...");
        
    }
}
