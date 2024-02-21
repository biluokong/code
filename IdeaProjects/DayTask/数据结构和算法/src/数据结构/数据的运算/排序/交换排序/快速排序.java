package 数据结构.数据的运算.排序.交换排序;

import java.util.Scanner;

import static 数据结构.数据的运算.排序.插入排序.改进的直接插入排序.selectSort;

/**
 * 用了递归方式，会开辟较大的栈空间
 * 基本思想：选一个数为中间数，所有元素与之比较，较大的放到其前面，较小的放在其后面
 *          将序列分成两个子表，分别对两个子表也较小上述操作
 *          如此重复，直至每个子表只剩一个元素
 */
public class 快速排序 {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入您想要排序的数的个数：");
            int n = input.nextInt() + 1;

            System.out.println("请输入" + (n - 1) + "个数：");
            int[] array = new int[n];
            for (int i = 1; i < n; i++) {
                array[i] = input.nextInt();
            }

            qSort(array, 1, array.length - 1);  //调用快速排序方法

            selectSort(input, array);
    }

    /**
     * 快速排序，递归调用
     * @param arr
     * @param low
     * @param high
     */
    public static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotloc = sort(arr, low, high);
            qSort(arr, low, pivotloc - 1);
            qSort(arr, pivotloc + 1, high);
        }
    }

    public static int sort(int[] arr, int low, int high) {
        arr[0] = arr[low];
        while (low < high) {    //只有还有元素没有比较
            //如果high下标的元素大于中间数，则high--，继续比较前一位；若小于，则放到前面low下标位置处
            while (low < high && arr[high] >= arr[0]) {
                high--;
            }
            arr[low] = arr[high];
            //如果low下标的元素小于中间数，则low--，继续比较后面的元素；如大于，则放到后面high下标位置处
            while (low < high && arr[low] <= arr[0]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = arr[0];
        return low;
    }
}
