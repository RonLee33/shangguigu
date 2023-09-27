package chapter11.comparepack;

public class Person implements Comparable<Object>{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    

    @Override
    public int compareTo(Object o) {
        // 按年龄升序排序
        if (o instanceof Person){
            Person other = (Person) o;
            return Integer.compare(age, other.getAge());
        }

        throw new RuntimeException("o 不是Person的子类，无法比较");
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
        return "Person [name=" + name + ", age=" + age + "]";
    }

}
