package sort;

import java.util.HashMap;

public class Sort {
    private static int temp;
    public static void main(String[] args) {
        int[] arr = {3, 1, 34, 133, 5, 0, 12, 1, 0, 1341, 66};
        HashMap<Integer, Integer>[] list = new HashMap[2];
        System.out.println(list[0]);
        System.out.println(list[1]);
        //1、交换排序
        //（1）交换排序法
        //System.out.println("交换排序法：" + display(exchangeSort(arr)));

        //（2）双向冒泡排序法

        //（2）冒泡排序法
        //System.out.println("冒泡排序法：" + display(bubbleSort(arr)));

        //（3）改进的冒泡排序法
        //System.out.println("改进的冒泡排序法：" + display(improvedBubbleSort(arr)));

        //（4）快速排序法
        //System.out.println("快速排序法：" + display(quickSort(arr, 0, arr.length - 1)));

        //2、插入排序
        //（1）插入排序法
        //System.out.println("插入排序法：" + display(insertionSort(arr)));

        //（2）二分插入排序法
        //System.out.println("二分插入排序法：" + display(mergeSort(arr)));

        //（3）希尔排序
        //System.out.println("希尔排序法：" + display(hillSort(arr, 3)));

        //选择排序法
        //System.out.println("选择排序法：" + display(selectionSort(arr)));
    }

    /**
     * 归并排序
     */
    public static int[] mergeSort(int[] a, int left, int right) {
        return a;
    }

    /**
     * 选择排序法
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }

    /**
     * 希尔排序法
     */
    public static int[] hillSort(int[] arr, int n) {
        for (int i = n; i > 0; i--) {
            sort(arr, (int) Math.pow(2, i) - 1);
        }
        return arr;
    }

    public static void sort(int[] a, int step) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - step;
            for (; j >= 0 && temp < a[j]; j -= step) {
                a[j + step] = a[j];
            }
            a[j + step] = temp;
        }
    }

    /**
     * 二分插入排序法
     */
    public static int[] binaryInsertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int low = 0, high = i - 1;
            int temp = a[i];
            while (low <= high) {
                int mid =low + (high - low) / 2;
                if (temp < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= high + 1; j--) {
                a[j + 1] = a[j];
            }
            a[high + 1] = temp;
        }
        return a;
    }

    /**
     * 插入排序法
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            if (j + 1 != i) {
                arr[j + 1] = temp;
            }
        }
        return arr;
    }

    /**
     * 快速排序法
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


    /**
     * 改进的冒泡排序法：
     * 若一趟遍历后一次交换都没有发生，说明剩下的元素是有序的，不必再去比较了。
     * 可以设立一个标志进行来判断是否发生交换
     */
    public static int[] improvedBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
        return arr;
    }

    /**
     * 冒泡排序法
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 普通地交换排序法
     */
    public static int[] exchangeSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static StringBuilder display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + " ");
        }
        return sb;
    }
}
