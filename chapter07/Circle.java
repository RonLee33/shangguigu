package chapter07;

class GeometricObject {
    protected String color;
    protected double weight;

    protected GeometricObject(){
        this("white", 1.0);
    }

    protected GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
}

public class Circle extends GeometricObject{
    private double radius;

    public Circle(){
        this("whilte", 1.0, 1.0);
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        // 计算面积
        return radius * radius * 3.14;
    }

    public boolean equals(Object object){
        if (object instanceof Circle){
            Circle c = (Circle) object;
            if (c.radius == this.radius){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + ", weight=" + weight + "]";
    }  
}
