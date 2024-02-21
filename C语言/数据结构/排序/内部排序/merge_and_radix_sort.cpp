#include "sort.h"

//归并排序(2路)
//合并。时间复杂度O(n)
void Merge(int nums[], int low, int mid, int high) {
    int i, j, k, * temp = (int*)malloc((high - low + 1) * sizeof(int));
    for (k = low; k <= high; k++)   //low-mid 和 mid+1-high 两个部分各自有序
        temp[k] = nums[k];  //先把数据放到临时空间里
    for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
        if (temp[i] <= temp[j]) //小的放回前面（等于号可以保持稳定性）
            nums[k] = temp[i++];
        else
            nums[k] = temp[j++];
    }
    while (i <= mid)    //如果剩下数据，把剩下的都放回去
        nums[k++] = temp[i++];
    while (j <= high)
        nums[k++] = temp[j++];
}

//归并排序；空间复杂度O(n)；时间复杂度O(n㏒₂n)（趟数为h-1=┍㏒₂n┐）；稳定
void MergeSort(int nums[], int low, int high) {
    if (low < high) {
        int mid = low + (high - low) / 2;   //从中间划分
        MergeSort(nums, low, mid);
        MergeSort(nums, mid + 1, high);
        Merge(nums, low, mid, high);
    }
}