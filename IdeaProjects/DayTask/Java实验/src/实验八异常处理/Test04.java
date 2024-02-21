package 实验八异常处理;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入三角形的三边长：");
        try {
            //获得三边长并求它的面积
            double area = getTriangleArea(input.nextDouble(), input.nextDouble(), input.nextDouble());
            System.out.println("三角形的面积为：" + area);
        } catch (IllegalException e) {  //不能构成三角形的情况
            e.getMessage();
            e.printStackTrace();
        } catch (InputMismatchException e) {    //输入数据类型不匹配的情况
            System.out.println("输入的数据类型不匹配！");
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    /**
     * 获得三角形的面积的方法
     * @param a 第一条边的长度
     * @param b 第二条边的长度
     * @param c 第三条边的长度
     * @return 三角形的面积
     * @throws IllegalException 若该三条边不能构成三角形，则抛出此异常
     */
    public static double getTriangleArea(double a, double b, double c) throws IllegalException {
        //判断输入的三边长是否能构成三角形
        if ((a + b > c) && (a + c > b) && (b + c > a) && a > 0 && b > 0 && c > 0) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        //不能构成三角形，抛出异常
        throw new IllegalException();
    }
}

/**
 * 三边长不合法异常类
 */
class IllegalException extends Exception {
    public IllegalException() {
    }

    @Override
    public String getMessage() {
        return "输入的三角形三边长不合法！";
    }
}