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

class User implements Comparable<User>{
    private int id;
    private String name;
    private int age;
    private static int clsFlagId = 1;

    public User(String name, int age){
        this.name = name;
        this.age = age;
        id = clsFlagId++;
    }

    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User){
            User user = (User) o;
            return user.getId() == id? true: false;
        }
        throw new RuntimeException("实参类型不是User,无法比较");
    }

    @Override
    public int compareTo(User o) {
        /**排序规则:
         * 按照age从小到大的顺序排列，
         * 如果age相同，则按照name从大到小的顺序排列*/
        int result = age - o.getAge();
        return result == 0? -name.compareTo(o.getName()): result;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
    
}