#include "sort.h"

//普通插入排序。空间复杂度O(1)；时间复杂度：最好O(n)，最坏和平均O(n²)；稳定
void InsertSort(int nums[], int n) {
    int j = 0, temp = 0;
    for (int i = 1; i < n; i++) {
        temp = nums[i];
        for (j = i - 1; j >= 0 && nums[j] > temp; j--)  //为了稳定性，不能带等于
            nums[j + 1] = nums[j];
        nums[j + 1] = temp;
    }
}

//直接插入排序(带哨兵，不用判断越界)
void InsertSort2(int nums[], int n) {
    int j = 0;
    for (int i = 2; i < n; i++) {
        nums[0] = nums[i];
        for (j = i - 1; nums[j] > nums[0]; j--)
            nums[j + 1] = nums[j];
        nums[j + 1] = nums[0];
    }
}

//折半插入排序(可带哨兵)。空间复杂度O(1)；时间复杂度：最好O(n㏒₂n)，最坏和平均O(n²)；稳定
void Binary_InsertSort(int nums[], int n) {
    int low = 0, high = 0, mid = 0, temp = 0;
    for (int i = 1; i < n; i++) {
        temp = nums[i];
        low = 0, high = i - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > temp)   //为了稳定性，不能带等于
                high = mid - 1;
            else
                low = mid + 1;
        }
        for (int j = i - 1; j > high ; j--)
            nums[j + 1] = nums[j];
        nums[high + 1] = temp;
    }
}

//希尔排序(可带哨兵)。空间复杂度O(1)；时间复杂度：根据步长变化，最坏O(n²)；不稳定
void ShellSort(int nums[], int n) {
    int j = 0, temp = 0;
    for (int step = 5; step >= 1; step -= 2) {   //步长随意
        for (int i = 1; i < n; i++) {
            temp = nums[i];
            for (j = i - step; j >= 0 && nums[j] > temp; j -= step)
                nums[j + step] = nums[j];
            nums[j + step] = temp;
        }
    }
}