package project03.domain;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee>{
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

    @Override
    public int compareTo(Employee o) {
        return age - o.getAge();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
            return false;
        return true;
    }
    
    
    
}
