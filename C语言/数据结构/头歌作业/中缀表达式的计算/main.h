#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef double T;
struct LNode
{
    T data;
    LNode *next;
};

struct LinkStack
{
    LNode *top; 
    int len;    
};
////////////////////////////////////////////
LinkStack *LS_Create();
void LS_Free(LinkStack *ls);
void LS_MakeEmpty(LinkStack *ls);
bool LS_IsEmpty(LinkStack *ls);
int LS_Length(LinkStack *ls);
void LS_Push(LinkStack *ls, T x);
bool LS_Pop(LinkStack *ls, T &item);
bool LS_Top(LinkStack *ls, T &item);
void LS_Print(LinkStack *ls);
void compute(LinkStack *so, LinkStack *sd);
double ComputeInfix(char *s);
