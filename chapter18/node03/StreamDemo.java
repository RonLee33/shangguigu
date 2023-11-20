package chapter18.node03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import project03.domain.Employee;

public class StreamDemo {
    
    public static void main(String[] args) {
        
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
}
