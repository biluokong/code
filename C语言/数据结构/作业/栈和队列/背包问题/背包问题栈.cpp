#define max 100
#include "stack.h"

int main(){
    // read the datas
    int T, n;
    int W[max];
    bool found = false;
    printf("请输入背包的总体积: ");
    scanf("%d", &T);
    printf("请输入物品的个数: ");
    scanf("%d", &n);
    printf("请输入各个物品的体积: ");
    for (int j = 0; j < n; j++)
        scanf("%d", &W[j]);
    printf("所有的可能结果为: \n");
    int left = T;
    Stack s;
    InitStack(s);
    int i = 0;
    while (1){
        if (left == W[i] || (left > W[i] && i < n)){ // 可以放进背包的情况
            Push(s, i);
            left -= W[i];
        }

        if (left == 0){ // 刚好装满
            // 标记
            found = true;
            // 输出结果
            Stack t;
            InitStack(t);
            while (!StackEmpty(s)){
                Push(t, GetTop(s));
                Pop(s);
            }
            while (!StackEmpty(t)){
                printf("%d ", W[GetTop(t)]);
                Push(s, GetTop(t));
                Pop(t);
            }
            printf("\n");
            // 处理下一情况
            if (s.top == 0){
                left += W[GetTop(s)];
                Pop(s);
                i++;
                if (i == n)
                    break;
            }
            else if (i == n - 1){
                left += W[GetTop(s)];
                Pop(s);
                i = GetTop(s) + 1;
                left += W[GetTop(s)];
                Pop(s);
            }
            else{
                i = GetTop(s) + 1;
                left += W[GetTop(s)];
                Pop(s);
            }
        }
        else{ // 不能装满
            if (i == n - 1){ // i遍历到最后一个物品
                if (s.top == 0 && GetTop(s) == n - 1){
                    break;
                }
                else{
                    if (i == GetTop(s)){
                        left += W[GetTop(s)];
                        Pop(s);
                        i = GetTop(s) + 1;
                        left += W[GetTop(s)];
                        Pop(s);
                    }
                    else{
                        i = GetTop(s) + 1;
                        left += W[GetTop(s)];
                        Pop(s);
                    }
                }
            }
            else{ // 其他情况
                i++;
            }
        }
    }
    if (found == false)
        printf("无解");
    return 0;
}