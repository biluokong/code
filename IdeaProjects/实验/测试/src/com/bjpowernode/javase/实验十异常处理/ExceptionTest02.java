package com.bjpowernode.javase.实验十异常处理;

import java.util.Scanner;

public class ExceptionTest02 {
    public static void main(String[] args) {
        System.out.println("请输入两个整数a和b：");
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("a/b=" + divide(input.nextInt(), input.nextInt()));
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    public static int divide(int a, int b) throws DivideByZeroException {
        if (0 == b) {
            throw new DivideByZeroException("除数不能为零！");
        }
        return a / b;
    }

}

class DivideByZeroException extends Exception {
    public DivideByZeroException() {
    }

    public DivideByZeroException(String message) {
        super(message);
    }
}
