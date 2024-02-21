#include "main.h"
#include "stack.cpp"
#define N 50
/*
中缀表达式转后缀表达式的方法：
    （1）遇到操作数：直接加入后缀表达式
    （2）遇到界限符：遇到 “(” 直接入栈；遇到 “)” 则依次弹出栈内运算符并加入后缀表达式，
        直到弹出 “(” 为止。（“(”不加入后缀表达式）
    （3）遇到运算符：依次弹出栈中优先级高于或等于当前运算符的所有运算符，并加入后缀表达式，
        若碰到  “(” 或栈空则停止。之后再把当前运算符入栈。
    （4）读取到了表达式结束字符，则把栈中剩余的运算符全部弹出，并加入后缀表达式。
*/
int main(int argc, char const *argv[])
{
    char str[N], result[N], c, t;
    int j = 0;
    CharStack s = GetCharStack();
    printf("请输入中缀表达式：\n");
    scanf("%[^\n]", &str);
    for (int i = 0; i < N; i++){
        c = str[i];
        if (c == '\0') {    //如果读取到了中缀字符串末尾，将栈中剩下的运算符全部弹出
            while (s.top > -1) {
                Pop(s, t);
                result[j++] = ' ';
                result[j++] = t;
            }
            break;
        }
        else if (c >= '0' && c <= '9') {    //如果是数字，直接放到后缀字符串中
            result[j++] = c;
        }
        else if (c == '(')  //如果读取到了左括号，直接压入栈中
            Push(s, c);
        else if (c == ')') {    //如果读取到了右括号，将其栈中匹配的左括号后面的运算符全部弹出
            while (Pop(s, t)) {
                if (t == '(')
                    break;
                else{
                    result[j++] = ' ';
                    result[j++] = t;
                }
            }
            if (t != '(')   //如果读取到了右括号，但栈中没有左括号，则中缀字符串是非法的
                goto End;
        }
        //如果读取到了运算符，将栈中优先级高于/等于当前运算符的所有运算符弹出，直到遇到‘(’/栈空，在把当前运算符压入
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
            result[j++] = ' ';
            if (c == '+' || c == '-') {
                while (GetTop(s, t)) {
                    if (t == '(')
                        break;
                    else {
                        Pop(s, t);
                        result[j++] = t;
                        result[j++] = ' ';
                    }
                }
            }
            else {
                while (GetTop(s, t)) {
                    if (t == '*' || t == '/') {
                        Pop(s, t);
                        result[j++] = t;
                        result[j++] = ' ';
                    }else 
                        break;
                }
            }
            Push(s, c);
        }
        else if (c == ' ' || c == '\t');    //忽略读取到的空格和制表符
        else{
        End:
            printf("输入了非法的值！");
            return 0;
        }
    }
    for (int i = 0; i < j; i++)
        printf("%c", result[i]);
    return 0;
}
