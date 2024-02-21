package javase基础封装继承和多态.day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*给一个不多于5位的正整数，
        要求：
        一、求它是几位数
        二、逆序打印出各位数字*/
public class AboutDigits {
    public int DigitsAmount(int num) {
        int i;
        for (i = 0; num != 0; i++) {
           num /= 10;
        }
        return i;
    }

    public void printReverse(int num) {
        while (num != 0) {
            System.out.print(num % 10);
            num /= 10;
        }
    }
}

class Test07 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            if (num < 1) {
                System.out.println("非法的输入！");
                return;
            }
            AboutDigits aboutDigits = new AboutDigits();
            System.out.println("这个数的位数为：" + aboutDigits .DigitsAmount(num));
            System.out.print("这个数逆序输出为：");
            aboutDigits.printReverse(num);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("\t非法的输入！");
        }
        scanner.close();
    }
}