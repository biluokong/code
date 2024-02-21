#pragma once
#include<stdlib.h>
#include<stdio.h>
#define MaxBit 6

struct HaffNode{    //哈夫曼树的结点
    int weight;     //权值
    bool flag;      //是否加入了哈夫曼树的标志
    int parent, lchild, rchild;
};

struct Code{    //字符的哈夫曼编码
    int bit[MaxBit];    //数组
    int start;          //编码的起始下标
    int weight;         //字符的权值
};