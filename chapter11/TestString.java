package chapter11;

import org.junit.Assert;
import org.junit.Test;

public class TestString {
    @Test
    public void test1(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = (s1 + s2).intern();

        Assert.assertTrue(s3 == s4); // true
        Assert.assertTrue(s3 == s5); // true
        Assert.assertTrue(s4 == s5); // true
        Assert.assertTrue(s3 == s6); // true

        
    }
}
