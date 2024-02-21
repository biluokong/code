package algorithm;

import java.util.Scanner;

public class Test200 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    }

    public static int numIslands(char[][] grid) {
        // 方法一：dfs
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
        // 方法二：并查集
    }

    // 并查集方法
    public static int find(int[] collection, int index) {
        while (collection[index] >= 1) index = collection[index];
        return index;
    }

    public static void union(int[] collection, int index1, int index2) {
        int root1 = find(collection, index1);
        int root2 = find(collection, index2);
        if (root1 == root2) return;
        collection[root2] = root1;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);    //往上
        dfs(grid, i - 1, j);    //往下
        dfs(grid, i, j - 1);    //往左
        dfs(grid, i, j + 1);    //往右
    }
}
