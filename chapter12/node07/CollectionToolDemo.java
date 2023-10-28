package chapter12.node07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CollectionToolDemo {
    public static void main(String[] args) {
        // 生成测试用的List
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        
        // 1.排序操作
        Collections.reverse(list);
        System.out.println("执行reverse(List)反序后: " + list);

        Collections.shuffle(list);
        System.out.println("执行shuffle(list)乱序后: " + list);

        Collections.sort(list);
        System.out.println("执行sort(list)升序排序后: " + list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            } 
        });
        System.out.println("执行sort(list, Comparator)降序排序后: " + list);

        Collections.swap(list, 1, 3);
        System.out.println("执行swap(list, 1, 3)后: " + list);

        // 2.查找 
        System.out.println("max(list)得到最大值：" + Collections.max(list)); // min()类似，略去举例
        
        // 二分查找
        Collections.sort(list);
        System.out.println("binarySearch(list, 5): " + Collections.binarySearch(list, 5));

        // 查找指定元素在集合中出现的次数
        int j;
        for (int i = 0; i < 10; i++){
            j = (int) (Math.random() * 10);
            list.add(j);
        }
        System.out.println("list: " + list);

        System.out.println("查找指定元素在集合中出现的次数: ");
        HashSet<Integer> set = new HashSet<>(list);
        for (Integer integer : set) {
            System.out.println(integer + "出现 " + Collections.frequency(list, integer) + "次");
        }

        // 3.复制替换
        ArrayList<Integer> destList = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            destList.add(i);
        }

        // 目的集合的size必须 >= 源集合的size,注意：是size，不是initialCapacity
        // 否则会报 java.lang.IndexOutOfBoundsException 的异常
        Collections.copy(destList, list); 
        System.out.println("list=" + list);
        System.out.println("destList=" + destList);

        Collections.replaceAll(list, 4, 999);
        System.out.println("把list中所有的4替换为999后" + list);

        /* 使list变为只读集合（无法修改的集合），
        可放防止数据被修改， 同时为只读操作提供了更好的性能*/

        List<Integer> onlyReadList = 
            Collections.unmodifiableList(list);
        
        // 以下操作会报 java.lang.UnsupportedOperationException 异常，只读集合不能进行写操作
        try {
            onlyReadList.add(1);
        } catch (UnsupportedOperationException e) {
            System.out.println("unmodifiableList()生成的只读集合，不允许写操作");
        }
        
        // 将指定的元素加入到list中
        Collections.addAll(list, 333, 334, 335, 336, 337, 338, 339, 340);
        System.out.println("Collections.addAll()后，list=" + list);

    }
}
