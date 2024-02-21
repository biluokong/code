import java.util.Scanner;

/**
 * 本关任务：一个楼梯共有n（n<10000）阶台阶，规定每步可以迈1阶、2阶或3阶。
 * 从1阶到第n阶，一共可以有多少种不同的迈法。（用两种方法：1：普通地递归 2：动态规划 3：备忘录法）
 * 测试输入：5
 * 预期输出：13
 *
 * 测试输入：10
 * 预期输出：274
 */
public class 上台阶 {
    public static void main(String[] args) {
        //获得输入的台阶数
        System.out.println("请输入1-10000之间的台阶数：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        //防止非法输入
        while (n <= 0 || n > 10000) {
            System.out.println("输入非法，请输入1-10000之间的台阶数：");
            n = input.nextInt();
        }

        //普通地递归
        long sum1 = climbingStairs1(n);
        System.out.println(sum1);

        //2：动态规划
        long sum2 = climbingStairs2(n);
        System.out.println(sum2);
    }

    /**
     * 普通地递归，自顶向下求解
     * @param n 台阶数
     * @return 迈法总数
     */
    public static long climbingStairs1(int n) {
        //递归终止条件
        //剩余台阶数为1时，只有1种迈法，迈1阶
        if (n == 1) {
            return 1;
        }
        //剩余台阶数为2时，有2种迈法，迈两次1阶和一次迈2阶
        if (n == 2) {
            return 2;
        }
        //剩余台阶数为3时，有4种迈法，迈三次1阶、先迈一次1阶再迈一次2阶、先迈一次2阶再迈一次1阶和一次迈3阶
        if (n == 3) {
            return 4;
        }
        //递归调用
        //每次递归，相当于把这个问题分成3类，先迈1阶、先迈2阶或先迈3阶，然后迈剩下的台阶
        //以此类推，每次递归分3类，直到剩下的台阶数为1、2、3时，递归终止
        //最后运用分类加法计数原理相加，从而求得迈法总数
        return climbingStairs1(n - 1) + climbingStairs1(n - 2) + climbingStairs1(n - 3);
    }

    /**
     * 动态规划，自底向上求解
     * @param n 台阶数
     * @return 迈法总数
     */
    public static long climbingStairs2(int n) {

        //初始化数组
        int[] dp = new int[n + 3];
        //初始化数组
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            //与递归方法的用的思想是一样的，分成3类，先迈1阶、先迈2阶或先迈3阶
            //不过是自底向上的，前面的结果已经计算好并通过循环用数组保存好了，直接用来相加即可
            //不用一直递归到只剩1、2、3个台阶
            //（有此可以推出第三种方法，备忘录法，即保存的数据不通过循环产生，而通过递归产生，再进行保存）
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    //备忘录法
    public static long climbingStairs3(int n) {
        return 0;
    }
}
