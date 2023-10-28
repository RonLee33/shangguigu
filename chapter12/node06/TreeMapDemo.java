package chapter12.node06;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import chapter12.node05.User;

public class TreeMapDemo {
    // key-value的关系 {User: Grade}
    public static void main(String[] args) {
        TreeMap<User, Integer> treeMap = new TreeMap<User, Integer>();
        treeMap.put(new User("Tom",12), 67);
        treeMap.put(new User("Rose",23), 74);
        treeMap.put(new User("Jerry",2), 80);
        treeMap.put(new User("Eric",18), 90);
        treeMap.put(new User("Tommy",44), 55);
        treeMap.put(new User("Jim",23), 43);
        treeMap.put(new User("Maria",18), 95);
        treeMap.put(new User("Jack",23), 86);

        // Comparable 自然排序: 按照age从小到大的顺序排列,如果age相同，则按照name从大到小的顺序排列 
        User user;
        System.out.println("User的字典排序: 按照age从小到大的顺序排列,如果age相同，则按照name从大到小的顺序排列:");
        for (Map.Entry<User, Integer> userEntry : treeMap.entrySet()) {
            user = userEntry.getKey();
            System.out.println(user.getName() + "的年龄为：" + user.getAge() 
            + ", 成绩为：" + userEntry.getValue());   
        }

        // Comparator 定制排序 :按照User的姓名的从小到大的顺序排列
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //按照User的姓名的从小到大的顺序排列
                return o1.getName().compareTo(o2.getName());
            } 
        };

        TreeMap<User, Integer> treeMap2 = new TreeMap<User, Integer>(comparator);
        treeMap2.putAll(treeMap);
        System.out.println("定制排序 :按照User的姓名的从小到大的顺序排列:");
        for (Map.Entry<User, Integer> userEntry : treeMap2.entrySet()) {
            user = userEntry.getKey();
            System.out.println(user.getName() + "的年龄为：" + user.getAge() 
            + ", 成绩为：" + userEntry.getValue());   
        }

    }
}
