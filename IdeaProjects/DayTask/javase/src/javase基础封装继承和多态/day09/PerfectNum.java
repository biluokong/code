package javase基础封装继承和多态.day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*一个数如果恰好等于它的因子之和，这个数就是完数，例如 6 = 1 + 2 + 3，编程
        找出1000内所有的完数。*/
public class PerfectNum {
    /**
     * 输入完数
     * 输出范围为；
     *     intRangeMin-intRangeMax之间的所有完数
     * @param intRangeMin
     * @param intRangeMax
     */
    public void printPerfectNum(int intRangeMin, int intRangeMax) {
        if (intRangeMin < 0) {
            System.out.println("非法的输入！");
            return;
        }
        for (int i = intRangeMin; i < intRangeMax; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2 ; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i && i != 0) {
                System.out.println(sum + "  ");
            }
        }
    }
}

class Test06 {
    public static void main(String[] args) {
        System.out.println("请输入你所求完数的范围（最小值和最大值）：");
        Scanner scanner = new Scanner(System.in);
        try {
            new PerfectNum().printPerfectNum(scanner.nextInt(), scanner.nextInt());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("\t非法的输入！");
        } finally {
          scanner.close();
        }
    }
}

