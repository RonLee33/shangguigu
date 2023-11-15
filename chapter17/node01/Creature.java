package chapter17.node01;

public class Creature<T>{
    public int id;
    boolean gender;

    public void breath(T t) {
        System.out.println(t + "在呼吸");
    }

    private void info(T t){
        System.out.println(t + "是一种生物");
    }
}
