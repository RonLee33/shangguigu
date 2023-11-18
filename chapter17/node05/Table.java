package chapter17.node05;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 一个完整的注解应该包含三个部分:
 * （1）声明
 * （2）使用
 * （3）读取
 *  */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    // 用于“注解”数据库的表信息
    String value() default "abc";
}
