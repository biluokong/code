#pragma once
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
typedef char Type;
//为平衡二叉树的二叉排序树，查找效率能达到 O(log₂n)
typedef struct AVLNode{
    Type key;   
    int balance;    //平衡因子（等于左子树高-右子树高；对AVL树，值只能为-1、0、1）
    AVLNode *lchild, *rchild;
} Node, *AVLTree;