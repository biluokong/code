#pragma once
#include <stdlib.h>
#include <stdio.h>
typedef int ElemType;

struct SSTable {    //查找表的数据结构（顺序表）
    ElemType* elem;     //动态数组基址
    int TableLen;       //表的长度
};

//分块有序表的特点：块内无序、块间有序（扩展：若查找表是动态查找表，链式实现更好）
struct Index {      //分块查找的索引表
    ElemType maxValue;  //区间的最大关键字
    int low, high;      //区间的边界索引
};