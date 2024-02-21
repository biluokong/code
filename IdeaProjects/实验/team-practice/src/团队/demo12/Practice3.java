package 团队.demo12;

import java.util.Scanner;

public class Practice3 {
    private static void printZ(int[][] ma) {
        int rows = ma.length;//总行数
        int cols = ma[0].length;//总列数
        int curRow = 0;//当前行
        int curCol = 0;//当前列
        boolean flag = true;//标志位 标记斜向走方向：true左下走到右上，false右上走到左下
        while (curRow < rows && curCol < cols) {
            System.out.print(ma[curRow][curCol] + " ");
            if (curRow == rows - 1 && curCol == cols - 1) {//防止死循环无限输出最后一位
                break;
            }
            //斜向走，从左下到右上
            if (flag) {
                if (curRow > 0 && curCol < cols - 1) {//斜着走 左下到右上
                    curRow--;
                    curCol++;
                } else if (curRow == 0 && curCol < cols - 1) {//水平向右走
                    curCol++;
                    flag = !flag;//斜向走变换成 右上到左下
                } else if (curCol == cols - 1 && curRow < rows - 1) {//竖直向下走
                    curRow++;
                    flag = !flag;//斜向走变换成 右上到左下
                }
            } else {
                //斜向走，从右上到左下
                if (curRow < rows - 1 && curCol > 0) {//斜向走 从右上到左下
                    curRow++;
                    curCol--;
                } else if (curRow == rows - 1 && curCol < cols - 1) {//水平向右走
                    curCol++;
                    flag = !flag;//斜向走变换成 左下到右上
                } else if (curCol == 0 && curRow < rows - 1) {//竖直向下走
                    curRow++;
                    flag = !flag;//斜向走变换成 左下到右上
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入矩阵的行和列：");
        int n = input.nextInt(), m = input.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                nums[i][j] = input.nextInt();
        }
        printZ(nums);
    }
}
