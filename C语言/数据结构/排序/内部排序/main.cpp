#include "sort.h"
#include "insertion_sort.cpp"
#include "selection_sort.cpp"
#include "swap_sort.cpp"
#include "merge_and_radix_sort.cpp"

int main() {
    int nums[] = {2, 4, 0, 6, 7, 1, 0, 11};
    //InsertSort(nums, 8);
    //Binary_InsertSort(nums, 8);
    //ShellSort(nums, 8);
    //BubbleSort(nums, 8);
    //BubbleSort2(nums, 8);
    BubbleSort3(nums, 9);
    //QuickSort(nums, 0, 7);
    //MaxHeapSort(nums, 8);
    //MinHeapSort(nums, 8);
    //BuildMaxHeap(nums, 8);
    //MergeSort(nums, 0, 8 - 1);
    for (int i = 0; i < 8; i++)
        printf("%d ", nums[i]);
    //Delete_MaxHeap(nums, 0, 8);
    //Add_MaxHeap(nums, 7, 8);
    // printf("\n");
    // for (int i = 0; i < 9; i++)
    //     printf("%d ", nums[i]);
    return 0;
}