#include "queue.h"
#include "operate3.cpp"

int main(int argc, char const *argv[])
{
    Queue Q = GetQueue();
    int data;
    DeQueue(Q, data);
    DeQueue(Q, data);
    DeQueue(Q, data);
    EnQueue(Q, 22);
    EnQueue(Q, 33);
    EnQueue(Q, 44);
    print(Q);
    GetHead(Q, data);
    cout << "\n" << data;
    return 0;
}
