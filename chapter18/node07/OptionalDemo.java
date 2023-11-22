package chapter18.node07;

import java.util.Optional;

// Optional类，避免空指针异常

public class OptionalDemo {
    public static void main(String[] args) {
        demo1();
    }

    static void demo1(){
        String star = "李小龙";
        star = null;

        // Optional.ofNullable(T) 创建optional，T可能为null，可能非null
        Optional<String> optional = Optional.ofNullable(star);
        System.out.println(optional.isPresent());
    
        String otherStar = "成龙";
        // optional.orElse(otherStar), 当star=null时，返回otherStar的值，否则返回star
        // optional.orElse(otherStar) 与 Optional.ofNullable(star) 组合使用
        String finalStar = optional.orElse(otherStar);
        System.out.println(finalStar);
    }

}
