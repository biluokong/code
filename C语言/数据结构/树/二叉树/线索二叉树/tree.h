#pragma once
#include <stdlib.h>
#include <stdio.h>
typedef int ElemType;

typedef struct ThreadNode{
    ElemType data;  //数据
    ThreadNode *lchild, *rchild;    //左右孩子或线索
    bool ltag, rtag;    //左右孩子的线索标志（tag=0表示指向孩子，tag=1表示指针是“线索”）
} TBNode, *ThreadBiTree;