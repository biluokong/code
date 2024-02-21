#include "dynamicAssignment.h"
#include "Operate.cpp"

int main(int argc, char const *argv[])
{   
    SeqList L;
    InitList(L);
    IncreaseSize(L, 5 ); //扩容
    ListAdds(L, 5, 1, 2, 3, 4, 5); //用可变参数宏添加数据
    ListInsert(L, 3, 10);
    // ListInsert(L, 2, 30);
    printf("%d %d\n", GetElem(L, 3), LocateElem(L, 4));
    for (int i = 0; i < L.length; i++)
        cout << L.data[i] << " ";
    printf("\n%d", L.MaxSize);

    return 0;
}