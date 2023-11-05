package chapter15.node04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import chapter15.node03.FileReaderWriterDemo;

public class FileStreamDemo {
    public static void main(String[] args) throws IOException {
        readFileStream();
        readFileStreamChars();
        writeFileStream();
        writeFileStreamAttach();
    }

    public static void readFileStream() throws IOException{
        // 读单个字节
        FileInputStream fileInputStream = new FileInputStream(
            new File(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\hello.txt"));
        int data;
        while ((data = fileInputStream.read()) != -1) {
            System.out.println((char) data);
        }

        fileInputStream.close();
    }

    public static void readFileStreamChars() throws IOException{
        // 读多个字节
        FileInputStream fileInputStream = new FileInputStream(
            new File(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\hello.txt"));
        int len;
        
        byte[] buffs = new byte[5];
        while ((len = fileInputStream.read(buffs)) != -1) {
            System.out.println(new String(buffs, 0, len));
        }

        fileInputStream.close();
    }

    public static void writeFileStream() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(
            new File(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\write_stream.txt"));
        
        String text = "stream write";
        fileOutputStream.write(text.getBytes());
        fileOutputStream.write("\n".getBytes());

        fileOutputStream.write(text.getBytes(), 0, 6);
        fileOutputStream.write("\n".getBytes());

        fileOutputStream.write(97); // 写入ASCII中的‘a’
        fileOutputStream.close();
    }

    public static void writeFileStreamAttach() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(
            new File(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\write_stream.txt"), 
            true);// 附加模式，在原内容之后追加内容
        
        fileOutputStream.write("\\nAttach\\n".getBytes());
        fileOutputStream.close();
    }
}
