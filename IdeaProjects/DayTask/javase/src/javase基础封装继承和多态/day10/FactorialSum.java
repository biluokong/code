package javase基础封装继承和多态.day10;

import java.util.InputMismatchException;
import java.util.Scanner;

/*题目：计算 1! + 2! + 3! + 4! +... + 10!
        说明：4! 表示4的阶乘。4的阶乘是：1 * 2 * 3 * 4*/
public class FactorialSum {
    /**
     * 求阶乘1! + 2! + 3! + 4! +... + num!的和
     * way为true时用普通方法，嵌套循环
     *    为false时用递归方法
     * @param num
     * @param way
     * @return
     */
    public long Sum(int num, boolean way) {
        if (num < 1) {
            System.out.println("非法的输入！");
            System.exit(0);
        }
        //普通方法
        if (way) {
            long sum = 0L;
            for (int i = num; i > 0; i--) {
                long temp = 1L;
                for (int j = i; j > 0; j--) {
                    temp *= j;
                }
                sum += temp;
            }
            return sum;
        } else {
            if (num == 1) {
                return 1;
            }
            int sum = 1;
            for (int i = num; i > 0 ; i--) {
                sum *= i;
            }
            return sum + Sum(num - 1, false);
        }
    }
}

class Test03 {
    public static void main(String[] args) {
        FactorialSum factorialSum = new FactorialSum();
        System.out.println("请输入一个整数和选择一个方法（true表示普通方法求阶乘和，false表示递归方法求阶乘和）：");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("阶乘和为：" + factorialSum.Sum(scanner.nextInt(), scanner.nextBoolean()));
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("非法的输入！");
        } finally {
            scanner.close();
        }
    }
}