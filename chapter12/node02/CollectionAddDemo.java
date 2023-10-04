package chapter12.node02;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionAddDemo {
    public static void main(String[] args) {
        addDemo();
        addAllDemo();
    }

    private static void addDemo(){
        Collection<String> collection = new ArrayList<String>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        System.out.println(collection);
    }

    private static void addAllDemo(){
        /**add() 与 addAll()的区别*/
        Collection<Object> c1 = new ArrayList<Object>();
        c1.add("A1");
        c1.add("B1");
        c1.add("C1");

        Collection<Object> c2 = new ArrayList<Object>();
        c2.add("A2");
        c2.add("B2");
        c2.add("C2");

        Collection<Object> c3 = new ArrayList<Object>();
        c3.add("A2");
        c3.add("B2");
        c3.add("C2");

        c1.add(c2);
        System.out.println("c1.add(c2)后：" + c1); // [A1, B1, C1, [A2, B2, C2]]
        System.out.println("c1.add(c2)后c1的长度：" + c1.size()); // 4

        c3.addAll(c2);
        System.out.println("c3.add(c2)后：" + c3); // [A2, B2, C2, A2, B2, C2]
        System.out.println("c3.add(c2)后c3的长度：" + c3.size()); // 6
        
    }
}
