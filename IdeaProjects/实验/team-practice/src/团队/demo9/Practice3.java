package 团队.demo9;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice3 {
    public static int lastStoneWeight(ArrayList<Integer> stones) {
        int sum = 0;
        for (Integer integer : stones)
            sum += integer;
        //把石头分成相同重量的两堆，即这最终两堆可以一起被粉碎
        int target = sum / 2;
        //dp数组表示：容量为j下最多能装下的石头重量为dp[j]
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.size(); i++) {
            for (int j = target; j >= stones.get(i); j--)
                dp[j] = Math.max(dp[j], dp[j - stones.get(i)] + stones.get(i));
        }
        //因为两堆相同重量（dp[target]）的石头会消掉，最终剩的就是最后一个剩下石头的重量
        return sum - dp[target] * 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>(), result = new ArrayList<>();
        do {
            nums.add(input.nextInt());
        } while (nums.get(nums.size() - 1) != -10000);
        nums.remove(nums.size() - 1);
        System.out.println(lastStoneWeight(nums));
    }
}
