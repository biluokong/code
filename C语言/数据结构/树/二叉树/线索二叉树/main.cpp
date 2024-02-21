#include "tree.h"
#include "operate.cpp"

int main(){
    ThreadBiTree T;
    T = (ThreadBiTree)malloc(sizeof(TBNode));
    PreCreate(T);
    CreatInThread(T);
    printf("\n");
    //未线索化前可以使用下面这行代码，对二叉树进行遍历，但不能对线索二叉树进行遍历
    //InThread(T, print);
    RevInOrder(T->lchild->lchild->lchild);
    printf("\n");
    InOrder(T->lchild->lchild->lchild);
    //InOrder(T->lchild->lchild->lchild);
    return 0;
}