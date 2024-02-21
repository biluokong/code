#include "sort.h"

//(简单交换排序)冒泡排序(可带哨兵)。空间复杂度O(1)；时间复杂度：最好/坏和平均O(n²)；稳定
void BubbleSort(int nums[], int n) {
    int temp = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = n - 1; j > i; j--) {
            if (nums[j] < nums[j - 1]) 
                temp = nums[j], nums[j] = nums[j - 1], nums[j - 1] = temp;
        }
    }
}

//冒泡排序（改进，一轮循环后未交换过一个元素，说明已经有序，不用再排序）
//时间复杂度：最好O(n-1)，最坏O(n(n-1)/2)
void BubbleSort2(int nums[], int n) {
    int temp = 0, flag = true;
    for (int i = 0; i < n - 1; i++) {
        for (int j = n - 1; j > i; j--) {
            flag = true;
            if (nums[j] < nums[j - 1]) {
                temp = nums[j], nums[j] = nums[j - 1], nums[j - 1] = temp;
                flag = false;
            }
        }
        if (flag)
            return;
    }
}

//双向冒泡排序
void BubbleSort3(int nums[], int n) {
    int temp = 0, flag = true;
    for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
        for (int k = n - 1; k > i; k--) {
            flag = true;
            if (nums[k] < nums[k - 1]) {
                temp = nums[k], nums[k] = nums[k - 1], nums[k - 1] = temp;
                flag = false;
            }
        }
        if (flag)
            return;
        for (int k = i + 1; k < j; k++) {
            if (nums[k] > nums[k + 1])
                temp = nums[k], nums[k] = nums[k + 1], nums[k + 1] = temp;
        }
    }
}

int Partition(int nums[], int low, int high) {
    int location = nums[low];
    while (low < high) {
        while (low < high && nums[high] >= location)
            high--;
        nums[low] = nums[high];
        while (low < high && nums[low] <= location)
            low++;
        nums[high] = nums[low];
    }
    nums[low] = location;
    return low;
}

//快速排序(二叉树)。空间复杂度O(递归层数)；不稳定（快排的平均性能最优）
//时间复杂度O(n* 递归层数)，最好O(n㏒₂n)，最坏O(n²)，平均O(n㏒₂n)；
//优化：尽量选择可以把数据中分的枢轴元素（二叉树的高度更低）
//法1：选头、中、尾三个位置的元素，比较好选中间值作为枢轴元素
//法2：随机选一个元素作为枢轴元素
void QuickSort(int nums[], int low, int high) {
    if (low < high) {
        int location = Partition(nums, low, high);
        QuickSort(nums, low, location - 1);
        QuickSort(nums, location + 1, high);
    }
}

