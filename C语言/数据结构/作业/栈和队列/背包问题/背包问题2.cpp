#include "stack.h"

void traver(SqStack s, int w[]){
    int length = s.top;
    for (int i = 0; i <= length; i++)
        printf("%d ", w[s.data[i]]);
    printf("\n");
}

void fun(int T, int w[]){
    SqStack s;
    InitStack(s);
    int i = 0, count = T;
    while (!StackEmpty(s) || (StackEmpty(s) && i < 6)){
        while (count > 0 && i < 6){
            count -= w[i];
            Push(s, i);
            i++;
        }
        if (count == 0)
            traver(s, w);
        i = Pop(s) + 1;
        count += w[i - 1];
    }
}

int main(){
    int T, n, w[6];
    printf("请输入背包的总体积: ");
    scanf("%d", &T);
    printf("请输入物品的个数: ");
    scanf("%d", &n);
    printf("请输入各个物品的体积: ");
    for (int j = 0; j < n; j++)
        scanf("%d", &w[j]);
    printf("所有的可能结果为: \n");
    fun(T, w);
    return 0;
}