package chapter15.node07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import chapter15.node03.FileReaderWriterDemo;
import project03.domain.Employee;

public class ObjStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        // 读写基本数据类型的顺序要一致，基本数据以什么顺序写入的，就得以什么顺序读出
        // writeDataFunc();
        readDataFunc();

        // writeAObjFunc();
        readAObjFunc();

        // writeObjsFunc();
        readObjsFunc();
    }

    public static void writeDataFunc() throws IOException{
        String name = "巫师";
        int age = 300;
        char gender = '男';
        int energy = 5000;
        double price = 75.5;
        boolean relive = true;

        DataOutputStream oos = new DataOutputStream(
            new FileOutputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\data_read_write_demo.dat")
        );

        oos.writeUTF(name);
        oos.writeInt(age);
        oos.writeChar(gender);
        oos.writeInt(energy);
        oos.writeDouble(price);
        oos.writeBoolean(relive);

        oos.close();
    }

    public static void readDataFunc() throws IOException{
        DataInputStream ois = new DataInputStream(
            new FileInputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\data_read_write_demo.dat")
        );

        System.out.println("姓名：" + ois.readUTF());
        System.out.println("年龄：" + ois.readInt());
        System.out.println("性别：" + ois.readChar());
        System.out.println("生命值：" + ois.readInt());
        System.out.println("价格：" + ois.readDouble());
        System.out.println("是否能复活：" + ois.readBoolean());

        ois.close();
    }

    public static void writeAObjFunc() throws IOException{
        // 写入一个对象
        Employee employee1 = new Employee(0, "李小龙", 27, 1000);
        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\obj_read_write_demo.dat")
        );
        
        oos.writeObject(employee1);
        oos.close();
    }

    public static void readAObjFunc() throws IOException, ClassNotFoundException{
        // 读取一个对象
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\obj_read_write_demo.dat")
        );
        
        Employee employee = (Employee) ois.readObject();
        System.out.println(employee);

        ois.close();
    }

    public static void writeObjsFunc() throws IOException{
        // 写入多个对象到文件时，可先将多个对象放入集合中，在将集合写入文件
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(0, "李小龙", 27, 1000));
        list.add(new Employee(1, "李小漫", 24, 800));
        list.add(new Employee(2, "李小玉", 12, 400));
        list.add(new Employee(3, "奇衡三", 65, 2000));


        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\objs_read_write_demo.dat")
        );
        
        oos.writeObject(list);
        oos.close();
    }

    public static void readObjsFunc() throws IOException, ClassNotFoundException{
        // 读取包含多个对象的集合，以便取出这些对象
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\objs_read_write_demo.dat")
        );
        
        ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();
        for (Employee employee : list) {
            System.out.println(employee);
        }

        ois.close();
    }
}
