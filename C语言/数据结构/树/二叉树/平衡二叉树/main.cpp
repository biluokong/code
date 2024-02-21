#include "tree.h"
#include "operate.cpp"

int main(){
    char str[] = "5281034";
    AVLTree T = CreatTree(str);
    InOrder(T);
    printf("\n%d\n", TreeHeight(T));
    printf("%c", T->rchild->lchild->rchild->key);
    return 0;
}