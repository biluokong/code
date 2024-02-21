import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入3个正整数m，n，k（m,n,k≤100）,现有m个A，n个B,k个C，即m+n+k张3种卡片，
 * 计算共有多少种排列。
 * 输入：2 3 4     输出：1260
 * 输入：3 4 5     输出：27720
 */
public class 排列卡片 {
    static Map<Integer,String> combinations = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入三个正整数m,n,k，以空格分隔：");
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (m >= 0 && n >= 0 && k >= 0) {
                //调用用普通公式的方法求排列总数
                //System.out.println(Divisible(m, n, k).toString());

                //调用dfs方法求排列总数
                //先将卡片具体化
                String str = "";
                for (int i = 0; i < m; i++) {
                    str += "A";
                }
                for (int i = 0; i < n; i++) {
                    str += "B";
                }
                for (int i = 0; i < k; i++) {
                    str += "C";
                }
                traverseCombination(str);
                System.out.println(combinations.size());
                break;
            } else {
                System.out.println("错误，m,n,k必须为正整数，请重新输入！");
            }
        }
    }

    private static void traverseCombination(String str) {
        int num = str.length();
        while (num > 0) {
            for (int i = 0; i < num; i++) {

            }
        }
    }

    /**
     * 应用公式：（m+n+k）！ / （m！* n！* k！)
     * @param m A卡片数量
     * @param n B卡片数量
     * @param k C卡片数量
     * @return 排列总数
     */
    public static BigInteger Divisible(int m, int n, int k) {
        BigInteger result = new BigInteger("1");
        BigInteger num1 = new BigInteger("1");
        BigInteger num2 = new BigInteger("1");
        BigInteger num3 = new BigInteger("1");
        //获得(m + n + k)的阶乘
        for (int i = 1; i <= m + n + k; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }
        //获得m的阶乘
        for (int i = 1; i <= m; i++) {
            num1 = num1.multiply(new BigInteger(i + ""));
        }
        //获得n的阶乘
        for (int i = 1; i <= n; i++) {
            num2 = num2.multiply(new BigInteger(i + ""));
        }
        //获得k的阶乘
        for (int i = 1; i <= k; i++) {
            num3 = num3.multiply(new BigInteger(i + ""));
        }
        //获得并返回（m + n + k)! / (m! * n! * k!)的结果
        return result.divide(num1.multiply(num2.multiply(num3)));
    }

}