#include "main.h"
#include "stackAndOperate.cpp"
#define N 50

int main(int argc, char const *argv[])
{
    char str[N], ch, t;
    CharStack c = GetCharStack();
    NumStack n = GetNumStack();
    int flag = 1, num = 0;
    printf("请输入中缀表达式：\n");
    scanf("%[^\n]", str);
    for (int i = 0; i < N; i++) {
        ch = str[i];
        if (ch == '\0') {   //当中缀表达式读取到末尾时
            pushNum(&n, &flag, num);     //如果之前读取到了一个数，就将它压栈（它是最后一个数）
            while (c.top > -1) {    //将运算符栈中剩余的运算符弹出并弹出操作数进行运算
                Pop(c, t);
                if (!cipher(&n, t))
                    goto End;
            }
            if (n.top == 0) { //如果运算符栈中最后只剩一个元素，那么它就是最终运算结果
                printf("\n运算结果：%d", n.data[0]);
                return 0;
            }
            else
                goto End;
        }
        else if (ch == ' ' || isdigit(ch)) {//如果是数字或空格
            if (ch == ' ') //如果读取到空格，说明前面读取了一个数或者运算符
                pushNum(&n, &flag, num); //如果读到的是数，将数压栈并将flag重置，以等待新数的读取
            else{ //获得一个数（不论是几位数的）
                if (flag){ //当读取到一个数的第一位时（flag标志是否遇到一个数的第一位）
                    num = ch - 48;
                    flag = 0;
                }
                else //如果读取到的数不是一位的，继续读取其余位数
                    num = num * 10 + (ch - 48);
            }
        } 
        else if (ch == '(') //如果读取到了左括号，直接压入栈中
            Push(c, ch);
        else if (ch == ')'){ //如果读取到了右括号，将其栈中匹配的左括号后面的运算符全部弹出
            pushNum(&n, &flag, num); //如果之前读取到了一个数，就将它压栈，并重置flag
            while (Pop(c, t)){
                if (t == '(')
                    break;
                else{
                    if (!cipher(&n, t))
                        goto End;
                }
            }
            if (t != '(') //如果读取到了右括号，但栈中没有左括号，则中缀字符串是非法的
                goto End;
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            pushNum(&n, &flag, num); //如果之前读取到了一个数，就将它压栈，并重置flag
            if (ch == '+' || ch == '-'){
                while (GetTop(c, t)){
                    if (t == '(')
                        break;
                    else{
                        Pop(c, t);
                        if (!cipher(&n, t))
                            goto End;
                    }
                }
            }
            else{
                while (GetTop(c, t)){
                    if (t == '*' || t == '/'){
                        Pop(c, t);
                        if (!cipher(&n, t))
                            goto End;
                    }
                    else
                        break;
                }
            }
            Push(c, ch);
        }
        else {
            End:
                printf("你输入的表达式非法！");
                return 0;
        }
    }
    return 0;
}
