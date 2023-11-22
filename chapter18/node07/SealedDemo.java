package chapter18.node07;

public class SealedDemo {
    
}

// sealed A permits B, C, D 表示 类A只能被类B、C、D继承
// 且 子类B、C、D必须被 sealed、non-sealed、final之一修饰
// sealed 用于指定某类能被哪些类继承
abstract sealed class Shape permits Circle, Rectangle, Square{

}


// final 表示 Circle不能被任何类继承
final class Circle extends Shape{
}

// non-sealed 表示取消sealed限制，能被任何类继承
// Rectangle类能被任何类继承
non-sealed class Rectangle extends Shape{
}

// Square 只能被A继承
sealed class Square extends Shape permits A {
}

// A 绝户
final class A extends Square{
}