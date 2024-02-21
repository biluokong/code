package 面向对象抽象.day20;

public class Circle extends Graph {
    static final double PI = 3.141592;
    private double radius;

    public Circle() {
    }

    public Circle(String brushColor, boolean filling, double radius) {
        super(brushColor, filling);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "一个" + getBrushColor() + (isFilling() ? "、有填充、" : "、无填充、") + "半径为：" + radius + "的圆形";
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public static double getPI() {
        return PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
