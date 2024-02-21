#include "stack.h"

//初始化链栈
void InitStack(LinkStack &S) {
    S = (Node *)malloc(sizeof(Node));
    S->next = NULL;
}

//判断栈是否为空
bool StackEmpty(LinkStack S) {
    return S->next == NULL;
}

//压栈
void Push(LinkStack &S, int data) {
    Node *p = (Node *)malloc(sizeof(Node));
    p->data = data;
    p->next = S->next;
    S->next = p;
}

//弹栈
bool Pop(LinkStack &S, int &data) {
    if (S->next == NULL)
        return false;
    Node *temp = S->next;
    data = temp->data;
    S->next = temp->next;
    free(temp);
    return true;
}

//获得栈顶元素
bool GetTop(LinkStack S, int &data) {
    if (S->next == NULL)
        return false;
    data = S->next->data;
    return true;
}

//用输入的数据初始化一个栈
LinkStack GetStack() {
    LinkStack S;
    InitStack(S);
    int data = 0;
    cout << "请输入数据(若要停止，请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000) {
        Node *p = (Node *)malloc(sizeof(Node));
        p->data = data;
        p->next = S->next;
        S->next = p;
        cout << "请输入数据(若要停止，请输入-10000)：" << endl;
        cin >> data;
    }
    return S;
}

void print(LinkStack S) {
    Node *temp = S->next;
    while (temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}