package chapter12.node06;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Litan", 26);
        map.put("ZhangSan", 22);
        map.put("LiSi", 25);
        map.put("WangWu", 19);

        System.out.println("Map成员：" + map);

        map.remove("WangWu");
        System.out.println("Map成员详情：" + map);

        System.out.println("Litan的年龄：" + map.get("Litan"));

        System.out.println("是否存在LiSi：" + map.containsKey("LiSi"));
        System.out.println("是否存在年龄为22的成员：" + map.containsValue(22));
        System.out.println("Map成员个数：" + map.size());
        System.out.println("Map是否为空：" + map.isEmpty());

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.putAll(map);
        map2.put("WangWu", 19);
        System.out.println("map2与map是否相等：" + map.equals(map2));

        Set<String> keySet = map.keySet(); // 键是唯一的、不重复的，所以类型是Set
        System.out.println("Map成员姓名如下：");
        for (String key : keySet) {
            System.out.println(key);
        }

        Collection<Integer> valueSet = map.values(); // 值可重复，所以类型是Collection
        System.out.println("Map成员年龄如下：");
        for (int age : valueSet) {
            System.out.println(age);
        }

        System.out.println("Map成员详情遍历：");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "的年龄是：" + 
            entry.getValue() + "岁");

        }
    }
}
