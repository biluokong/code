package 数据结构.数据的运算.排序.选择排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.改进的直接插入排序.selectSort;

/**
 * 直接选出最大(或最小)的元素放到最终的位置, 有哨站的
 */
public class 简单选择排序 {
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
            array[0] = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {  //如果当前元素比比较元素大，则更新最小数的储存的下标
                    array[0] = j;
                }
            }
            //如果一趟遍历比较后找出的最小值是在原位置，则不需交换；否则需要
            if (i != array[0]) {
                int temp = array[i];
                array[i] = array[array[0]];
                array[array[0]] = temp;
            }
        }

        selectSort(input, array);
    }
}
