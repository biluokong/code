#include "main.h"

//获得一个新的空栈
CharStack GetCharStack(){
    CharStack S;
    S.top = -1;
    return S;
}
NumStack GetNumStack() {
    NumStack S;
    S.top = -1;
    return S;
}
DoubleStack GetDoubleStack(){
    DoubleStack S;
    S.top = -1;
    return S;
}

bool Push(CharStack &S, char ch){
    if (S.top == MaxSize - 1)
        return false;
    S.data[++S.top] = ch;
    return true;
}
bool Push(NumStack &S, int i) {
    if (S.top == MaxSize - 1)
        return false;
    S.data[++S.top] = i;
    return true;
}
bool Push(DoubleStack &S, double i){
    if (S.top == MaxSize - 1)
        return false;
    S.data[++S.top] = i;
    return true;
}

bool Pop(CharStack &S, char &ch){
    if (S.top == -1)
        return false;
    ch = S.data[S.top--];
    return true;
}
bool Pop(NumStack &S, int &i){
    if (S.top == -1)
        return false;
    i = S.data[S.top--];
    return true;
}
bool Pop(DoubleStack &S, double &i){
    if (S.top == -1)
        return false;
    i = S.data[S.top--];
    return true;
}

bool GetTop(CharStack S, char &ch){
    if (S.top == -1)
        return false;
    ch = S.data[S.top];
    return true;
}
bool GetTop(NumStack S, int &i){
    if (S.top == -1)
        return false;
    i = S.data[S.top];
    return true;
}
bool GetTop(DoubleStack S, double &i){
    if (S.top == -1)
        return false;
    i = S.data[S.top];
    return true;
}

bool CharStackEmpty(CharStack S) {
    return S.top == -1;
}
bool CharStackEmpty(NumStack S){
    return S.top == -1;
}
bool CharStackEmpty(DoubleStack S){
    return S.top == -1;
}

//弹出两个操作数进行运算
int cipher(NumStack *n, char t){
    if (n->top < 1)
        return 0;
    int n1 = 0, n2 = 0;
    Pop(*n, n1);
    Pop(*n, n2);
    if (t == '+')
    {
        Push(*n, n2 + n1);
        printf("%d%c%d ", n2, t, n1);
    }
    if (t == '-')
    {
        Push(*n, n2 - n1);
        printf("%d%c%d ", n2, t, n1);
    }
    if (t == '*')
    {
        Push(*n, n2 * n1);
        printf("%d%c%d ", n2, t, n1);
    }
    if (t == '/')
    {
        Push(*n, n2 / n1);
        printf("%d%c%d ", n2, t, n1);
    }
    return 1;
}
int cipher(DoubleStack *n, char t){
    if (n->top < 1)
        return 0;
    double n1 = 0, n2 = 0;
    Pop(*n, n1);
    Pop(*n, n2);
    if (t == '+')
    {
        Push(*n, n2 + n1);
        printf("%g%c%g ", n2, t, n1);
    }
    if (t == '-')
    {
        Push(*n, n2 - n1);
        printf("%g%c%g ", n2, t, n1);
    }
    if (t == '*')
    {
        Push(*n, n2 * n1);
        printf("%g%c%g ", n2, t, n1);
    }
    if (t == '/')
    {
        Push(*n, n2 / n1);
        printf("%g%c%g ", n2, t, n1);
    }
    return 1;
}

//将操作数压栈
void pushNum(NumStack *n, int *flag, int num){
    if (!*flag){ //如果之前读取到了一个数，就将它压栈，并重置flag
        Push(*n, num);
        *flag = 1;
    }
}
void pushNum(DoubleStack *n, int *flag, char num[]){
    if (!*flag){ //如果之前读取到了一个数，就将它压栈，并重置flag
        Push(*n, atof(num));
        *flag = 1;
    }
}