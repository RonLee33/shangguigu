package chapter17.node05;

@Table(value = "t_customer")
public class Customer {
    private String name;
    public int age;

    public Customer(){
        System.out.println("Customer()...");
    }

    public Customer(int age){
        this.age = age;
    }

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
