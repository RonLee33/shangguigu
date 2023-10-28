package chapter12.node06;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("Litan", 26);
        map.put("ZhangSan", 22);
        map.put("LiSi", 25);
        map.put("WangWu", 19);

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "的年龄为：" + entry.getValue() + " 岁");
        }
    }
}
