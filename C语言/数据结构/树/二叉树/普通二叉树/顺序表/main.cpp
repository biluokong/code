#include "tree.h"
#include "operate.cpp"

/*
 * 顺序储存只适合储存完全二叉树，储存普通二叉树会浪费大量空间 
*/
int main(){
    BTree bTree;
    InitBTree(bTree);
    for (int i = 0; i < MaxSize; i++){
        bTree[i].data = i;
        bTree[i].isEmpty = false;
    }
    printf("%d ", IsHasLeftChild(4, bTree));
    printf("%d ", IsHasRightChild(4, bTree));
    printf("%d ", IsHasLeftChild(5, bTree));
    printf("%d ", GetDepth(5));
    return 0;
}