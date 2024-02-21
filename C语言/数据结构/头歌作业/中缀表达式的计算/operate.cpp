#include "main.h"
/*创建栈*/
LinkStack *LS_Create()
{
    LinkStack *ls = (LinkStack *)malloc(sizeof(LinkStack));
    ls->top = NULL;
    ls->len = 0;
    return ls;
}

/*释放栈*/
void LS_Free(LinkStack *ls)
{
    LNode *curr = ls->top;
    while (curr)
    {
        LNode *next = curr->next;
        free(curr);
        curr = next;
    }
    free(ls);
}

/*将栈变为空栈*/
void LS_MakeEmpty(LinkStack *ls)
{
    LNode *curr = ls->top;
    while (curr)
    {
        LNode *next = curr->next;
        free(curr);
        curr = next;
    }
    ls->top = NULL;
    ls->len = 0;
}

/*判断栈是否为空*/
bool LS_IsEmpty(LinkStack *ls)
{
    return ls->len == 0;
}

/*获取栈的长度*/
int LS_Length(LinkStack *ls)
{
    return ls->len;
}

/*将x进栈*/
void LS_Push(LinkStack *ls, T x)
{
    LNode *node = (LNode *)malloc(sizeof(LNode));
    node->data = x;
    node->next = ls->top;
    ls->top = node;
    ls->len++;
}

/*出栈。出栈元素放入item；如果空栈，将返回false*/
bool LS_Pop(LinkStack *ls, T &item)
{
    LNode *node = ls->top;
    if (node == NULL)
    {
        return false;
    }
    item = node->data;
    ls->top = node->next;
    ls->len--;
    free(node);
    return true;
}

/*读栈顶元素放入item。如果空栈，将返回false*/
bool LS_Top(LinkStack *ls, T &item)
{
    LNode *node = ls->top;
    if (node == NULL)
    {
        return false;
    }
    item = node->data;
    return true;
}

/*从栈顶到栈底打印各结点数据*/
void LS_Print(LinkStack *ls)
{
    if (ls->len == 0)
    {
        printf("The stack: Empty!\n");
        return;
    }
    printf("The stack (from top to bottom): ");
    LNode *curr = ls->top;
    while (curr)
    {
        printf("%lf  ", curr->data);
        curr = curr->next;
    }
    printf("\n");
}

//////////////////////////////////////////////////////////////
void compute(LinkStack *so, LinkStack *sd)
//++++++++++++++++++++++++++++++++++++++++++++++
// so 运算符栈
// sd 操作数栈
// 1 从运算符栈出栈一个运算符
// 2 从操作数栈出栈两个操作数
// 3 用出栈的运算符对出栈的操作数进行运算
// 4 将运算结果进操作数栈
//+++++++++++++++++++++++++++++++++++++++++++++++
{
    T a, b, c, d;
    LS_Pop(so, c);
    LS_Pop(sd, a);
    LS_Pop(sd, b);
    if (c == '*')
        d = b * a;
    else if (c == '/')
        d = b / a;
    else if (c == '+')
        d = b + a;
    else if (c == '-')
        d = b - a;
    else
        printf("never occur!");
    LS_Push(sd, d);
}

double ComputeInfix(char *s)
//计算中缀表达式
{
    // 请在此添加代码，补全函数ComputeInfix，计算中缀表达式
    /********** Begin *********/
    int i = 0;
    LinkStack *so = LS_Create(); //运算符栈
    LinkStack *sd = LS_Create(); //操作数栈
    while (s[i]){
        if (s[i] >= '0' && s[i] <= '9')
            LS_Push(sd, s[i++] - '0');
        else if (s[i] == '(' || LS_IsEmpty(so))
            LS_Push(so, s[i++]);
        else if (s[i] == ')'){
            T op;
            while (LS_Top(so, op) && op != '(')
                compute(so, sd);
            LS_Pop(so, op);
            i++;
        }
        else if (s[i] == '*' || s[i] == '/'){
            T op;
            LS_Top(so, op);
            if (op == '*' || op == '/')
                compute(so, sd);
            LS_Push(so, s[i++]);
        }
        else if (s[i] == '+' || s[i] == '-'){
            T op;
            while (LS_Top(so, op) && op != '(')
                compute(so, sd);
            LS_Push(so, s[i++]);
        }
    }
    while (!LS_IsEmpty(so))
        compute(so, sd);
    T result;
    LS_Top(sd, result);
    LS_Free(so);
    LS_Free(sd);
    return result;
    /********** End **********/
}
