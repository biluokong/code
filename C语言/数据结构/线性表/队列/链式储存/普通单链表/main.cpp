#include "queue.h"
#include "operate.cpp"

int main(int argc, char const *argv[])
{
    LinkQueue Q = GetLinkQueue();
    int data = 0;
    DeQueue(Q, data);
    DeQueue(Q, data);
    EnQueue(Q, 100);
    print(Q);
    cout << data << endl;
    return 0;
}
