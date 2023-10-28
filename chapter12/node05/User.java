package chapter12.node05;

public class User implements Comparable<User>{
    private int id;
    private String name;
    private int age;
    private static int clsFlagId = 1;

    public User(String name, int age){
        this.name = name;
        this.age = age;
        id = clsFlagId++;
    }

    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User){
            User user = (User) o;
            return user.getId() == id? true: false;
        }
        throw new RuntimeException("实参类型不是User,无法比较");
    }

    @Override
    public int compareTo(User o) {
        /**排序规则:
         * 按照age从小到大的顺序排列，
         * 如果age相同，则按照name从大到小的顺序排列*/
        int result = age - o.getAge();
        return result == 0? -name.compareTo(o.getName()): result;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
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

    public int getId() {
        return id;
    }
    
}
