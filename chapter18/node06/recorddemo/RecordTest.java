package chapter18.node06.recorddemo;

import java.util.HashSet;

public class RecordTest {
    public static void main(String[] args) {
        defineByClass();
        System.out.println("******************************************************");
        defineByRecord();

    }

    static void defineByClass(){
        Order order1 = new Order(1001, "OrderAA");

        // 测试toString()
        System.out.println(order1);

        // 测试getter
        System.out.println(order1.orderId());
        System.out.println(order1.orderName());

        Order order2 = new Order(1001, "OrderAA");
        // 测试equals()
        System.out.println(order1.equals(order2));

        // 测试hasdCode() 和 equals()
        System.out.println("*******测试Class定义的：hasdCode() 和 equals()********");
        HashSet<Order> set = new HashSet<>();
        set.add(order1);
        set.add(order2);
        set.forEach(System.out::println);
    }

    static void defineByRecord(){
        OrderRecord order1 = new OrderRecord(1001, "OrderAA");

        // 测试toString()
        System.out.println(order1);

        // 测试getter
        System.out.println(order1.orderId());
        System.out.println(order1.orderName());

        OrderRecord order2 = new OrderRecord(1001, "OrderAA");
        // 测试equals()
        System.out.println(order1.equals(order2));

        // 测试hasdCode() 和 equals()
        System.out.println("*******测试Record定义的：hasdCode() 和 equals()********");
        HashSet<OrderRecord> set = new HashSet<>();
        set.add(order1);
        set.add(order2);
        set.forEach(System.out::println);
    }
}
