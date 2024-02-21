#include <stdlib.h>
#include <stdio.h>
typedef int Data;

typedef struct LQNode{  //队列结点的结构体
    Data data;
    LQNode *next;
} QNode;

typedef struct LQueue{  //队列的结构体
    QNode *rear;
} Queue;

//初始化队列
bool InitQueue(Queue &Q){
    Q.rear = (QNode *)malloc(sizeof(QNode));
    if (Q.rear == NULL)
        return false;
    Q.rear->data = -1;
    Q.rear->next = Q.rear;
    return true;
}

//判断队列是否为空
bool IsEmpty(Queue Q){
    return Q.rear->next == Q.rear;
}

//入队
bool EnQueue(Queue &Q, Data data){
    QNode *p = (QNode *)malloc(sizeof(QNode));
    if (p == NULL)
        return false;
    p->data = data;
    if (IsEmpty(Q))
        p->next = p;    //把第一个数据结点作为循环链表的头结点
    else    //以第一个数据结点为头结点构造循环链表
        p->next = Q.rear->next->next;
    Q.rear->next->next = p;
    Q.rear->next = p;   //rear结点不是数据结点，用来保存尾结点的地址
    return true;
}

//出队
bool DeQueue(Queue &Q, Data &data){
    if (IsEmpty(Q))
        return false;
    QNode *p = Q.rear->next->next;
    data = p->data;
    Q.rear->next->next = p->next;
    if (Q.rear->next->next == p)    //当尾结点出队时，让rear的指针域指向自己
        Q.rear->next = Q.rear;
    free(p);
    return true;
}

//获得队头元素
bool GetFront(Queue Q, Data &data){
    if (IsEmpty(Q))
        return false;
    data = Q.rear->next->next->data;
    return true;
}

int main(){
    Queue Q;
    InitQueue(Q);
    printf("%d %d", &Q, IsEmpty(Q));
    EnQueue(Q, 3);
    printf("\n%d %d", Q.rear->data, IsEmpty(Q));
    EnQueue(Q, 6);
    EnQueue(Q, 9);
    printf("\n%d %d %d", Q.rear->data, Q.rear->next->data, Q.rear->next->next->data);
    Data data = 0;
    DeQueue(Q, data);
    printf("\n%d %d %d", Q.rear->data, Q.rear->next->data, Q.rear->next->next->data);
    printf("\n%d ", data);
    while (DeQueue(Q, data))
        printf("%d ", data);
    printf("%d %d", &Q, IsEmpty(Q));
    return 0;
}