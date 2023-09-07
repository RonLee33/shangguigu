package chapter10;

/**
 * 同步代码块的使用（以售票为例,以Runnable的this作为“锁”），解决线程安全问题
*/
public class SyncBlockThis {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket, "窗口 1 ");
        Thread t2 = new Thread(ticket, "窗口 2 ");
        Thread t3 = new Thread(ticket, "窗口 3 ");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable{
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            synchronized (this) {//this必须唯一
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
