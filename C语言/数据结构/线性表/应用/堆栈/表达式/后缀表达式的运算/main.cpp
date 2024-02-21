#include "main.h"
#include "stack.cpp"
#define N 40

int main(int argc, char const *argv[])
{
    char str[N], c;
    int n1, n2, n;
    bool flag = true;
    NumStack s = GetNumStack();
    printf("请输入后缀表达式：\n");
    scanf("%[^\n]", &str);  //scanf默认会跳过空格符、换行符、回车符
    for (int i = 0; i < N; i++) {
        c = str[i];
        if (c == ' ' || c >= '0' && c <= '9'){
            if (c == ' '){  //如果读取到空格，说明前面读取了一个数或者运算符
                if (!flag){ //如果读到的数，将数压栈并将flag重置，以等待新数的读取
                    Push(s, n);
                    flag = true;
                }
            }
            else{   //获得一个数（不论是几位数的）
                if (flag){  //当读取到一个数的第一位时（flag标志是否遇到一个数的第一位）
                    n = c - 48;
                    flag = false;
                }
                else    //如果读取到的数不是一位的，继续读取其余位数
                    n = n * 10 + (c - 48);
            }
        }
        else if (c == '\0' && s.top == 0){  //如果到了输入字符串末尾且栈中只有一个数据
            printf("运算结果：%d", s.data[0]);
            return 0;
        }
        else if (c == '+' || c == '-' || c == '*' || c == '/') {  //如果读取到了运算符
            if (!flag) {    //如果之前读取到了一个数，就将它压栈，并重置flag
                Push(s, n);
                flag = true;
            }
            if (s.top < 1)  //如果栈中不够弹出两个数据进行运算，则说明输入非法
                goto End;
            Pop(s, n1);
            Pop(s, n2);
            if (c == '+')
                Push(s, n2 + n1);
            if (c == '-') 
                Push(s, n2 - n1);
            if (c == '*')
                Push(s, n2 * n1);
            if (c == '/') {
                if (n1 == 0) {
                    printf("运算错误，除数为零！");
                    return 0;
                }
                Push(s, n2 / n1);
            }
        }
        else {
            End:
            printf("你输入的表达式非法！");
            return 0;
        }
    }
    return 0;
}
