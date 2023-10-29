package chapter12.node07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**（对面板上的点进行排序）编写一个程序，满足下面的要求：
 * 1.定义一个名为Point的类，它的两个数据域x和y分别表示点的x坐标和y坐标。如果x坐标一样, 实现Comparable接口对在x坐标和y坐标上的点进行比较。
 * 2.定义一个名为CompareY的类实现Comparator<Point>。如果y坐标一样，实现compare方法，对在它们的x坐标和它们的y坐标上的两个点进行比较。
 * 3.随机创建10个点，然后使用Collections.sort方法分别以它们x坐标的升序和y坐标的升序显这些点。
 * */

public class PointSorted {
    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList<>();
        int x, y;
        for (int i = 0; i < 10; i++){
            x = (int) (Math.random() * 300);
            y = (int) (Math.random() * 400);
            list.add(new Point(x, y));
        }

        System.out.println("以x坐标升序显示所有的Point: ");
        Collections.sort(list);
        for (Point point : list) {
            System.out.println(point);
        }

        System.out.println("以y坐标升序显示所有的Point: ");
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.getY() - o2.getY();
            }  
        });

        for (Point point : list) {
            System.out.println(point);
        }
    }   
}

class Point implements Comparable<Point>{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return x - o.getX();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    
}
