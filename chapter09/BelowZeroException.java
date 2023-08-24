package chapter09;

public class BelowZeroException extends RuntimeException{
    // 自定义异常，输入负数弹出此错误
    static final long serialVersionUID = -7034897L;

    public BelowZeroException(){
        super();
    }

    public BelowZeroException(String message){
        super(message);
    }
}
