#include "tree.h"
#include "operate.cpp"

int main(){
    BSTree T = GetTree();
    InOrder(T);
    //Node *p = Search(T, 2);
    //printf("\n%d\n", p->key);
    // Delete(&T, 5);
    printf("\n");
    SearchByK(T, 5);
    // InOrder(T);
    return 0;
}