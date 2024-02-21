#include "main.h"
#include "stack.cpp"
#define N 30

int main(int argc, char const *argv[])
{
    char str[N], c, t;
    printf("请输入您想要进行括号匹配的字符串：\n");
    scanf("%s", &str);
    CharStack s = GetCharStack();
    for (int i = 0; i < N; i++) {
        c = str[i];
        //如果要匹配的字符串到达结束符位置，并且栈为空，则匹配成功
        if (c == '\0' && CharStackEmpty(s)) {  
            printf("匹配成功");
            return 0;
        }
        //如果遇到左括号，就压栈
        else if (c == '(' || c == '[' || c == '{')
            Push(s, c);
        //遇到右括号就出栈，并比较是否匹配
        else if (c == ')' || c == ']' || c == '}') {
            //如果栈已为空或不匹配则匹配失败
            if (!Pop(s, t) || !((c == ')' && t == '(') || (c == ']' && t == '[') || (c == '}' && t == '{')))
                goto End;
        }
        //如果字符串结束后栈不为空，匹配失败
        else if (c == '\0') {
            End:
            printf("匹配失败");
            return 0;
        }
    }
    return 0;
}
