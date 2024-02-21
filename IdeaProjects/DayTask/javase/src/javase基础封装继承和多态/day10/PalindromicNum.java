package javase基础封装继承和多态.day10;

import java.util.InputMismatchException;
import java.util.Scanner;
/*题目：一个5位数，判断它是不是回文数。即12321是回文数，
        个位与万位相同，十位与千位相同*/
public class PalindromicNum {
    /**
     * 判断一个数是否是回文数
     * @param num
     */
    public void JudgingNum(int num) {
        int[] temp = new int[20];
        int count = 0;
        for (count = 0; num != 0; count++) {
            temp[count] = num % 10;
            num /= 10;
        }
        boolean flag = true;
        for (int i = 0; i < count / 2; i++) {
            if (temp[i] != temp[count - 1 - i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("此数是一个回文数");
        } else {
            System.out.println("此数不是个回文数");
        }
    }
}

class Test01 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        try {
            new PalindromicNum().JudgingNum(scanner.nextInt());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("\t方法的输入！");
        } finally {
            scanner.close();
        }
    }
}
