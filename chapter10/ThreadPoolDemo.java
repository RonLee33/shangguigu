package chapter10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池的简单了解
*/

public class ThreadPoolDemo {
    public static void main(String[] args) {
        
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // 设置线程池中线程数的上限
        service1.setMaximumPoolSize(50);

        service.execute(new Runnable() {
            @Override
            public void run(){
                for (int i = 0; i <= 100; i += 2) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        });

        try {
            Future<Integer> future = service.submit(new NumCallable());
            System.out.println("总和为：" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
