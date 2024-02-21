package javase基础封装继承和多态.day09;

import java.util.InputMismatchException;
import java.util.Scanner;
//从控制台输入一个正整数，计算该数的阶乘。例如输入5，阶乘为 5*4*3*2*1
public class Factorial {

    public long factorial(int num, boolean way) {
        if (way) {//方法一：普通方法
            long factorial = 1L;
            for (int i = num; i > 0; i--) {
                factorial *= i;
            }
            return factorial;
        } else {//方法二：递归方法
            if (1 == num) {
                return 1;
            }
            return num * factorial(num - 1, false);
        }
    }
}

class Test02{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你所求阶乘的数和求阶乘的方式（true表示普通方法，false表示递归方式）：");
        try {
            System.out.println(new Factorial().factorial(scanner.nextInt(), scanner.nextBoolean()));
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("    非法的输入！");
        } finally {
            scanner.close();
        }
    }
}
