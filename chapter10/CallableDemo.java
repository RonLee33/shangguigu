package chapter10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        NumCallable numCallable = new NumCallable();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(numCallable);
        new Thread(futureTask).start();

        try {
            int sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class NumCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception{
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
