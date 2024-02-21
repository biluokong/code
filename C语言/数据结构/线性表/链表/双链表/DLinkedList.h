#pragma once
#include<stdlib.h>
#include<stdio.h>
#include<iostream>
using namespace std;

typedef struct DNode{
    int data;
    DNode *prior, *next;
} node, *DLinkList;