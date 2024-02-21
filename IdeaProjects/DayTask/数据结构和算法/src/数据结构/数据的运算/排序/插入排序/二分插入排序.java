package 数据结构.数据的运算.排序.插入排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.改进的直接插入排序.selectSort;

/**
 * 二分法定位插入位置
 */
public class 二分插入排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt() + 1;

        int[] array = new int[n];
        System.out.println("请输入" + (n - 1) + "个数：");
        for (int i = 1; i < n; i++) {
            array[i] = input.nextInt();
        }
        
        for (int i = 2; i < array.length; i++) {
            array[0] = array[i];
            int low = 1, high = i - 1;
            while (low <= high) {   //二分法寻找新牌插入位置，与前面已排好序的牌比较
                int mid = (high - low) / 2 + low;
                if (array[0] < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //找到新牌插入位置后，让此位置后(包括此位置)的手牌往后移一位
            for (int j = i - 1; j >= high + 1; j--) {
                array[j + 1] = array[j];
            }
            array[high + 1] = array[0]; //将新牌放入此位置
        }

        selectSort(input, array);
    }
}
