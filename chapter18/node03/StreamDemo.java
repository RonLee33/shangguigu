package chapter18.node03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import project03.domain.Employee;

public class StreamDemo {
    static List<Employee> list = EmployeeData.getEmployees();
    
    public static void main(String[] args) {
        // matchLook();
        // aggregateQuerry();
        // statute();
        // collectResult();
        filterMap();
    }

    public static void newStream(){
        /* 创建Stream的三种方式 */

        // 方式一（集合的Stream）：stream()/parallelStream()
        List<Employee> list = EmployeeData.getEmployees();
        // default Stream<E> stream()：返回一个顺序流
        Stream<Employee> stream = list.stream();
        // default Stream<E> parallelStream()：返回一个并行流
        Stream<Employee> parallelStream = list.parallelStream();

        // 方式二（数组的Stream）：public static <T> Stream<T> stream(T[] array)
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        Stream<Integer> stream2 = Arrays.stream(arr);

        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        IntStream stream3 = Arrays.stream(arr1);

        // 方式三（非集合/数组的Stream）：通过Stream的of()方法
        Stream<String> stream4 = Stream.of("AA", "BB", "CC");

    }

    public static void filterMap(){
        // 筛选
        // 查找年龄大于34岁的所有员工
        list.stream().filter(employee -> employee.getAge() > 34).forEach(System.out::println);

        System.out.println("---------------------");
        // 映射
        // 打印所有的员工的年龄
        list.stream().map(Employee::getAge).forEach(System.out::println);
        
    }

    public static void matchLook(){
        // StreamApi的终止操作

        // 1-匹配与查找,逻辑上类似于MySQL的select
        // allMatch(Predicate p)--检查是否匹配所有元素
        // 所有员工是否都已成年
        System.out.println(list.stream().allMatch(emp -> emp.getAge() >= 18));

        // anyMatch(Predicate p)--至少有一个元素满足条件
        // 是否有员工月薪一万
        System.out.println(list.stream().anyMatch(emp -> emp.getSalary() >= 10000));

        // findFirst()--返回第一个元素
        System.out.println(list.stream().findFirst().get());
    }

    public static void aggregateQuerry(){
        // StreamApi的终止操作
        // 2-聚合操作，逻辑上类似于MySQL中group by 后的聚合函数

        // count()--返回流中元素总个数
        System.out.println(list.stream().count());

        // max(Comparator c) -- 返回流中最大值
        // 返回最高的工资
        // 思路一：找到工资最高的员工，再取其工资
        System.out.print("思路一：");
        System.out.println(list.stream().max((emp1, emp2) -> (int)(emp1.getSalary()-emp2.getSalary())).get().getSalary());
        // 思路二：先取出所有员工的工资（即映射，map()）,再取最高工资
        System.out.print("思路二：");
        System.out.println(list.stream().map(Employee::getSalary).max(Double::compare).get());

        // min(Comparator c) -- 返回流中最小值
        // 返回工资最低的员工,此处也可用和求最大值是用map()的思路
        System.out.println(list.stream().min((emp1, emp2) -> (int)(emp1.getSalary() - emp2.getSalary())).get());

        // forEach(Comsumer c) --内部迭代
        list.stream().forEach(System.out::println);
        System.out.println("list.forEach(): ");
        // 从JDK8起：集合自身也实现了forEach()方法，入参同上，因此有
        list.forEach(System.out::println);
    }

    public static void statute(){
        // StreamApi的终止操作
        // 3-归约

        // reduce(T identity, BinaryOperator bo) --有初始值identity的reduce(), 逻辑类似于Python中的reduce()
        // 求 1-10的整数之和
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // System.out.println(list1.stream().reduce(0, (i1, i2) -> i1 + i2));
        // System.out.println(list1.stream().reduce(0, (i1, i2) -> Integer.sum(i1, i2)));
        System.out.println(list1.stream().reduce(0, Integer::sum));

        // reduce(BinaryOperator bo) --无初始值identity的reduce()
        // 计算公司所有员工工资总和
        System.out.println(list.stream().map(Employee::getSalary).reduce(Double::sum).get());
    }

    public static void collectResult(){
        // 收集
        // StreamApi的操作并不会改变源数据，因此可使用collect(Collector c)将StreamApi操作结果保留到 c 中

        // 查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> resultList = list.stream().filter(emp -> emp.getSalary() > 6000).collect(Collectors.toList());
        resultList.forEach(System.out::println);
        System.out.println("-------------------");

        // 将员工按年龄排序，结果返回到一个新的List中
        List<Employee> resultList2 = list.stream().sorted().collect(Collectors.toList());
        resultList2.forEach(System.out::println);
    }
}
