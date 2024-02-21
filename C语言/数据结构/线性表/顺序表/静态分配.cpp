#include <stdio.h>
#define MaxSize 10  //定义最大长度
typedef struct
{
    int data[MaxSize];
    int length;
}sqList;

void InitList(sqList &L){
    for (int i = 0; i < MaxSize; i++)
    {
        L.data[i] = 0;
    }
    L.length = 0;
}

int main() {
    sqList L;
    InitList(L);
    for (int i = 0; i < MaxSize; i++)
    {
        printf("%d ", L.data[i]);
    }
    return 0;
}