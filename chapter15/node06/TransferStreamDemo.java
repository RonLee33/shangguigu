package chapter15.node06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import chapter15.node03.FileReaderWriterDemo;

/**
 * 把编码集为UTF-8的《s.txt》变为GBK编码的《d.txt》。
*/
public class TransferStreamDemo {
    public static void main(String[] args) {
        transfer("s.txt", "d.txt");
    }

    public static void transfer(String source, String target){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" + source),
                     "UTF-8"
                    )
                );
                
            bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(FileReaderWriterDemo.CHAPTER_15_ROOT_PATH + "\\" +target),
                    "GBK"
                )
            );

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

        

}
