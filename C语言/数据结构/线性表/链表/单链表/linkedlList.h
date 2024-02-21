#pragma once
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;

typedef struct LNode
{
    int data;
    struct LNode *next;
} node, *LinkList;