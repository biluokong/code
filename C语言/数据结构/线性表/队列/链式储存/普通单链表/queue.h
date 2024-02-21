#pragma once
#include<stdlib.h>
#include<stdio.h>
#include<iostream>
using namespace std;

typedef struct LinkNode{
    int data;   //数据域
    LinkNode *next; //指针域
} Node;

struct LinkQueue{
    LinkNode *front, *rear; //队列的队头和队尾指针
};