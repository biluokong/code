package 数据结构.数据的运算.排序.交换排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.改进的直接插入排序.selectSort;

/**
 * 改进的冒泡排序，当一趟遍历后，若一次交换都没发生，说明剩下的元素是有序的
 * 可定义一个标志，判断是否一趟遍历发生过交换
 */
public class 改进的冒泡排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt() + 1;

        System.out.println("请输入" + (n - 1) + "个数：");
        int[] array = new int[n];
        for (int i = 1; i < n; i++) {
            array[i] = input.nextInt();
        }

        boolean flag = true;   //定义一个判断是否发生交换的标志
        for (int i = 1; i < array.length - 1 && flag; i++) {
            flag = false;   //每次循环重新初始化标志
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[0] = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = array[0];
                    flag = true;    //方生了交换，置flag为true
                }
            }
        }

        selectSort(input, array);
    }
}
