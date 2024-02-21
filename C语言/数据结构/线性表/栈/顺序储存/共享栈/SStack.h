#pragma once
#include<stdlib.h>
#include<stdio.h>
#include<iostream>
using namespace std;
#define MaxSize 10

typedef struct SSqStack {
    int data[MaxSize];
    int top1;
    int top2;
} SStack;