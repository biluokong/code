package 实验六继承和多态;

public class App {
    public static void main(String[] args) {
        Compute compute = new Compute();    //创建计算对象
        Circle circle = new Circle(2);  //创建一个半径为2圆形
        Rectangle rectangle = new Rectangle(4, 5);  //创建一个宽为4，长为5的矩形

        System.out.println("圆形的面积为：" + compute.computerArea(circle));   //计算并输出圆形的面积
        System.out.println("矩形的面积为：" + compute.computerArea(rectangle));    //计算并输出矩形的面积
    }
}

/**
 * 计算类，有计算各种图形的面积的方法
 */
class Compute {
    /**
     * 计算图形shape的面积
     * @param shape 图形
     * @return 面积
     */
    public double computerArea(Shape shape) {
        return shape.area();
    }
}

/**
 * 矩形类，实现了图形接口
 */
class Rectangle implements Shape {
    private int width;  //矩形的宽
    private int height; //矩形的长

    /**
     * 有参构造创建一个宽为width，长为height的矩形
     * @param width
     * @param height
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 计算矩形的面积
     * @return 面积
     */
    @Override
    public double area() {
        return width * height;
    }
}

/**
 * 圆形类实现了图形接口
 */
class Circle implements Shape {
    private int radius;     //半径

    /**
     * 有参构造方法创建一个半径为radius的圆形
     * @param radius
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * 计算圆的面积
     * @return 面积
     */
    @Override
    public double area() {
        return 2 * PI * radius;
    }
}

/**
 * 图形类，拥有计算面积功能的接口
 */
interface Shape {
    public static final double PI = 3.14;

    double area();
}
