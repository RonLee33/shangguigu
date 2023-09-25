package chapter11;

public class StringExer {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//16 --实际是4

        System.out.println(sb);//null

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//null
    }
}
