#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MaxSize 20
typedef int Type;

typedef struct SqStack{
    Type data[MaxSize]; //静态数组存放栈中数据
    int top;           //栈顶指针
} Stack;

//初始化栈
void InitStack(Stack &S) {
    S.top = -1;
}

//判断栈是否为空
bool StackEmpty(Stack S){
    return (S.top == -1);
}

//入/压栈操作
bool Push(Stack &S, Type data) {
    if (S.top == MaxSize - 1)
        return false;
    S.data[++S.top] = data;
    return true;
}

//出/弹栈操作
 Type Pop(Stack &S) {
    if (S.top == -1)
        return -1;
    return S.data[S.top--];
}

//获得栈顶元素
Type GetTop(Stack S) {
    if (S.top == -1)
        return -1;
    return S.data[S.top];
}

//清空栈
void ClearStack(Stack *S){
    (*S).top = -1;
}

void print(Stack S) {
    int length = S.top;
    for (int i = 0; i <= length; i++)
        printf("%d ", S.data[i]);
    printf("\n");
}