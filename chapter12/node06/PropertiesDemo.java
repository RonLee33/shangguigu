package chapter12.node06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File file = new File("info.properties");
        System.out.println(file.getAbsolutePath()); // 打印文件所在路径

        FileInputStream fis = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fis);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name: " + name);
        System.out.println("password: " + password);
    }
}
