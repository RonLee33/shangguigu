package chapter15.node05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import chapter15.node03.FileReaderWriterDemo;

/** 姓氏统计：
 * 一个文本文件中存储着北京所有高校在校生的姓名，格式如下：
 * 每行一个名字，姓与名以空格分隔：
 * 张 三
 * 李 四
 * 王 小五
 * 现在想统计所有的姓氏在文件中出现的次数。
*/

public class SurnameStatistics {
    public static void main(String[] args) {
        String fileName = FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\student_info.txt";
        surnameCount(fileName);
    }

    public static void surnameCount(String fileName){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
               new InputStreamReader(new FileInputStream(new File(fileName)), "UTF-8"));
            
            char surname;
            String line;
            int count;
            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                surname = line.charAt(0);
                if (map.containsKey(surname)){
                    count = map.get(surname);
                    map.put(surname, count + 1);
                } else {
                    map.put(surname, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " 出现的次数为：" + entry.getValue());
        }
    }
}
