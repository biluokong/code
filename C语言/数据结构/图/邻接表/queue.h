#include "graph.h"

typedef struct QLinkNode{
    int index;       //数据域
    QLinkNode *next; //指针域
} QNode;

struct LinkQueue{
    QLinkNode *front, *rear; //队列的队头和队尾指针
};

//初始化队列（带头指针）
void InitQueue(LinkQueue &Q){
    Q.front = Q.rear = (QLinkNode *)malloc(sizeof(QLinkNode));
    Q.front->next = NULL;
}

//判断队列是否为空
bool IsEmpty(LinkQueue Q){
    return Q.front == Q.rear;
}

//入队
void EnQueue(LinkQueue &Q, int index){
    QNode *p = (QNode *)malloc(sizeof(QNode));
    p->index = index;
    p->next = NULL;
    Q.rear->next = p;
    Q.rear = p;
}

//出队（带头结点）
bool DeQueue(LinkQueue &Q, int &index){
    if (Q.front == Q.rear)
        return false;
    QNode *p = Q.front->next;
    index = p->index;
    Q.front->next = p->next;
    if (Q.rear == p) //如果是最后一个结点出队
        Q.rear = Q.front;
    free(p);
    return true;
}