package chapter17.node01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited // 是否被继承
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE}) // 声明此注解可使用的位置
@Retention(RetentionPolicy.RUNTIME) // 声明此注解的生命周期，即运行时也保留此注解
public @interface MyAnnotation {
    String value();
}
