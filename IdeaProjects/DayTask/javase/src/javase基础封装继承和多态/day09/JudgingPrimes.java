package javase基础封装继承和多态.day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*从控制台接收一个正整数，判断该数字是否为质数
        质数（质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数）*/
public class JudgingPrimes {
    /**
     * 求一个数是否为质数
     * @param num
     */
    public void judgingPrimes(int num) {
        boolean flag = false;
        //Math.sqrt(num)也可换成num/2.
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag || num == 1) {
            System.out.println(num + "不是一个质数。");
        } else {
            System.out.println(num + "是一个质数。");
        }
    }
}

class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        try {
            new JudgingPrimes().judgingPrimes(scanner.nextInt());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("/t非法的输入！");
        } finally{
            scanner.close();
        }
    }
}
