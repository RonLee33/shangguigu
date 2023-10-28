package chapter12.node05;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/** TreeSet
 * 定制排序：按照age从小到大的顺序排列，如果age相同，则按照name从大到小的顺序排列
 * */
public class CustomSortingDemo {
    public static void main(String[] args) {
        HashSet<User> set = new HashSet<User>();

        set.add(new User("Tom",12));
        set.add(new User("Rose",23));
        set.add(new User("Jerry",2));
        set.add(new User("Eric",18));
        set.add(new User("Tommy",44));
        set.add(new User("Jim",23));
        set.add(new User("Maria",18));
        set.add(new User("Jack",23));

        Iterator<User> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(set.contains(new User(8, "Jack", 23))); //true

        System.out.println("set中的元素排序(按照age从小到大的顺序排列，如果age相同，则按照name从大到小的顺序排列)后：");
        TreeSet<User> treeSet = new TreeSet<User>(set);
        Iterator<User> iterator1 = treeSet.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        // Comparator匿名类实例comparator，定制覆盖User compareTo()中原有的排序规则
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2){
                // 按照User的姓名的从小到大的顺序排列
                return u1.getName().compareTo(u2.getName());
            }
        };

        System.out.println("按照User的姓名的从小到大的顺序排列:");
        TreeSet<User> treeSet1 = new TreeSet<User>(comparator);
        treeSet1.addAll(set);
        Iterator<User> iterator2 = treeSet1.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
