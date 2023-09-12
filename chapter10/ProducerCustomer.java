package chapter10;

/**
 * 生产者-消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，
 * 而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品。
*/

public class ProducerCustomer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);

        productor.setName("生产者");
        customer.setName("消费者");

        productor.start();
        customer.start();
    }
}

class Clerk{
    private int productNum = 0;
    
    public synchronized void addProduct(){

        if (productNum <= 20) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            productNum++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + productNum + "个产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        
    }

    public synchronized void subProduct(){

        if (productNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "消费了第" + productNum + "个产品");
            productNum--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();

    }
}

class Productor extends Thread{
    private Clerk clerk;

    Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run(){
        while (true) {
            clerk.addProduct();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;

    Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run(){
        while (true) {
            clerk.subProduct();
        }
    }
}
