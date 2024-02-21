package javase基础封装继承和多态.day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*从键盘接收一个正整数，该正整数作为行数，输出以下图形
        *
        ***
        *****
        *******
        *********
        例如：输入5，则打印如上图5行。*/
public class PrintTriangle {
    public void printTriangle(int rows, String triangleShape) {
        if (rows > 1) {
            if ("开口向上正三角".equals(triangleShape)) {
                for (int i = 1; i <= rows; i++) {
                    for (int j = 0; j < rows - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < i * 2 - 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else if ("开口向下正三角".equals(triangleShape)) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < (rows - i) * 2 - 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else if ("直角三角形".equals(triangleShape)) {
                for (int i = 1; i <= rows; i++) {
                    for (int j = 0; j < i * 2 - 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("非法的输入！");
            }
        } else {
            System.out.println("非法的输入！");
        }
    }
}

class Test04 {
    public static void main(String[] args) {
        System.out.println("请输入三角形的行数和类型（类型有：开口向上正三角、开口向下正三角和直角三角形）：");
        Scanner scanner = new Scanner(System.in);
        try {
            new PrintTriangle().printTriangle(scanner.nextInt(), scanner.next());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("\t非法的输入！");
        } finally{
            scanner.close();
        }
    }
}
