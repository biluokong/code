#include "stack.h"

//初始化栈
void InitStack(Stack &S) {
    S.top = -1;
}

//判断栈是否为空
bool StackEmpty(Stack S){
    return (S.top == -1);
}

//入/压栈操作
bool Push(Stack &S, int data) {
    if (S.top == MaxSize - 1)
        return false;
    S.data[++S.top] = data;
    return true;
}

//出/弹栈操作
bool Pop(Stack &S, int &data) {
    if (S.top == -1)
        return false;
    data = S.data[S.top--];
    return true;
}

//获得栈顶元素
bool GetTop(Stack S, int &data) {
    if (S.top == -1)
        return false;
    data = S.data[S.top];
    return true;
}

void print(Stack S) {
    int length = S.top;
    for (int i = 0; i <= length; i++)
        cout << S.data[i] << " ";
}