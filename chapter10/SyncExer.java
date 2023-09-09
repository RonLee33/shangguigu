package chapter10;

/**
 * 同步代码块练习，两个储户向同一个账号存钱，存满3000即可，每人每次存30元
*/

public class SyncExer {
    public static void main(String[] args) {
        Account account = new Account();

        Thread user1 = new Thread("储户 A"){
            @Override
            public void run(){
                while (account.getAmount() < 3000) {
                    synchronized (account) {
                        account.deposit(30);
                    }   
                }
            }
        };

        Thread user2 = new Thread("储户 B"){
            @Override
            public void run(){
                while (account.getAmount() < 3000) {
                    synchronized (account) {
                        account.deposit(30);
                    }   
                }
            }
        };

        user1.start();
        user2.start();
    }
    
}

class Account{
    private int amount = 0;

    public void deposit(int amount){
        if (this.amount < 3000) {
            this.amount = this.amount + amount;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存款30");
            System.out.println("当前账户余额为：" + this.amount);
        } 
    }

    public int getAmount(){
        return amount;
    }
}
