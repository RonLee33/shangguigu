package chapter15.node04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import chapter15.node03.FileReaderWriterDemo;

public class CopyFile {
    public static void main(String[] args) {
        // 复制文本文件
        copy("hello.txt", "hello_copy_" + System.currentTimeMillis() + ".txt");
        // 复制非文本文件，如图片
        copyNotTextFile("girls.png", "girls_copy_" + System.currentTimeMillis() + ".png");
    }

    public static void copy(String sourceFile, String targetFile){
        File source = new File(
            FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + sourceFile);
        File target = new File(
            FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + targetFile);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    public static void copyNotTextFile(String source, String target){
        // 复制非文本文件，如图片
        File sourceFile = new File(
            FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + source);
        File targetFile = new File(
            FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + target);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        int len;
        byte[] buffs = new byte[1024];

        try {
            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream = new FileOutputStream(targetFile);

            while ((len = fileInputStream.read(buffs)) != -1) {
                fileOutputStream.write(buffs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
