#include "sort.h"

//简单选择排序(可带哨兵)。空间复杂度O(1)；时间复杂度O(n²)；
void SelectSort(int nums[], int n) {
    int min = 0, temp = 0;
    for (int i = 0; i < n - 1; i++) {
        min = i;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] < nums[min])
                min = j;
        }
        if (min != i)
            temp = nums[min], nums[min] = nums[i], nums[i] = temp;
    }
}

//堆排序，空间复杂度O(1)；不稳定
//时间复杂度：将整颗树调整为大根堆O(n)，再排序(n㏒₂n)，总O(n㏒₂n)
//每次下坠调整都要对比关键字1/2次（判断越界不算），上升调整1次

//对指定结点调整为大根堆的操作，每次下坠都要对比关键字1/2次（判断越界不算）
void MaxHeapAdjust(int nums[], int i, int len) {
    int temp = nums[i];
    for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {  //初始j保存temp结点的左孩子索引
        //如果temp结点有右孩子且右孩子大于左孩子，让j保存右孩子的索引
        if (j < len - 1 && nums[j] < nums[j + 1])
            j++;
        if (temp >= nums[j])    //如果temp结点大于等于它的左右孩子，就退出此层循环
            break;
        else {    //如果temp结点的左孩子或右孩子大于它，就调整位置
            nums[i] = nums[j];
            i = j;  //接着下次循环判断，比较temp结点与它新的左后孩子的大小
        }
    }
    nums[i] = temp; //确定好了temp结点的最终位置后，就进行调整
}


//建立大根堆(0<=i<=n时，i<=(n-1)/2为分支结点，2i+1为左孩子，2i+2为右孩子)
void BuildMaxHeap(int nums[], int len) {
    int temp = 0;
    for (int i = (len - 1) / 2; i >= 0; i--)
        MaxHeapAdjust(nums, i, len);
}

//根据获得的大根堆进行排序。时间复杂度：O(4n+(n-1)*2(h-1))=O(n㏒₂n)
void MaxHeapSort(int nums[], int len) {
    BuildMaxHeap(nums, len);    //对比次数<=4n
    int temp = 0;
    for (int i = len - 1; i > 0; i--) { //n-1趟，一趟对比<=2(h-1)
        temp = nums[i], nums[i] = nums[0], nums[0] = temp;
        MaxHeapAdjust(nums, 0, i);
    }
}

//建立小根堆和排序
void MinHeapAdjust(int nums[], int i, int len) {
    int temp = nums[i];
    for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {  //初始j保存temp结点的左孩子索引
        //如果temp结点有右孩子且右孩子小于左孩子，让j保存右孩子的索引
        if (j < len - 1 && nums[j] > nums[j + 1])
            j++;
        if (temp <= nums[j])    //如果temp结点小于等于它的左右孩子，就退出此层循环
            break;
        else {    //如果temp结点的左孩子或右孩子小于它，就调整位置
            nums[i] = nums[j];
            i = j;  //接着下次循环判断，比较temp结点与它新的左后孩子的大小
        }
    }
    nums[i] = temp; //确定好了temp结点的最终位置后，就进行调整
}

void BuildMinHeap(int nums[], int len) {
    int temp = 0;
    for (int i = (len - 1) / 2; i >= 0; i--)
        MinHeapAdjust(nums, i, len);
}

void MinHeapSort(int nums[], int len) {
    BuildMinHeap(nums, len);    //对比次数<=4n
    int temp = 0;
    for (int i = len - 1; i > 0; i--) { //n-1趟，一趟对比<=2(h-1)
        temp = nums[i], nums[i] = nums[0], nums[0] = temp;
        MinHeapAdjust(nums, 0, i);
    }
}

//对大根堆进行删除操作
void Delete_MaxHeap(int nums[], int i, int len) {
    nums[i] = nums[len - 1], nums[len - 1] = -1;    //把最后的元素放到删除元素位置
    for (int j = i; j > 0; j = (j - 1) / 2) //问题：当i=0时，会跳过调整
        MaxHeapAdjust(nums, j, len - 1);
    if (i == 0)
        MaxHeapAdjust(nums, i, len - 1);    //解决当i=0时，上面的循环跳过调整的问题
}

//对大根堆添加元素（末尾添加）
void Add_MaxHeap(int nums[], int e, int len) {
    nums[len] = e;
    for (int i = (len - 1) / 2; i > 0; i = (i - 1) / 2)
        MaxHeapAdjust(nums, i, len + 1);
    MaxHeapAdjust(nums, 0, len + 1);
}

//带哨兵的大根堆排序
void MaxHeapAdjust2(int nums[], int i, int len) {
    nums[0] = nums[i];
    for (int j = 2 * i; j <= len; j *= 2) {
        if (j < len&& nums[j] < nums[j + 1])
            j++;
        if (nums[0] >= nums[j])
            break;
        else {
            nums[i] = nums[j];
            i = j;
        }
    }
    nums[i] = nums[0];
}
//建立大根堆(带哨兵)(1<=i<=n时，i<=n/2为分支结点，2i为左孩子，2i+1为右孩子)
void BuildMaxHeap2(int nums[], int len) {
    for (int i = len / 2; i > 0; i--)
        MaxHeapAdjust2(nums, i, len);
}
//根据获得的大根堆进行排序(带哨兵)
void MaxHeapSort2(int nums[], int len) {
    BuildMaxHeap2(nums, len);
    int temp = 0;
    for (int i = len - 1; i > 1; i--) {
        temp = nums[i], nums[i] = nums[1], nums[1] = temp;
        MaxHeapAdjust2(nums, 1, i - 1);
    }
}