package javase基础封装继承和多态.day09;

import java.util.Scanner;
//计算1000以内所有不能被7整除的整数之和
public class IntegerSummation {

    /**
     * 对整数求和，求和范围为：
     * intRangeMin-intRangeMax
     * @param intRangeMin
     * @param intRangeMax
     * @return 所求的和
     */
    public int sumInt(int intRangeMin, int intRangeMax) {
        int sum = 0;
        for (int i = intRangeMin; i <= intRangeMax; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 对整数求和
     * way为true时；
     *   求和范围为：intRangeMin-intRangeMax间能被divisibleNum整除的数
     * way为false时：
     *   求和范围为：intRangeMin-intRangeMax间不能被divisibleNum整除的数
     * @param intRangeMin
     * @param intRangeMax
     * @param divisibleNum
     * @param way
     * @return 所求的和
     */
     public int sumInt(int intRangeMin, int intRangeMax, int divisibleNum, boolean way) {
        int sum = 0;
        if (way) {
            for (int i = intRangeMin; i < intRangeMax; i++) {
                if (i % divisibleNum == 0) {
                    sum += i;
                }
            }
        } else {
            for (int i = intRangeMin; i < intRangeMax; i++) {
                if (i % divisibleNum != 0) {
                    sum += i;
                }
            }
        }
        return sum;
    }
}

class Test01 {
    public static void main(String[] args) {
        IntegerSummation integerSummation = new IntegerSummation();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入四个参数：intRangeMin,intRangeMax,divisibleNum和way\n" +
                "(way为true时；\n" +
                "    求和范围为：intRangeMin-intRangeMax间能被divisibleNum整除的数\n" +
                "way为false时：\n" +
                "    求和范围为：intRangeMin-intRangeMax间不能被divisibleNum整除的数)：");
        int sum = integerSummation.sumInt(input.nextInt(), input.nextInt(), input.nextInt(), input.nextBoolean());
        input.close();
        System.out.println("求和结果为：" + sum);
    }
}
