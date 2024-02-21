#include "main.h"

//获得一个新的空栈
CharStack GetCharStack()
{
    CharStack S;
    S.top = -1;
    return S;
}
NumStack GetNumStack() {
    NumStack S;
    S.top = -1;
    return S;
}

bool Push(CharStack &S, char ch)
{
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

bool Pop(CharStack &S, char &ch)
{
    if (S.top == -1)
        return false;
    ch = S.data[S.top--];
    return true;
}
bool Pop(NumStack &S, int &i)
{
    if (S.top == -1)
        return false;
    i = S.data[S.top--];
    return true;
}

bool GetTop(CharStack S, char &ch) {
    if (S.top == -1)
        return false;
    ch = S.data[S.top];
    return true;
}
bool GetTop(NumStack S, int &i) {
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