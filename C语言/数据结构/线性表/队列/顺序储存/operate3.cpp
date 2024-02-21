#include "queue.h"
typedef struct SqQueue
{
    int data[MaxSize];
    int front, rear; //队头队尾指针
    bool flag;    //标志最近的操作，flase为删除，true为插入
} Queue;

//初始化队列
void InitQueue(Queue &Q) {
    Q.rear = Q.front = 0;
    Q.flag = false;
}

//判断队列是否为空
bool QueueEmpty(Queue Q) {
    if (Q.rear == Q.front && !Q.flag)
        return true;
    else
        return false;
}

//入队
bool EnQueue(Queue &Q, int data) {
    if (Q.rear == Q.front && Q.flag)
        return false;
    Q.data[Q.rear] = data;
    Q.flag = true;
    Q.rear = (Q.rear + 1) % MaxSize;
    return true;
}

//出队
bool DeQueue(Queue &Q, int &data) {
    if (Q.rear == Q.front && !Q.flag)
        return false;
    data = Q.data[Q.front];
    Q.flag = false;
    Q.front = (Q.front + 1) % MaxSize;
    return true;
}

//获得队头元素
bool GetHead(Queue Q, int &data) {
    if (Q.rear == Q.front && !Q.flag)
        return false;
    data = Q.data[Q.front];
    return true;
}

//以输入的数据初始化一个队列
Queue GetQueue() {
    Queue Q;
    InitQueue(Q);
    int data = 0;
    cout << "请输入数据(若要停止，请输入-10000)：" << endl;
    cin >> data;
    while (data != -10000) {
        if (Q.rear == Q.front && Q.flag)
            return Q;
        Q.data[Q.rear] = data;
        Q.flag = true;
        Q.rear = (Q.rear + 1) % MaxSize;
        cout << "请输入数据(若要停止，请输入-10000)：" << endl;
        cin >> data;
    }
    return Q;
}

void print(Queue Q) {
    if (Q.rear == Q.front && !Q.flag)
        return;
    else {
        cout << Q.data[Q.front] << " ";
        int temp = (Q.front + 1) % MaxSize;
        while (temp != Q.rear){
            cout << Q.data[temp] << " ";
            temp = (temp + 1) % MaxSize;
        }
    }
}