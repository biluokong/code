#include "queue.h"

//初始化队列（带头指针）
void InitHeadQueue(LinkQueue &Q){
    Q.front = Q.rear = (LinkNode *)malloc(sizeof(LinkNode));
    Q.front->next = NULL;
}
//不带头结点
void InitQueue(LinkQueue &Q) {
    Q.front = Q.rear = NULL;
}

//判断队列是否为空
bool IsEmpty(LinkQueue Q) {
    return Q.front == Q.rear;
}

//入队
void EnQueue(LinkQueue &Q, int data) {
    Node *p = (Node *)malloc(sizeof(Node));
    p->data = data;
    p->next = NULL;
    // 如果为不带头结点的入队操作，需加这一步
    /* 
    if (Q.front == NULL)
        Q.front = Q.rear = p; 
    */
    Q.rear->next = p;
    Q.rear = p;
}

//出队（带头结点）
bool DeQueue(LinkQueue &Q, int &data) {
    if (Q.front == Q.rear)
        return false;
    Node *p = Q.front->next;
    data = p->data;
    Q.front->next = p->next;
    if (Q.rear == p)    //如果是最后一个结点出队
        Q.rear = Q.front;
    // 不带头结点
    /*
    Node *p = Q.front;
    data = p->data;
    Q.front = p->next;
    if (Q.rear == p)
        Q.front = Q.rear = NULL;
    */
    free(p);
    return true;
}

//用输入的数据初始化一个队列
LinkQueue GetLinkQueue() {
    LinkQueue Q;
    InitHeadQueue(Q);
    int data = 0;
    cout << "请输入数据(如果要停止，请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000) {
        Node *p = (Node *)malloc(sizeof(Node));
        p->data = data;
        p->next = NULL;
        Q.rear->next = p;
        Q.rear = p;
        cout << "请输入数据(如果要停止，请输入-10000)：" << endl;
        cin >> data;
    }
    return Q;
}

void print(LinkQueue Q) {
    Node *temp = Q.front->next;
    while (temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}