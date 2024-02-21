package 面向对象抽象.day20;

public class Rectangle extends Graph {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(String brushColor, boolean filling, double length, double width) {
        super(brushColor, filling);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "一个" + getBrushColor() + (isFilling() ? "、有填充、" : "、无填充、") + "长为：" + length + "宽为：" + width + "的长方形";
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
