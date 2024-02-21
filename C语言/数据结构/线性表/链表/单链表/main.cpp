#include "linkedlList.h"
#include "operate.cpp"

int main(int argc, char const *argv[])
{
    LinkList L;
    if (InitList(L)){
        ListHeadAdd(L, 3);
        ListTailAdd(L, 4);
        ListHeadAdd(L, 5);
        ListTailAdd(L, 6);
        ListInsert(L, 1, 10);
        ListDelete(L, 5);
        NodePriorInsert(ListIndexFind(L, 2), 12);
        NodeDelete(ListIndexFind(L, 4));
        ListPrint(L);
        cout << ListLength(L) << endl;
    }

    //LinkList L = TailInitList();
    DestoryLinkList(L);
    ListPrint(L);
    return 0;
}