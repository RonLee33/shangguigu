package chapter17.node01;

public class Person extends Creature<Person> implements Comparable<Person>{
    private String name;
    public int age = 1;
    private static boolean isGood = true;

    public Person(){
        System.out.println("Person()...");
    }

    public Person(int age) {
        this.age = age;
    }

    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void show() throws RuntimeException{
        System.out.println("你好，我是一个Person()");
    }

    @MyAnnotation(value="show_nation")
    private String showNation(String nation){
        return "我的国籍是：" + nation;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    

}
