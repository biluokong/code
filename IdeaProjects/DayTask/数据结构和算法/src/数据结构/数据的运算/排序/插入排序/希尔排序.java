package 数据结构.数据的运算.排序.插入排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.改进的直接插入排序.selectSort;

/**
 * 缩小增量插入排序，需要一个增量序列
 * 最后一趟排序的元素下标一定是1的倍数加1（从0倍开始，因为有哨兵）
 *
 * 1、有Hibbard增量序列：D(k) = 2^k-1——相邻元素互质
 *      最坏情况：T(worst) = O(n^(3/2))
 *      猜想：T(avg) = O(n(5/4))
 *
 * 2、Sedgewick增量序列：{1,5,19,41,109,……} ——9*4^i - 9*2^i 或 4^i - 3*2^i + 1
 *      T(worst) = O(n^(4/3))
 *      T(avg) = O(n^(7/6))
 */
public class 希尔排序 { //采用Hibbard序列
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt() + 1;

        int[] array = new int[n];
        System.out.println("请输入" + (n - 1) + "个数：");
        for (int i = 1; i < n; i++) {
            array[i] = input.nextInt();
        }

        //得到Hibbard增量序列
        int[] hibbard = new int[10];
        for (int i = 0; i < hibbard.length; i++) {
            hibbard[i] = (int) Math.pow(2, i + 1) - 1;
        }

        //用Hibbard增量序列进行3趟插入排序
        for (int i = 0; i < 3; i++) {
            sort(array, hibbard[i]);
        }

        selectSort(input, array);
    }

    /**
     * 对数组中所有小下标为b的倍数加1的元素进行插入排序（从0倍开始）
     * @param arr
     * @param b
     */
    public static void sort(int[] arr, int b) {
        int j = 0;
        for (int i = 1; i < arr.length; i += b) {
            arr[0] = arr[i];
            for (j = i - b; j > 0 && arr[0] < arr[j]; j -= b) {
                arr[j + b] = arr[j];
            }
            arr[j + b] = arr[0];
        }
    }
}
