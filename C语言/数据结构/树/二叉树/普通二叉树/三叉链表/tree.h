#pragma once
#include <stdlib.h>
#include <stdio.h>
typedef int Data;

typedef struct BTreeNode{
    Data data;  //数据
    BTreeNode *lchild, *rchild;  //左后孩子
    BTreeNode *parent;  //双亲结点
} BTNode, *BTree;