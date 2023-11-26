package chapter18.node06;

enum Week{
    MONDAY, TUESDAY, WENDSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class SwitchFeature {
    public static void main(String[] args) {
        // before12();
        // switchIn12();
        switchIn13();
    }

    public static void before12(){
        // JDK 12之前的switch表达式
        Week day = Week.WENDSDAY;
        switch (day) {
            case MONDAY:
                System.out.println(1);
                break;
            case TUESDAY:
            case WENDSDAY:
            case THURSDAY:
            case FRIDAY: //不能写成 case TUESDAY | WENDSDAY| THURSDAY | FRIDAY
                System.out.println(5);
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println(7);
                break;
            default:
                System.out.println(0);
                break;
        }
    }

    public static void switchIn12(){
        // JDK 12之中新增的switch表达式，新增 -> 代替:,此时不会出现原“switch”穿透的现象(用“:”仍会出现击穿，此时相当于未用新特性)
        // 而且一个case中可写多种操作相同的匹配项
        // 但同一个switch不能同时写 : 和 ->
        // 另外，可以使用变量接受switch结果

        Week day = Week.WENDSDAY;
        switch (day) {
            case MONDAY -> {
                // 可写复合语句
                System.out.println(1);
                System.out.println(2);
            }
            //并列多个 case 匹配项： TUESDAY | WENDSDAY| THURSDAY | FRIDAY
            case TUESDAY, WENDSDAY, THURSDAY, FRIDAY -> 
                System.out.println(5);
            case SATURDAY, SUNDAY -> 
                System.out.println(7);
            default ->
                System.out.println(0);
        }

        // 变量接受switch结果,但不能在case分支中写复合语句
        int result = switch (day) {
            case MONDAY -> 1;
            //并列多个 case 匹配项： TUESDAY | WENDSDAY| THURSDAY | FRIDAY
            case TUESDAY, WENDSDAY, THURSDAY, FRIDAY -> 2;
            case SATURDAY, SUNDAY -> 7;
            default -> 0;
        };//此时末尾的这个分号不能省
        System.out.println(result);
    }

    public static void switchIn13(){
        // switch在JDK13中中新增yield（只能用于switch中），用于返回值
        Week day = Week.MONDAY;

        int result = switch (day) {
            case MONDAY ->{
                int o = 1;
                int i = 2;
                yield  o + i;
            }
            case TUESDAY, WENDSDAY, THURSDAY, FRIDAY -> {
                yield 5;
            }
            case SATURDAY, SUNDAY -> {
                yield 7;
            }
            default -> {
                yield 0;
            }
        };
        System.out.println(result);

        // yield与“:”配合使用时，复合语句无需写大括号
        int result1 = switch (day) {
            case MONDAY: 
                System.out.println(1);
                yield  1;
            case TUESDAY, WENDSDAY, THURSDAY, FRIDAY: yield 5;
            case SATURDAY, SUNDAY: yield 7;
            default: yield 0;
        };
        System.out.println(result1);
    }    

    static String formatter(Object o){
        String formatted = "unknown";
        if (o instanceof Integer i) {
            formatted = "int " + i;
        } else if (o instanceof Long l) {
            formatted = "long " + l;
        } else if (o instanceof Double d) {
            formatted = "double " + d;
        } else if (o instanceof String s){
            formatted = "String " + s;
        }
        return formatted;
    }

    public static String switchIn17(Object o){
        // Switch在JDk17中新增模式匹配，这是个预览特性
        // 见IDEA中switchdemo的switch_feature.SwitchFeature类
        return "ss";
    }
    
}
