#include "tree.h"

//初始化一个顺序储存的二叉树
void InitBTree(BTree bTree){
    for (int i = 0; i < MaxSize; i++)
        bTree[i].isEmpty = true;
}

//判断某一结点是否有左孩子
bool IsHasLeftChild(int index, BTree bTree){
    int leftChildIndex = 2 * index + 1;
    return (leftChildIndex < MaxSize) && !bTree[leftChildIndex].isEmpty;
}

//获得某一结点的左孩子。有就返回其左孩子的下标，没有返回-1
int GetLeftChild(int index, BTree bTree){
    if (!IsHasLeftChild(index, bTree))
        return -1;
    return 2 * index + 1;
}

//判断某一结点是否有右孩子
bool IsHasRightChild(int index, BTree bTree){
    int rightChildIndex = 2 * index + 2;
    return (rightChildIndex < MaxSize) && !bTree[rightChildIndex].isEmpty;
}

//获得某一结点的右孩子。有就返回其右孩子的下标，没有返回-1
int GetRightChild(int index, BTree bTree){
    if (!IsHasRightChild(index, bTree))
        return -1;
    return 2 * index + 2;
}

//判断某一结点是叶子结点还是分支结点
bool IsLeaf(int index, BTree bTree){
    return (index > (MaxSize - 1) / 2) && !bTree[index].isEmpty;
}

//获得某一结点的父结点。有就返回其下标，没有返回-1(它是根结点)
bool GetParent(int index){
    return (index - 1) / 2;
}

//获得某一结点的深度（根结点深度为1）
int GetDepth(int index){
    return (int)floor(log(index + 1) / log(2));
}
