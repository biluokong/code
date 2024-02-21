#include "DLinkedList.h"
#include "operate.cpp"

int main(int argc, char const *argv[])
{
    DLinkList L;
    if (InitDList(L)) {
        DNode s1, s2;
        s1.data = 4;
        s2.data = 10;
        InsertNextDNode(L, &s1);
        InsertPriorDNode(&s1, &s2);
        print(L);
        print(GetDList());
    }
    return 0;
}
