#include "queue.h"

void InitQueue(Queue &q){
    q.front = NULL;
    q.rear = NULL;
}

bool EnQueue(Queue &q, DataType data){
    Node *p = (Node *)malloc(sizeof(Node));
    p->data = data;
    
}