#pragma once
#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;

typedef struct LNode
{
    int data;
    struct LNode *next;
} * CLinkList;

typedef struct DNode
{
    int data;
    DNode *prior, *next;
} * CDLinkList;