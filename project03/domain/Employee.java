package project03.domain;

import java.io.Serializable;

public class Employee implements Serializable{
    static final long serialVersionUID = 27182834234L;
    private int id;
    private String name;
    private int age;
    private double salary;//transient ,加此关键字的属性不会被序列化，在反序列化时，读出的是对应数据类型的默认值，如int型是零
 
    public Employee() {
        System.out.println("Employee()...");
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id){
        this.id = id;
    }

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeInfo(){
        String info = String.format("%d\t%s\t%d\t%.1f", id, name, age, salary);
        return info;
    }

    @Override
    public String toString() {
        return getEmployeeInfo();
    }
    
    
}
