#pragma once
#include <stdlib.h>
#include <stdio.h>
typedef int Data;

typedef struct BTreeNode{
    Data data;  //数据
    BTreeNode *lchild, *rchild;  //左后孩子
} BTNode, *BiTree;

//------------------队列-----------------------

typedef struct QLinkNode{
    BTNode *node;       //数据域
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
void EnQueue(LinkQueue &Q, BTNode *node){
    QNode *p = (QNode *)malloc(sizeof(QNode));
    p->node = node;
    p->next = NULL;
    Q.rear->next = p;
    Q.rear = p;
}

//出队（带头结点），这里传入的node用BTNode **node 或 BTNode* &node，否则地址会传递失败
bool DeQueue(LinkQueue &Q, BTNode* &node){
    if (Q.front == Q.rear)
        return false;
    QNode *p = Q.front->next;
    node = p->node;
    Q.front->next = p->next;
    if (Q.rear == p) //如果是最后一个结点出队
        Q.rear = Q.front;
    free(p);
    return true;
}

//------------------------栈--------------------------

typedef struct LinkNode{
    BTNode *node;
    LinkNode *next;
} Node, *LinkStack;

//初始化链栈
void InitStack(LinkStack &S){
    S = (Node *)malloc(sizeof(Node));
    S->next = NULL;
}

//判断栈是否为空
bool IsEmpty(LinkStack S){
    return S->next == NULL;
}

//压栈
void Push(LinkStack &S, BTNode *node){
    Node *p = (Node *)malloc(sizeof(Node));
    p->node = node;
    p->next = S->next;
    S->next = p;
}

//弹栈
bool Pop(LinkStack &S, BTNode* &node){
    if (S->next == NULL)
        return false;
    Node *temp = S->next;
    node = temp->node;
    S->next = temp->next;
    free(temp);
    return true;
}

//获得栈顶元素
bool GetTop(LinkStack S, BTNode* &node){
    if (S->next == NULL)
        return false;
    node = S->next->node;
    return true;
}