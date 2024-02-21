package 数据结构.数据的运算.排序.交换排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.改进的直接插入排序.selectSort;

/**
 * 基于简单的交换思想，设立一个哨兵
 * 是一种自然排序，越有序，交换次数越少
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt() + 1;

        System.out.println("请输入" + (n - 1) + "个数：");
        int[] array = new int[n];
        for (int i = 1; i < n; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[0] = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = array[0];
                }
            }
        }

        selectSort(input, array);
    }
}
