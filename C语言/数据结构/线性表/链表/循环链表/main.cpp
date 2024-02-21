#include "circularLinkedList.h"
#include "operate.cpp"

int main()
{
    CLinkList L = GetCList();
    LNode p;
    p.data = 20;
    insertNextNode(L, &p);
    print(L);
    return 0;
}