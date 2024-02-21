#pragma once
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;
#define MaxSize 10

typedef struct SqStack
{
    int data[MaxSize];  //静态数组存放栈中数据
    int top;    //栈顶指针
} Stack;

