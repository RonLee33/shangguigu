package chapter10;

/**
 * 同步代码块的使用（以售票为例,以Thread的Class的示例做“锁”），解决线程安全问题
*/

public class SyncBlockClass {
    public static void main(String[] args) {
        Window w1 = new Window("窗口 A ");
        Window w2 = new Window("窗口 B ");
        Window w3 = new Window("窗口 C ");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    static int ticket = 100;

    public Window(String name){
        super(name);
    }

    @Override
    public void run(){
        while (true) {

            try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            synchronized (Window.class) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            
        }
    }
}
