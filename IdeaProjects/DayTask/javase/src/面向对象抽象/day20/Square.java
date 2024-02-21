package 面向对象抽象.day20;

public class Square extends Graph {
    private double sideLength;

    public Square() {
    }

    public Square(String brushColor, boolean filling, double sideLength) {
        super(brushColor, filling);
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "一个" + getBrushColor() + (isFilling() ? "、有填充、" : "、无填充、") + "边长为：" + sideLength + "的正方形";
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}
