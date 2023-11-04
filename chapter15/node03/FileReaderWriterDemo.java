package chapter15.node03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
    public final static String CHAPTER_15_ROOT_PATH = "D:\\CodeProject\\Java\\shangguigu\\chapter15\\file_data";

    public static void main(String[] args) throws FileNotFoundException, IOException{
        readFileAChar();
        readFileChars();
        writeFile();
        writeAttach();
    }

    public static void readFileAChar() throws FileNotFoundException, IOException {
        // 读取文件：每次一个字符
        File file = new File(CHAPTER_15_ROOT_PATH + "\\hello.txt");
        FileReader fileReader = new FileReader(file);
        int data;
        // 单次读取一个字符
        while ((data = fileReader.read()) != -1) {
            System.out.println((char) data);
        }
        fileReader.close();
    }

    public static void readFileChars() throws FileNotFoundException, IOException{
        // 读取文件：每次多个字符
        File file = new File(CHAPTER_15_ROOT_PATH + "\\hello.txt");
        FileReader fileReader = new FileReader(file);
        // 记录每次实际读入的字符的个数
        int len;
        // 设置每次读取5个字符，注意 len 不一定等于 5
        char[] buffs = new char[5]; 
        while ((len = fileReader.read(buffs)) != -1) {
            System.out.println(new String(buffs, 0, len));
        }
        fileReader.close();
    }

    public static void writeFile() throws IOException{
        // 写入新文件，若文件已存在且有内容，则原文件的内容会被覆盖
        FileWriter fileWriter = new FileWriter(new File(CHAPTER_15_ROOT_PATH + "\\file_write.txt"));

        fileWriter.write(97); // 写入ASCII 的 a
        fileWriter.write("\n");

        String text = "writechar";
        fileWriter.write(text.toCharArray()); //写入字符数组
        fileWriter.write("\n");

        // 写入字符数组指定子串，从下标0开始，写入5个字符，即“write”
        fileWriter.write(text.toCharArray(), 0, 5);
        fileWriter.write("\n");

        // 写入字符串
        fileWriter.write(text);
        fileWriter.write("\n");

        // 写入字符串子串, 即“char”
        fileWriter.write(text, 5, 4);
        fileWriter.write("\n");

        fileWriter.close();
    }

    public static void writeAttach() throws IOException{
        // 附件文件内容，不会覆盖原文件的内容
        FileWriter fileWriter = new FileWriter(new File(CHAPTER_15_ROOT_PATH + "\\hello.txt"), true);
        fileWriter.write("\n");
        fileWriter.write("fileWriter.write(): " + System.currentTimeMillis());
        fileWriter.close();
    }

}
