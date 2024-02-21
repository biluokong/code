#include "queue.h"

typedef struct SqQueue{
    int data[MaxSize];
    int front, rear; //队头队尾指针
} Queue;
//此队列操作需要留一个空间不使用，以区别队空和队满两种情况

//初始化队列
void InitQueue(Queue &Q) {
    Q.front = Q.rear = 0;
}

//判断队列是否为空
bool QueueEmpty(Queue Q) {
    if (Q.rear == Q.front)
        return true;
    else
        return false;
}

//入队，为了有效利用空间，用模运算将储存空间在逻辑上变成了“环状”
bool EnQueue(Queue &Q, int data) {
    if ((Q.rear + 1) % MaxSize == Q.front)
        return false;
    Q.data[Q.rear] = data;
    Q.rear = (Q.rear + 1) % MaxSize;
    return true;
}

//出队
bool DeQueue(Queue &Q, int &data) {
    if (Q.rear == Q.front)
        return false;
    data = Q.data[Q.front];
    Q.front = (Q.front + 1) % MaxSize;
    return true;
}

//获得队头元素
bool GetHead(Queue &Q, int &data) {
    if (Q.rear == Q.front)
        return false;
    data = Q.data[Q.front];
    return true;
}

//以输入的数据初始化一个队列
Queue GetQueue() {
    Queue Q;
    InitQueue(Q);
    int data = 0;
    cout << "请你输入数据(若要停止，请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000) {
        if ((Q.rear + 1) % MaxSize == Q.front)
            return Q;
        Q.data[Q.rear] = data;
        Q.rear = (Q.rear + 1) % MaxSize;
        cout << "请你输入数据(若要停止，请输入-10000)：" << endl;
        cin >> data;
    }
    return Q;
}

void print(Queue Q) {
    if (Q.rear == Q.front)
        return;
    int temp = Q.front;
    while (temp != Q.rear) {
        cout << Q.data[temp] << " ";
        temp = (temp + 1) % MaxSize;
    }
}