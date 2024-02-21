package com.bjpowernode.javase.实验十异常处理;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest01 {
    public static void main(String[] args) {
        System.out.println("请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        try {
            Circle circle = new Circle(input.nextDouble());
            System.out.println("圆的半径为："+ circle.circleArea());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("你输入了不匹配double类型的字符串！");
        } finally {
            input.close();
        }
    }
}

class Circle {

    static final double PI = 3.1415926;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double circleArea() {
        return PI * radius * radius;
    }
}
