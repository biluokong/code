#include "circularLinkedList.h"
#define printing() while (L != NULL && temp != NULL && temp != L){cout << temp->data << " ";temp = temp->next;}

//初始化一个空的循环单链表
bool InitCList(CLinkList &L) {
    L = (LNode *)malloc(sizeof(LNode));
    if (L == NULL)
        return false;
    L->data = 0;
    L->next = L;
    return true;
}

//初始化一个空的循环双链表
bool InitCDList(CDLinkList &L) {
    L = (DNode *)malloc(sizeof(DNode));
    if (L == NULL)
        return false;
    L->data = 0;
    L->next = L;
    L->prior = L;
    return true;
}

//获取一个循环单链表
CLinkList GetCList() {
    CLinkList L;
    InitCList(L);
    LNode *p, *temp = L;
    int data = 0;
    cout << "请你输入数据(若要停止请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000){
        p = (LNode *)malloc(sizeof(LNode));
        if (p == NULL)
            return NULL;
        p->data = data;
        temp->next = p;
        temp = p;
        p->next = L;
        cout << "请你输入数据(若要停止请输入-10000)：" << endl;
        cin >> data;
    }
    return L;
}

//获得一个循环双链表
CDLinkList GetCDList() {
    CDLinkList L;
    InitCDList(L);
    DNode *p, *temp = L;
    int data = 0;
    cout << "请你输入数据(若要停止请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000) {
        p = (DNode *)malloc(sizeof(DNode));
        if (p == NULL)
            return NULL;
        p->data = data;
        temp->next = p;
        p->prior = temp;
        temp = p;
        L->prior = p;
        p->next = L;
        cout << "请你输入数据(若要停止请输入-10000)：" << endl;
        cin >> data;
    }
    return L;
}

//1、通过定义枚举类型在一个函数内实现对循环单/双链表的遍历输出
/* enum Type{
    CLList,
    CDLList
};
//遍历输出一个循环单链表
void print(Type type, void *L) {
    if (type == 0) {
        LNode *temp = ((LNode *)L)->next;
        printing()
    }
    else {
        DNode *temp = ((DNode *)L)->next;
        printing()
    }
} */

//2、通过函数重载实现对循环单/双链表的遍历输出
void print(CLinkList L) {
    LNode *temp = L->next;
    printing()
}
void print(CDLinkList L){
    DNode *temp = L->next;
    printing()
}

//删除指定循环单链表结点的下一个结点
bool deleteNextNode(LNode *p) {
    if (p == NULL || p->next == p)
        return false;
    LNode *temp = p->next;
    p->next = temp->next;
    temp->next = NULL;
    free(temp);
    return true;
}

//删除指定循环双链表结点的下一个结点
bool deleteNextNode(DNode *p) {
    if (p == NULL || p->next == p)
        return false;
    DNode *temp = p->next;
    p->next = temp->next;
    temp->next->prior = p;
    temp->next = NULL;
    temp->prior = NULL;
    free(temp);
    return true;
}

//在指定循环单链表结点后面插入一个结点
bool insertNextNode(LNode *p, LNode *s) {
    if (p == NULL || s == NULL)
        return false;
    s->next = p->next;
    p->next = s;
    return true;
}

//在指定循环双链表结点后面插入一个结点
bool insertNextNode(DNode *p, DNode *s) {
    if (p == NULL || s== NULL)
        return false;
    s->next = p->next;
    s->prior = p;
    p->next->prior = s;
    p->next = s;
    return true;
}