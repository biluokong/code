#include "stack.h"
#include "operate.cpp"

int main(int argc, char const *argv[])
{
    LinkStack S = GetStack();
    int data = 0;
    Pop(S, data);
    Pop(S, data);
    Push(S, 100);
    print(S);
    cout << data << endl;
    return 0;
}
