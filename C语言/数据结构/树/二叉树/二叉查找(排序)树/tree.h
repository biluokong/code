#pragma once
#include<stdlib.h>
#include<stdio.h>
typedef int Type;

typedef struct BSTNode{
    Type key;
    BSTNode *lchild, *rchild;
} Node, *BSTree;