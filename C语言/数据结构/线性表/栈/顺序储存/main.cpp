#include "stack.h"
#include "operate.cpp"

int main(int argc, char const *argv[])
{
    Stack S;
    InitStack(S);
    int data;
    cout << Pop(S, data) << endl;
    Push(S, 3);
    Push(S, 23);
    Push(S, 312);
    Push(S, 1);
    Push(S, 2);
    Push(S, 3);
    Push(S, 4);
    Push(S, 5);
    Push(S, 7);
    Push(S, 0);
    Push(S, 0);
    print(S);
    return 0;
}
