#include "dynamicAssignment.h"

//顺序表的初始化操作
void InitList(SeqList &L) {
    L.data = (int *)malloc(InitSize * sizeof(int));
    for (int i = 0; i < InitSize; i++)
        L.data[i] = 0;
    L.length = 0;
    L.MaxSize = InitSize;
}

//顺序表的扩容操作
void IncreaseSize(SeqList &L, int len) {
    int *p = L.data;
    //重新申请内存，也可以用realloc
    L.data = (int *)malloc((L.MaxSize + len) * sizeof(int));    
    for (int i = 0; i < L.length; i++)
        L.data[i] = p[i];
    L.MaxSize = L.MaxSize + len;
    free(p);    //释放原来顺序表的内存
}

//顺序表的插入操作，根据插入是否成功来输出相应的提示信息或者返回一个bool值
void ListInsert(SeqList &L, int index, int ele) {
    if (index < 0 || index > L.length) {
        printf("插入失败，插入的位置非法！");
        return;
    }
    if (L.length == L.MaxSize) {
        printf("插入失败，表中容量已满！");
        return;
    }
    for (int i = L.length; i > index; i--)
        L.data[i] = L.data[i - 1];
    L.data[index] = ele;
    L.length++;
    printf("插入成功！");
}

//顺序表的删除操作
void ListDelete(SeqList &L, int index, int &ele) {
    if (index < 0 || index >= L.length) {
        printf("删除失败，删除的位置非法！");
        return;
    }
    ele = L.data[index];
    for (int i = index; i < L.length; i++)
        L.data[i] = L.data[i + 1];
    L.length--;
    printf("删除成功");
}

//顺序表的查找操作：按位查找
int GetElem(const SeqList &L, int index){
    return L.data[index];
}

//顺序表的查找操作：按值查找
int LocateElem(SeqList L, int elem) {
    for (int i = 0; i < L.length; i++) {
        if (L.data[i] == elem)
            return i;
    }
    return -1;
}

bool ListAdds(SeqList &L, int count, ...) {
    if (count < 1 || count > L.MaxSize - L.length)
        return false;
    va_list ap;
    va_start(ap, count);
    for (int i = 0; i < count; i++)
        L.data[L.length + i] = va_arg(ap, int);
    va_end(ap);
    L.length += count;
    return true;
}

//顺序表的添加元素操作
bool ListAdd(SeqList &L, int elem) {
    if (L.length == L.MaxSize)
        return false;
    L.data[L.length++] = elem;
    return true;
}