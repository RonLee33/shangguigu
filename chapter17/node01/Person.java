package chapter17.node01;

public class Person extends Creature<String> implements Comparable<Person>, MyInterface<Person>{
    private String name;
    public int age = 1;
    private static String description = "nothing";

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
    private String showNation(String nation, int age){
        return "我的国籍是：" + nation + "，年龄是：" + age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    @Override
    public boolean areYouAdult(Person t) {
        return t.age >= 18;
    }

        

}
