package chapter11.comparepack;

import java.util.Arrays;

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
    }
}
