#include "queue.h"

typedef struct SqQueue{
    int data[MaxSize];
    int front, rear; //队头队尾指针
    int size;   //储存队列当前长度
} Queue;

//初始化队列
void InitQueue(Queue &Q) {
    Q.rear = Q.front = Q.size = 0;
}

//判断队列是否为空
bool QueueEmpty(Queue Q){
    return Q.size == 0;
}

//入队
bool EnQueue(Queue &Q, int data) {
    if (Q.size == MaxSize)
        return false;
    Q.data[Q.rear] = data;
    Q.size++;
    Q.rear = (Q.rear + 1) % MaxSize;
    return true;
}

//出队
bool DeQueue(Queue &Q, int &data) {
    if (Q.size == 0)
        return false;
    data = Q.data[Q.front];
    Q.size--;
    Q.front = (Q.front + 1) % MaxSize;
    return true;
}

//获得队头元素
bool GetHead(Queue Q, int &data){
    if (Q.size == 0)
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
        if (Q.size == MaxSize)
            return Q;
        Q.data[Q.rear] = data;
        Q.size++;
        Q.rear = (Q.rear + 1) % MaxSize;
        cout << "请输入数据(若要停止，请输入-10000)：" << endl;
        cin >> data;
    }
    return Q;
}

void print(Queue Q) {
    int temp = Q.front;
    for (int i = 0; i < Q.size; i++) {
        cout << Q.data[temp] << " ";
        temp = (temp + 1) % MaxSize;
    }
}
