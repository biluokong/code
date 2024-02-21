#pragma once
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#define MaxSize 10
typedef int ElemType;

typedef struct BiTreeNode{
    ElemType data;  //数据
    bool isEmpty;
} BTNode, BTree[MaxSize];