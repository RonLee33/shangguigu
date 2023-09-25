package chapter11;

import java.io.UnsupportedEncodingException;

/**String 的编码与解码*/

public class StringDemo2 {
    public static void main(String[] args) throws UnsupportedEncodingException{
        String str = "中国";

        //编码
        // ISO8859-1把所有的字符都当做一个byte处理，处理不了多个字节, 2
        System.out.println(str.getBytes("ISO8859-1").length);
        // 4 每一个中文都是对应2个字节
        System.out.println(str.getBytes("GBK").length);
        // 6 常规的中文都是3个字
        System.out.println(str.getBytes("UTF-8").length);

        // 解码
        // 不支持中文的字符集，即便字符集一致也会显示乱码
        System.out.println(new String(str.getBytes("ISO8859-1"), "ISO8859-1"));

        // 编/解码 字符集不一致时，会显示乱码
        System.out.println(new String(str.getBytes("GBK"), "ISO8859-1"));

        // 支持中文时，编/解码字符集一致，显示正确
        System.out.println(new String(str.getBytes("GBK"), "GBK"));
        System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));

        byte[] encode = str.getBytes("GBK");
        System.out.println(encode.length);
        // 只对部分byte[]数组进行解码
        System.out.println(new String(encode, 0, 2));
        
    }
}
