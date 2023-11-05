package chapter15.node05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import chapter15.node03.FileReaderWriterDemo;
import chapter15.node04.CopyFile;

// 比较缓冲流与节点流的IO效率

public class CopyFileByBuffer {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CopyFile.copyNotTextFile("girls.png", "girls_copy_" + System.currentTimeMillis() + ".png");
        long end = System.currentTimeMillis();
        System.out.println("节点流复制耗时：" + (end - start));

        start = System.currentTimeMillis();
        CopyFileByBuffer.copyByBuffer("girls.png", "girls_copy_" + System.currentTimeMillis() + ".png");
        end = System.currentTimeMillis();
        System.out.println("缓冲流复制耗时：" + (end - start));
        
    }

    public static void copyByBuffer(String source, String target){
        File sourceFile = new File(
            FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + source);
        File targetFile = new File(
            FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + target);
        

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        int len;
        byte[] buff = new byte[1024];

        try {
            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream = new FileOutputStream(targetFile);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            while ((len = bufferedInputStream.read(buff)) != -1) {
                bufferedOutputStream.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
