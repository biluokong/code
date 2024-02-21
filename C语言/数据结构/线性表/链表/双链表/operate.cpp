#include "DLinkedList.h"

//初始化双链表
bool InitDList(DLinkList &L) {
    L = (node *)malloc(sizeof(node));
    if (L == NULL)
        return false;
    L->data = 0;
    L->prior = NULL;
    L->next = NULL;
    return true;
}

//判断链表是否为空
bool Empty(DLinkList L) {
    return (L->next == NULL); //获取return (L->data == 0);
}

//在p结点后插入s结点
bool InsertNextDNode(DNode *p, DNode *s) {
    if (p == NULL || s == NULL)
        return false;
    s->next = p->next;
    if (p->next != NULL)
        p->next->prior = s;
    s->prior = p;
    p->next = s;
    return true;
}

//在p结点前插入结点
bool InsertPriorDNode(DNode *p, DNode *s) {
    if (p == NULL || s == NULL)
        return false;
    s->prior = p->prior;
    if (p->prior != NULL)
        p->prior->next = s;
    s->next = p;
    p->prior = s;
    return true;
}

//删除p的后继结点
bool DeleteNextDNOode(DNode *p) {
    if (p == NULL || p->next == NULL)
        return false;
    node *temp = p->next;
    p->next = temp->next;
    if (temp->next != NULL)
        temp->next->prior = p;
    free(temp);
    return true;
}

//删除p的前驱结点
bool DeletePriorDNode(DNode *p) {
    if (p == NULL || p->prior == NULL)
        return NULL;
    node *temp = p->prior;
    p->prior = temp->prior;
    if (temp->prior != NULL)
        temp->prior->next = p;
    free(temp);
    return true;
}

//销毁当前双链表
void DestoryDList(DLinkList &L) {
    while (L->next != NULL)
        DeleteNextDNOode(L);
    free(L);
    L = NULL;
}

//向后遍历输出双链表的数据
void print(DLinkList L) {
    node *temp = L->next;
    while (temp != NULL){
        cout << temp->data << " ";
        temp = temp->next;
    }
}

//获取键盘输入初始化一个双链表
DLinkList GetDList() {
    DLinkList L;
    if (InitDList(L)) {
        int data = 0;
        node *temp = L;
        cout << "请输入数据(若要结束，请输入-10000)：" << endl;
        cin >> data;
        while (data != -10000) {
            node *p = (node *)malloc(sizeof(node));
            if (!InsertNextDNode(temp, p))
                return NULL;
            p->data = data;
            temp = p;
            cout << "请输入数据(若要结束，请输入-10000)：" << endl;
            cin >> data;
        }
        return L;
    } else
        return NULL;
}