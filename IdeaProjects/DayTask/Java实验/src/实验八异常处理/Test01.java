package 实验八异常处理;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入圆的半径：");
        try {
            //获取圆的半径并创建此半径的圆对象
            double radius = input.nextDouble();
            Circle circle = new Circle(radius);

            //获得并输出圆的面积
            System.out.println("圆的面积为：" + circle.getArea());

            //当输入了不匹配的数据类型，会抛出类型不匹配异常
        } catch (InputMismatchException e) {    //捕捉相应的异常
            System.out.println("输入了不匹配的数据类型！");
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}

/**
 * 圆类
 */
class Circle {
    private static final double PI = 3.14;  //圆周率
    private double radius;  //圆的半径

    /**
     * 有参构造方法
     * @param radius 圆的半径
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * 求圆面积的方法
     * @return 圆的面积
     */
    public double getArea() {
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
