package chapter12.node05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*TreeSet常用方法*/
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        TreeSet<String> treeSet = new TreeSet<String>(set);
        System.out.println("Sorted tree set: " + treeSet);

        // 使用继承自SortedSet接口中的方法
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        // “排序”小于New York的部分
        System.out.println("headSet(): " + treeSet.headSet("New York")); 
        // “排序”大于等于New York的部分
        System.out.println("tailSet(): " + treeSet.tailSet("New York"));


        // 使用继承自NavigableSet接口中的方法
        System.out.println("lower(\"P\"): " + treeSet.lower("P")); // treeSet小于"P"中的最大元素
        System.out.println("higher(\"P\"): " + treeSet.higher("P")); // treeSet大于"P"中的最小元素

        System.out.println("floor(\"P\"): " + treeSet.floor("P")); // treeSet小于或等于"P"中的最大元素
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P")); // treeSet大于或等于"P"中的最小元素

        System.out.println("pollFirst(): " + treeSet.pollFirst()); // 返回并删除treeSet中的第一个元素
        System.out.println("pollLast(): " + treeSet.pollLast()); // 返回并删除treeSet中的最后一个元素

        System.out.println("New tree Set: " + treeSet);

        // TreeSet的迭代遍历,迭代器方式
        Iterator<String> iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // TreeSet的迭代遍历,foreach方式
        for (String string : treeSet) {
            System.out.println(string);
        }

    }
}
