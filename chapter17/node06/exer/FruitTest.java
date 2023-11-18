package chapter17.node06.exer;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class FruitTest {
    // config.properties
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(
            new File("D:\\CodeProject\\Java\\shangguigu\\chapter17\\node06\\exer\\config.properties")
        );
        
        // 读配置文件
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String fruit = properties.getProperty("fruitName");

        // 根据配置文件生成水果
        Class<?> clazz = Class.forName("chapter17.node06.exer." + fruit);
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Fruit aFruit = (Fruit) constructor.newInstance();

        // 榨汁
        Juicer juicer = new Juicer();
        juicer.run(aFruit);
    }
}
