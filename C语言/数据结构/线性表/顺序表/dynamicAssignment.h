#pragma once
#include <iostream>
using namespace std;
#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#define InitSize 5 //默认最大长度
struct SeqList
{
    int *data;   //指示动态分配数组的指针
    int MaxSize; //顺序表的最大容量
    int length;
};