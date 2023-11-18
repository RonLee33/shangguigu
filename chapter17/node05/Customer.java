package chapter17.node05;


/** 用于定义与数据库“映射”的类，
 * 通过Customer类来操作 数据库中的 t_customer表
 */
@Table(value = "t_customer")
public class Customer {
    
    @Column(columnName = "cust_name", columnType = "varchar(15)")
    private String name;

    @Column(columnName = "cust_age", columnType = "int ")
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
