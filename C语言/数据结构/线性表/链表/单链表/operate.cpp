#include "linkedlList.h"

//按位查找其相应的结点
node *ListIndexFind(LinkList &L, int index)
{
    if (index < 1 || L == NULL || index > L->data)
        return NULL;
    node *temp = L;
    int i = 0;
    while (i < index)
    { //找到第index个结点
        temp = temp->next;
        i++;
    }
    return temp;
}

//按值查找其相应的结点
node *ListElemFind(LinkList &L, int elem)
{
    if (L == NULL)
        return NULL;
    node *temp = L->next;
    while (temp != NULL && temp->data != elem)
    {
        temp = temp->next;
    }
    return temp;
}

//在指定结点后插入元素
bool NodeNextInsert(node *n, int elem) {
    node *p = (node *)malloc(sizeof(node));
    if (n == NULL || p == NULL)
        return false;
    p->data = elem;
    p->next = n->next;
    n->next = p;
    return true;
}

//删除指定结点，可以将后一个结点的值给前一个结点，然后将后一个结点删除来类似实现功能
bool NodeDelete(node *n) {
    if (n == NULL || n->next == NULL)
        return false;
    node *temp = n->next;
    n->data = temp->data;
    n->next = temp->next;
    free(temp);
    return true;
}

//在指定结点前插入元素（可以通过交换数据达到类似交换结点的作用）
bool NodePriorInsert(node *n, int elem) {
    node *p = (node *)malloc(sizeof(node));
    if (n == NULL || p == NULL)
        return false;
    p->next = n->next;
    n->next = p;
    p->data = n->data;
    n->data = elem;
    return true;
}

//删除第index个结点
bool ListDelete(LinkList &L, int index) {
    node *temp = (index == 1) ? L : ListIndexFind(L, index - 1);
    if (temp == NULL)
        return false;
    node *p = temp->next;
    temp->next = p->next;
    L->data--;
    free(p);
    return true;
}

//在第index个位置插入元素
bool ListInsert(LinkList &L, int index, int elem) {
    node *temp = (index == 1) ? L : ListIndexFind(L, index - 1); //找到第index-1个结点
    if (temp == NULL)
        return false;
    bool success = NodeNextInsert(temp, elem);
    if (success)
        L->data++;
    return success;
}

//添加元素，尾插法
bool ListTailAdd(LinkList &L, int elem) {
    node *p = (node *)malloc(sizeof(node));
    if (p == NULL || L == NULL)
        return false;
    p->data = elem;
    p->next = NULL;
    node *temp = L;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = p;
    L->data++;
    return true;
}

//添加元素：头插法
bool ListHeadAdd(LinkList &L, int elem) {
    node *p = (node *)malloc(sizeof(node));
    if (p == NULL || L == NULL)
        return false;
    p->data = elem;
    p->next = L->next;
    L->next = p;
    L->data++;
    return true;
}

//遍历输出链表
void ListPrint(LinkList L) {
    node *temp = L->next;
    while (temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

//初始化一个空的单链表
bool InitNullHeadList(LinkList &L) {
    L = NULL;
    return true;
}

//判断带头结点的链表是否为空
bool Empty(LinkList L) {
    return (L->next == NULL);
    // return (L->data == 0);
}

//初始化一个带头结点的空单链表，头结点的数据域可以用来储存数据的数量
bool InitList(LinkList &L) {
    L = (node *)malloc(sizeof(node));   //分配一个头结点
    if (L == NULL)
        return false;
    L->data = 0;
    L->next = NULL;
    return true;
}

//头插法初始化一个链表
LinkList HeadInitList()
{
    LinkList L;
    InitList(L);
    int data = 0;
    cout << "请输入数据(若要结束，请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000)
    {
        node *p = (node *)malloc(sizeof(node));
        p->data = data;
        p->next = L->next;
        L->next = p;
        cout << "请输入数据(若要结束，请输入-10000)：" << endl;
        cin >> data;
    }
    return L;
}

//尾插法初始化一个链表
LinkList TailInitList() {
    LinkList L;
    InitList(L);
    node *temp = L;
    int data = 0;
    cout << "请输入数据(如要结束，请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000)
    {
        node *p = (node *)malloc(sizeof(node));
        p->data = data;
        p->next = NULL;
        temp->next = p;
        temp = p;
        cout << "请输入数据(如要结束，请输入-10000)：" << endl;
        cin >> data;
    }
    return L;
}

//获取链表的长度
int ListLength(LinkList L) {
    return L->data;
}

//判断不带头结点的链表是否为空
bool NullHeadEmpty(LinkList L) {
    return (L == NULL);
}

//销毁单链表
void DestoryLinkList(LinkList L){
    node *p = L->next, *t = L->next;
    while (p != NULL){
        p = p->next;
        free(t);
        t = p;
    }
    L->next = NULL;
}