package 实验四数组;

import java.util.Scanner;

/**
 * 打印如下形式的杨辉三角形
 *                1
 *                1   1
 *                1   2   1
 *                1   3   3   1
 *                1   4   6   4   1
 *                1   5   10  10  5   1
 *    ........................
 *     输出前10行。
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要输出杨辉三角的行数：");
        int x = input.nextInt();    //根据键盘输入的整数确定杨辉三角的输出行数
        int[][] a = new int[x][x];  //创建二维数组来存放杨辉三角的元素，初始条件下，所有数据默认都为0
        a[0][0] = a[1][0] = a[1][1] = 1;    //第一行和第二行的三个数赋值为1

        //两层for循环求得每层杨辉三角形的数值
        for (int i = 2; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j == 0) {
                    a[i][j] = 1;    //给第一列的数据赋值为1
                } else {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];    //其它位置的数为它上一行左边和头上的两数之和
                }
            }
        }

        //遍历数组输出杨辉三角
        System.out.println("杨辉三角：");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (a[i][j] != 0) {
                    System.out.printf("%-4d", a[i][j]); //格式控制，使输出的每个数占四个字符位并左对齐
                }
            }
            System.out.println();   //每输出一层换一行
        }
    }
}
