package 数据结构.数据的运算.排序.基数排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.直接插入排序.selectSort;

/**
 * 又叫桶排序或箱排序
 */
public class 基数排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt();

        System.out.println("请输入" + n + "个数：");
        int[] array = new int[n];
        for (int i = 1; i < n; i++) {
            array[i] = input.nextInt();
        }

        sort(array);


        selectSort(input, array);
    }

    public static void sort(int[] array) {
        int[][] boxes = new int[10][array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = (array[i] % (int)Math.pow(10, (array[i] + "").length()));
            if (boxes[temp][j] != 0) {
                j++;
            } else {
                j = 0;
            }
            boxes[temp][j] = array[i];
        }
    }
}
