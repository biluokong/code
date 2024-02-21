package 数据结构.数据的运算.排序.归并排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.直接插入排序.selectSort;

/**
 * 在内部排序时，通常采用二路归并排序
 */
public class 二路归并排序 {
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

    private static void sort(int[] arr) {

    }
}
