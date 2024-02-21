package 实验四数组;

import java.util.Scanner;

/**
 * 输出一个保存在二维数组中3*3的矩阵，并求对角线元素之和
 */
public class Test02 {
    public static void main(String[] args) {
        int[][] a = new int[3][3];  //创建一个3*3的二维数组
        Scanner input = new Scanner(System.in);     //创建扫描仪
        System.out.println("请输入9个整数：");
        for (int i = 0; i < 3; i++) {   //将从键盘获取的值存放到数组中
            for (int j = 0; j < 3; j++) {
                a[i][j] = input.nextInt();
            }
        }
        input.close();  //关闭扫描仪

        //遍历数组
        System.out.println("矩阵：");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        //获得对角线元素之二和
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    sum += a[i][j];
                }
            }
        }

        //输入对角线元素的和
        System.out.println("对角线的和为" + sum);
    }
}
