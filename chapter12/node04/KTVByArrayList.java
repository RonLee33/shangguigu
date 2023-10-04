package chapter12.node04;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 分别使用ArrayList和LinkedList集合，编写一个KTV点歌系统的程序。在程序中：
 * 指令1代表添加歌曲
 * 指令2代表将所选歌曲置顶
 * 指令3代表将所选歌曲提前一位
 * 指令4代表退出该系统
 * 要求根据用户输入的指令和歌曲名展现歌曲列表。
 * 例如输入指令1，输入歌曲名"爱你一万年"，则输出“当前歌曲列表：[爱你一万年]”。
 * */

public class KTVByArrayList {

    public static final int ADD_MUSIC = 1;
    public static final int SET_TOP = 2;
    public static final int SET_BEFORE = 3;
    public static final int EXIT_SYSTEM = 4;

    private static LinkedList<String> musicList = new LinkedList<String>(); // 音乐列表
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMusicList();
        showMusicList();

        System.out.println("-------------欢迎来到点歌系统------------");
        displayMenu();
        int flag = scanner.nextInt();
        String music;
        while (true) {
            switch (flag) {
                case ADD_MUSIC:
                    System.out.print("请输入要添加的歌曲名称：");
                    music = scanner.next();
                    addMusic(music);
                    break;
                case SET_TOP:
                    System.out.print("请输入要置顶的歌曲名称：");
                    music = scanner.next();
                    setTop(music);
                    break;
                case SET_BEFORE:
                    System.out.print("请输入要前置一位的歌曲名称：");
                    music = scanner.next();
                    setBefore(music);
                    break;
                case EXIT_SYSTEM:
                    System.out.println("已退出系统");
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
            showMusicList();
            displayMenu();
            flag = scanner.nextInt();
        }
    }

    private static void displayMenu(){
        System.out.println("1.添加歌曲至列表");
        System.out.println("2.将歌曲置顶");
        System.out.println("3.将歌曲前移一位");
        System.out.println("4.退出");
        System.out.print("请输入操作(1-4)：");
    }

    private static void showMusicList(){
        System.out.println("==>当前歌曲列表为:");
        System.out.println("***********************************************");
        for (String music : musicList) {
            System.out.println(music);
        }
        System.out.println("***********************************************");
    }

    private static void initMusicList(){
        musicList.add("本草纲目");
        musicList.add("你是我的眼");
        musicList.add("老男孩");
        musicList.add("白月光与朱砂痣");
        musicList.add("不谓侠");
        musicList.add("爱你");
    }

    private static void addMusic(String music){
        int currentIndex = musicList.indexOf(music);
        if (currentIndex < 0) {
            musicList.add(music);
            System.out.println("==>音乐添加完成");
        } else {
            System.out.println("==>此音乐已在播放列表中，无需再次添加");
        }
        
    }

    private static void setTop(String music){
        // 置顶音乐
        int currentIndex = musicList.indexOf(music);

        if (currentIndex < 0){
            System.out.println("==>该歌曲不在音乐列表中。");
        } else if (currentIndex ==  0){
            System.out.println("==>该音乐已置顶，无需再次置顶。");
        } else {
            musicList.remove(currentIndex);
            musicList.add(0, music);
            System.out.println("==>该音乐已置顶完成。");
        }
    }

    private static void setBefore(String music){
        // 将所选音乐提前一位
        int currentIndex = musicList.indexOf(music);
        if (currentIndex < 0){
            System.out.println("==>所选音乐不在音乐列表中");
        } else if(currentIndex == 0){
            System.out.println("==>该音乐已在第一位（已置顶），无法再提前");
        } else {
            musicList.remove(music);
            musicList.add(currentIndex - 1, music);
        }

    }
}
