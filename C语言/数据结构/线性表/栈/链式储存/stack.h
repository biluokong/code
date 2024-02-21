#pragma once
#include<stdlib.h>
#include<stdio.h>
#include<iostream>
using namespace std;

typedef struct LinkNode {
    int data;
    LinkNode *next;
} Node, *LinkStack;