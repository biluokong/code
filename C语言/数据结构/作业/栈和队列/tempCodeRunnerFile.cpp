#include"stack.h"
#define N 20

int main(){
    char str[N];
    printf("请输入一个字符串：\n");
    scanf("%s", str);
    SqStack s;
    InitStack(s);
    char t;
    int length = strlen(str);
    for (int i = 0; i < length; i++){
        if (i == length / 2 && length % 2 != 0)
            continue;
        if (i < length / 2)
            Push(s, str[i]);
        else if (GetTop(s, t) && t == str[i])
            Pop(s, t);
    }
    if (StackEmpty(s))
        printf("该字符串为回文字符串");
    else
        printf("该字符串不是回文字符串");
    return 0;
}