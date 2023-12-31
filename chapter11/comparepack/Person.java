package chapter11.comparepack;

public class Person implements Comparable<Object>{
    // Comparable 自然排序
    private String name;
    private int age;

    private Person(){
        System.out.println("第11章中的chapter11.comparepack.Person()实例化中...");
    }

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
