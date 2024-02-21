#include<SStack.h>

//初始化共享栈
bool InitSStack(SStack &S) {
    S.top1 = MaxSize;
    S.top2 = -1;
}

//出栈
bool Push(SStack &S, int data) {
    if (S.top2 + 1 == S.top1)
        return false;
}