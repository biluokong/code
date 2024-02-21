import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 本关任务：公司发了某商店的购物券1000元，限定只能购买店中的m种商品。每种商品的价格分别为：（数据均为整数）
 * n1,n2,…;要求程序列出所有的正好能消费完该购物券的不同购物方法。
 * 程序输入：
 *      第一行是一个整数m，代表可购买的商品的种类数。
 *      接下来是m个整数，每个1行，分别代表着m种商品的单价。
 * 程序输出：
 *      第一行是一个整数，表示共有多少种方案
 *      第二行开始，每种方案占1行，表示每种商品购买的数量，中间用空格分隔。
 * 测试输入： 2          预期输出： 2
            200                  2 2
            300                  5 0

 * 测试输入： 2          预期输出： 1
            500                  2 0
            800
 */
public class 购物方案 {
    public static int[][] values;
    public static List<Integer> temp = new ArrayList<>();
    public static int count = 0;
    public static String plan = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        values = new int[m][2];
        for (int i = 0; i < values.length; i++) {
            values[i][0] = sc.nextInt();
            values[i][1] = 1000 / values[i][0];
        }
        sc.close();
        int sum = 0;
        dfs(sum, 0);
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.print(count + "\n" + plan);
        }
    }

    public static void dfs(int sum, int step) {
        if (step == values.length) {
            if (sum == 1000) {
                for (int i = 0; i < temp.size(); i++) {
                    plan += temp.get(i) + " ";
                }
                plan += "\n";
                count++;
            }
            return;
        } else {
            for (int i = 0; i <= values[step][1]; i++) {
                sum += values[step][0] * i;
                temp.add(i);
                dfs(sum, step + 1);
                sum -= values[step][0] * i;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
