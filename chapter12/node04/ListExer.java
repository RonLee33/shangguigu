package chapter12.node04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ListExer {
    public static void main(String[] args) {
        registerInfo();
        statisticsChar();
    }

    private static void registerInfo(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();
        Student student;
        String name;
        int age;
        System.out.print("选择（1、录入； 0、退出）");
        int code = scanner.nextInt();
        while (code == 1) {
            System.out.print("姓名：");
            name = scanner.next();

            System.out.print("年龄：");
            age = scanner.nextInt();

            student = new Student(name, age);
            list.add(student);

            System.out.print("选择（1、录入； 0、退出）");
            code = scanner.nextInt();

        }
        scanner.close();

        if (code == 0){
            System.out.println("已退出");
        }

        for (Student student2 : list) {
            System.out.println(student2);
        }
    }

    public static int listTest(Collection<String> list,String s){
        int count = 0;
        for (String string : list) {
            if (s.equals(string)) {
                count += 1;
            }
        }
        return count;
    }

    private static void statisticsChar(){
        Collection<String> collection = new ArrayList<String>();
        char c;
        int offset;
        for (int i = 0; i < 30; i++) {
            offset = (int)(Math.random() * 26);
            c = (char) ('a' + offset);
            collection.add(String.valueOf(c));
        }
        System.out.println(collection);

        String[] targets = {"a", "b", "c", "x"};
        for (String target : targets) {
            System.out.println(target + " 出现的次数为：" + listTest(collection, target));
        }
    }

    
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    
}
