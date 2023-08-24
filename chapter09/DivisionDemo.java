package chapter09;

public class DivisionDemo {
    public static void main(String[] args) {

        try {
            int d1 = Integer.parseInt(args[0]);
            int d2 = Integer.parseInt(args[1]);
            int result = divide(d1, d2);
            System.out.println(result);
        } catch (BelowZeroException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            // 只有整数之间相除时才会报ArithmeticException
            // 浮点数除零的结果是输出 Infinity
            System.out.println("除零");
        } catch (NumberFormatException e){
            System.out.println("数据格式不正确");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        }
    }

    public static int divide(int d1, int d2) throws BelowZeroException{
        if (d1 < 0 || d2 < 0){
            throw new BelowZeroException("输入负数了");
        }
        return d1 / d2;

    }
}

