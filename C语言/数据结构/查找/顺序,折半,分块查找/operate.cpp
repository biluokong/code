#include "search.h"

//顺序查找（无哨兵），查找失败返回-1。时间复杂度O(n)，成功ASL=(n+1)/2，失败ASL=n+1
int Search_Seq(SSTable ST, ElemType key) {
    int i = 0;
    for (i = 0; i < ST.TableLen && ST.elem[i] != key; i++);
    return i == ST.TableLen ? -1 : i;
}
//顺序查找（有哨兵），查找失败返回0；可以减少判断次数（无需判断是否越界）
//优化：
//1、表有序：当关键字大于 / 小于目标关键字时，直接查找失败（查找判定树，查找失败的ASL更小）
//2、关键字被查概率不同：按被查概率降序排列（查找成功的ASL更小）
int Search_Seq2(SSTable ST, ElemType key) {
    ST.elem[0] = key;
    ST.TableLen--;  //或者提前给好长度，方便起见，这里改长度
    int i = 0;
    for (i = ST.TableLen; ST.elem[i] != key; i--);
    return i;
}

//折半/二分查找，仅适用于有序顺序表（有特殊方法不需有序）
//折半查找判定树：右子树结点个数-左子树结点个数= 0或1，树高h=┌㏒₂(n+1)┐，失败结点：n+1个
//成功ASL<=h，所以时间复杂度O(㏒₂n)；失败ASL<=h
int Binary_Search(SSTable L, ElemType key) {
    int low = 0, high = L.TableLen - 1, mid = 0;
    while (low <= high) {
        mid = low + (high - low) / 2;
        if (L.elem[mid] == key)
            return mid;
        else if (L.elem[mid] > key)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}

//折半查找的递归形式
int BSR(SSTable &L, ElemType key, int low, int high) {
    if (low > high)
        return -1;
    int mid = low + (high - low) / 2;
    if (L.elem[mid] == key)
        return mid;
    else if (L.elem[mid] > key)
        return BSR(L, key, low, mid - 1);
    else
        return BSR(L, key, mid + 1, high);
}
int Binary_Search_R(SSTable L, ElemType key) {
    return BSR(L, key, 0, L.TableLen - 1);
}

//分块/索引顺序查找，过程：在索引表中确定待查记录的分块(可顺序、折半法确定)，再在块内顺序查找
//对均匀划分为b块，每块s个元素的查找表，(顺序查找)索引查找ASL=(b+1)/2，块内查找ASL=(s+1)/2
//(n=sb)总ASl=(b+1)/2 + (s+1)/2 = (s²+2s+n)/2s，当 s=根号n 时，ASLmin = 根号n + 1
//(折半查找)总ASL=┌㏒₂(b+1)┐+(s+1)/2