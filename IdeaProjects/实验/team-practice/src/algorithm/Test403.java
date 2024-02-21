package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Test403 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();
        System.out.println(fun3(nums));
    }

    //动态规划，时间复杂度：O(n²)
    private static boolean fun3(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++)
            if (stones[i] - stones[i - 1] > i)
                return false;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) break;
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) return true;
            }
        }
        return false;
    }

    //dfs 时间复杂度：O(n²log n)
    private static Boolean[][] rec;
    private static boolean fun2(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private static boolean dfs(int[] stones, int i, int k) {
        if (i == stones.length - 1)
            return true;
        if (rec[i][k] != null)
            return rec[i][k];
        for (int j = k - 1; j <= k + 1; j++) {
            if (j > 0) {
                int m = Arrays.binarySearch(stones, i + 1, stones.length, j + stones[i]);
                if (m >= 0 && dfs(stones, m, j))
                    return rec[i][k] = true;
            }
        }
        return rec[i][k] = false;
    }

    public static boolean fun1Modify(int[] stones) {
        // 因为：i >= m(跳跃次数)，k <= m  所以：k <= i
        for (int i = 1; i < stones.length; i++)
            if (stones[i] - stones[i - 1] > i)
                return false;
        //去掉重复的子树，防止超时
        HashSet<Integer> set = new HashSet<>();
        return dfs(stones, 0, 0, set);
    }

    private static boolean dfs(int[] stones, int index, int k, HashSet<Integer> set) {
        int key = index * 1000 + k;
        if (set.contains(key)) return false;
        else set.add(key);
        for (int i = index + 1; i < stones.length; i++) {
            int distance = stones[i] - stones[index];
            if (distance >= k - 1 && distance <= k + 1 && dfs(stones, i, distance, set))
                return true;
            if (distance > k + 1)
                break;
        }
        return index == stones.length - 1;
    }

    //不行，超时了，内存溢出
    private static boolean fun1(int[] stones) {
        if (stones.length < 2 || stones[1] != 1)
            return false;
        LinkedList<int[]> queue = new LinkedList<>();
        int[] entry = new int[]{1, 1};
        queue.push(entry);
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            if (pop[0] == stones.length - 1)
                return true;
            for (int i = pop[0] + 1; i < stones.length; i++) {
                int start = stones[pop[0]] + pop[1] - 1;
                int end = stones[pop[0]] + pop[1] + 1;
                if (stones[i] >= start && stones[i] <= end)
                    queue.offer(new int[]{i, stones[i] - stones[pop[0]]});
            }
        }
        return false;
    }
}
