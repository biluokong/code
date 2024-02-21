package algorithm;

import java.util.HashMap;

public class Test688 {
    public static void main(String[] args) {
        int n = Utils.getInt();
        int k = Utils.getInt();
        int row = Utils.getInt();
        int column = Utils.getInt();
        System.out.println(fun1(n, k, row, column));
    }

    private static final int[][] walks = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static double fun3(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return dfs(n, k, row, column, memo) / Math.pow(8, k);
    }

    // 不使用map，空间复杂度高一些
    private static double dfs(int n, int k, int i, int j, double[][][] memo) {
        if (i < 0 || j < 0 || i >= n || j >= n) return 0;
        if (k == 0) return 1;
        if (memo[i][j][k] != 0) return memo[i][j][k];
        double probability = 0;
        for (int[] walk : walks)
            probability += dfs(n, k - 1, i + walk[0], j + walk[1], memo);
        memo[i][j][k] = probability;
        return probability;
    }

    // 深度优先dfs（超时） + 记忆化（dfs时间复杂度：O(8^k)，加上记忆化搜索：O(n*n*k)）
    public static double fun2(int n, int k, int row, int column) {
        HashMap<String, Double> map = new HashMap<>();
        return dfs(n, k, row, column, map);
    }

    private static double dfs(int n, int k, int row, int column, HashMap<String, Double> map) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0;
        if (k == 0) return 1;
        // 记忆化
        String key = row + "-" + column + "-" + k;
        if (map.containsKey(key)) return map.get(key);
        double probability = 0;
        for (int[] walk : walks)
            probability += dfs(n, k - 1, row + walk[0], column + walk[1], map) / 8.0;
        map.put(key, probability);
        return probability;
    }

    // dp + 滚动更新（节省内存）
    public static double fun4(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j][0] = 1.0;
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j][step & 1] = 0;
                    for (int[] walk : walks) {
                        int ni = i + walk[0], nj = j + walk[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n)
                            dp[i][j][step & 1] += dp[ni][nj][(step - 1) & 1] / 8;
                    }
                }
            }
        }
        return dp[row][column][k & 1];
    }

    // 时间复杂度：O(k * n * n)，算出了所有位置为初始位置时，移动step步在棋盘上的概率
    public static double fun1(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) dp[step][i][j] = 1;
                    else {
                        for (int[] walk : walks) {
                            int ni = i + walk[0], nj = j + walk[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n)
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
