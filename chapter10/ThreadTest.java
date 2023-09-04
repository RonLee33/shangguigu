package chapter10;

public class ThreadTest {
    public static void main(String[] args) {
        PrintEvenIn100 t0 = new PrintEvenIn100();
        t0.start();

        PrintOddIn100 t1 = new PrintOddIn100();
        t1.start();

        // Thread的匿名子类的匿名对象方式，在之前的Android开发时和GUI等有关时常用的方式
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    System.out.println("匿名子类的匿名对象: " + i);
                }
            }
        }.start();

    }
}

class PrintEvenIn100 extends Thread {
    // 线程示例，打印100以内的偶数
    @Override
    public void run(){
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

}

class PrintOddIn100 extends Thread{
    // 遍历100以内的基数
    @Override
    public void run(){
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
