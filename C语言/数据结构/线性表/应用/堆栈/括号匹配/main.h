#pragma once
#include<stdlib.h>
#include<stdio.h>
#define MaxSize 20

struct CharStack {
    char data[MaxSize];
    int top;
};

struct NumStack {
    int data[MaxSize];
    int top;
};