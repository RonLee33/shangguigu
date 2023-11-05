package chapter15.node07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import chapter15.node03.FileReaderWriterDemo;

/**网上购物时某用户填写订单，订单内容为产品列表，保存在“save.bin”中,
 * 运行时，如果不存在“save.bin”，则进行新订单录入，如果存在，则显示并计算客户所需付款。
 * 编写Save()方法保存对象到 save.bin
 * 编写Load()方法获得对象，计算客户所需付款
*/
public class OrderExer {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        File file = new File(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\save.bin");
        if (file.exists()) {
            load();
        } else {
            save();
        }
    }

    public static void save() throws IOException{
        ArrayList<Product> list = new ArrayList<Product>();

        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\save.bin"));
        
        Scanner scanner = new Scanner(System.in);
        String name;
        double price;
        int num;
        boolean isContinue = true;
        do {
            System.out.print("请输入产品名：");
            name = scanner.next();
            System.out.print("请输入单价：");
            price = scanner.nextDouble();
            System.out.print("请输入数量：");
            num = scanner.nextInt();
            System.out.print("是否继续（y/n）：");
            isContinue = scanner.next().equals("y");

            list.add(new Product(name, price, num));
        } while (isContinue);

        oos.writeObject(list);
        scanner.close();
        oos.close();
        System.out.println("订单已保存");
    }

    public static void load() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\save.bin")
        );
        
        ArrayList<Product> list = (ArrayList<Product>) ois.readObject();
        double total = 0.0;

        System.out.println("产品名\t单价\t数量");
        for (Product product : list) {
            total += product.price * product.num;
            System.out.println(product.productName + "\t" + product.price + "\t" + product.num);
        }
        ois.close();

        System.out.println("订单总价：" + total);
    }

}

class Product implements Serializable{
    static final long serialVersionUID = 27182834235L;
    String productName;
    double price;
    int num;

    public Product(String productName, double price, int num){
        this.productName = productName;
        this.price = price;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", price=" + price + ", num=" + num + "]";
    }

}
