package chapter08;

public class EnumDemo {
    public static void main(String[] args) {
        // System.out.println(SeasonBefore5.SPRING);
        // System.out.println(SeasonIn5.SPRING.getClass());
        // System.out.println(SeasonIn5.SPRING.getClass().getSuperclass());

        // SeasonIn5[] allSeasonIn5s = SeasonIn5.values();
        // for(SeasonIn5 seasonIn5 : allSeasonIn5s){
        //     System.out.println(seasonIn5);
        // }

        SeasonIn5 spring = SeasonIn5.valueOf("SPRING");
        System.out.println(spring);
    }
}

class SeasonBefore5{
    private final String seasonName; // 季节名称
    private final String seasonDesc; // 季节描述

    private SeasonBefore5(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "SeasonBefore5 [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
    }

    public static final SeasonBefore5 SPRING = new SeasonBefore5("春天", "春暖花开");
    public static final SeasonBefore5 SUMMER = new SeasonBefore5("夏天", "夏日炎炎");
    public static final SeasonBefore5 AUTUMN = new SeasonBefore5("秋天", "秋高气爽");
    public static final SeasonBefore5 WINTER = new SeasonBefore5("冬天", "白雪皑皑");
}

enum SeasonIn5{

    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "白雪皑皑");

    private final String seasonName; // 季节名称
    private final String seasonDesc; // 季节描述

    private SeasonIn5(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "SeasonIn5 [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
    }
}