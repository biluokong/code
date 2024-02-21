#include<stdlib.h>
#include<stdio.h>
typedef char DataType;
typedef struct QNode{
    DataType data;
    QNode *next;
} Node;
struct Queue{
    Node *front;
    Node *rear;
};