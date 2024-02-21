#include "main.h"
#include "stackAndOperate.cpp"
#define N 50

int main(int argc, char const *argv[]){
    char str[N], ch, t, num[10] = {};
    CharStack c = GetCharStack();
    DoubleStack n = GetDoubleStack();
    int flag = 1;
    printf("请输入中缀表达式：\n");
    scanf("%[^\n]", str);
    for (int i = 0; i < N; i++){
        ch = str[i];
        if (ch == '\0'){
            pushNum(&n, &flag, num);
            while (c.top > -1){
                Pop(c, t);
                if (!cipher(&n, t))
                    goto End;
            }
            if (n.top == 0){
                printf("\n运算结果：%g", n.data[0]);
                return 0;
            }
            else
                goto End;
        }
        else if (ch == ' ' || ch == '.' || isdigit(ch)){                  
            if (ch == ' ') 
                pushNum(&n, &flag, num); 
            else{
                if (flag){
                    strcpy(num, "\0");
                    flag = 0;
                }
                char cs[2];
                sprintf(cs, "%c", ch);
                strcat(num, cs);
            }
        }
        else if (ch == '(') 
            Push(c, ch);
        else if (ch == ')'){                   
            pushNum(&n, &flag, num); 
            while (Pop(c, t)){
                if (t == '(')
                    break;
                else{
                    if (!cipher(&n, t))
                        goto End;
                }
            }
            if (t != '(')
                goto End;
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            pushNum(&n, &flag, num); 
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
        else{
        End:
            printf("你输入的表达式非法！");
            return 0;
        }
    }
    return 0;
}
