package chapter17.node06.exer;

public class Orange implements Fruit{
    public Orange(){
        System.out.println("拿到桔子，已放入榨汁机中");
    }

    @Override
    public void squeeze() {
        System.out.println("正在榨桔子汁...");
        
    }
}
