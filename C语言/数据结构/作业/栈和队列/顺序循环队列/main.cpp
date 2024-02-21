#include <stdlib.h>
#include <stdio.h>
#define MaxSize 10
typedef int Data;

typedef struct SqQueue
{
    Data data[MaxSize];
    int front, rear; //队头队尾指针
    int length;        //储存队列当前元素个数
    int size;   //储存队列的长度
} Queue;

//初始化队列
void InitQueue(Queue &Q)
{
    Q.rear = Q.front = Q.length = 0;
    Q.size = MaxSize;
}

//入队
bool EnQueue(Queue &Q, Data data)
{
    if (Q.length == Q.size)
        return false;
    Q.data[Q.rear] = data;
    Q.length++;
    Q.rear = (Q.rear + 1) % Q.size;
    return true;
}

//出队
bool DeQueue(Queue &Q, Data &data)
{
    if (Q.length == 0)
        return false;
    data = Q.data[Q.front];
    Q.length--;
    Q.front = (Q.front + 1) % Q.size;
    return true;
}

int main(){
    Queue Q;
    InitQueue(Q);
    EnQueue(Q, 3);
    EnQueue(Q, 8);
    EnQueue(Q, 5);
    Data data = 0;
    while (DeQueue(Q, data))
        printf("%d ", data);
    return 0;
}
