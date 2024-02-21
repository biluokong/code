package algorithm;

public class Test64 {
    public static void main(String[] args) {
        int[][] nums = Utils.getInputToTwoIntArray();
        System.out.println(fun2(nums));
    }

    private static int fun3(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    private static int fun2(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 1; i < rows; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int j = 1; j < columns; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < columns; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        return dp[rows - 1][columns - 1];
    }

    private static int fun1(int[][] grid) {
        return recursion(0, 0, grid);
    }

    private static int recursion(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        else if (i == grid.length - 1)
            return grid[i][j] + recursion(i, j + 1, grid);
        else if (j == grid[0].length - 1)
            return grid[i][j] + recursion(i + 1, j, grid);
        return Math.min(grid[i][j] + recursion(i, j + 1, grid), grid[i][j] + recursion(i + 1, j, grid));
    }
}