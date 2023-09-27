package chapter11.comparepack;

import java.util.Arrays;
import java.util.Comparator;

public class CompareableDemo{
    public static void main(String[] args) {
        String[] names = {"A", "C", "F", "T", "B", "G", "D", "E"};
        
        // 因为String实现了Compareable,所以才能sort()
        Arrays.sort(names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        Person[] persons = {
            new Person("James Smith", 20),
            new Person("Emily Johnson", 26),
            new Person("William Brown", 19),
            new Person("Olivia Taylor", 48),
            new Person("Thomas Davis", 35),
            new Person("Ava Wilson", 51),
            new Person("George Jones", 24),
            new Person("Isabella Clark", 27),
            new Person("Henry Thompson", 15),
            new Person("Sophia Evans", 31)
        };

        Arrays.sort(persons);

        for (Person person : persons) {
            // 按年龄升序排序输出
            System.out.println(person);
        }

        System.out.println("以下按姓名升序排序：");

        Arrays.sort(persons, new Comparator<Object>() {
            // Comparator， 定制排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    // 按姓名升序排序
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;

                    int result = p1.getName().compareTo(p2.getName());
                    return result;
                }

                throw new RuntimeException("入参之一 不是Person的子类，无法比较");
            }
        });

        for (Person person : persons) {
            // 按姓名升序排序输出,即 Comparator会覆盖掉 Person从Comparable中重写的compareTo方法中的比较准则
            System.out.println(person);
        }
    }
}
