package 面向对象抽象.day22;
/*（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
（2）定义接口B，里面包含抽象方法void setColor(String c)。
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
圆柱体的高height、颜色color。
（5）创建主类来测试类Cylinder。*/
public class Test01 {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(4, 6, "蓝色");
        System.out.println("面积为：" + cylinder.area());
        System.out.println("体积为：" + cylinder.volume());
        System.out.println(cylinder);
    }
}

class Cylinder implements C {
    private double radius;
    private double height;
    private String color;

    public Cylinder() {
    }

    public Cylinder(double radius, double height, String color) {
        this.radius = radius;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public double area() {
        return 2 * PI * radius * (radius + height);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double volume() {
        return PI * radius * radius * height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }
}

interface A {
    static final double PI = 3.14;

    double area();
}

interface B {
    void setColor(String color);
}

interface C extends A, B {
    double volume();

}