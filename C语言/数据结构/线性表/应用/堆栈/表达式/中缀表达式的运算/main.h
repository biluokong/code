#pragma once
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define MaxSize 30

struct CharStack {
    char data[MaxSize];
    int top;
};

struct NumStack {
    int data[MaxSize];
    int top;
};

struct DoubleStack {
    double data[MaxSize];
    int top;
};