#include "tree.h"
#include "operate.cpp"

int main(){
    BiTree root = (BiTree)malloc(sizeof(BTNode));
    root->data = 0;
    root->lchild = NULL;
    root->rchild = NULL;
    /* BTNode *p = root, *t = NULL;
    for (int i = 1; i <= 6; i++){
        t = (BTNode *)malloc(sizeof(BTNode));
        t->data = i;
        t->lchild = NULL;
        t->rchild = NULL;
        if (p->lchild == NULL)
            p->lchild = t;
        else{
            p->rchild = t;
            p = p->lchild;
        }
    } */
    //Insert(root);
    BiTree t;
    PreCreate(&t);
    //PreOrder(root);
    //printf("\n");
    //p = root->lchild->lchild;
    //InOrder(t);
    LevelOrder(t);
    printf("\n");
    printf("%d", getDepthByMaxSum(t));
    //printf("%d", IsCBTree(t));
    //printf("%d %d %d", current->data, pre->data, post->data);
    //PostOrder(root); */
    //PrintBiTree(root, 0);
    //LevelOrder(root);
    //printf("\n");
    //PostOrderByStack(t);
    /* printf("%d ", CountLeaf(t));
    printf("%d ", CountNode(t));
    printf("%d ", CountOneChild(t));
    printf("%d ", CountTwoChild(t)); */

    //printf("%d", GetTreeDepth(root));
    return 0;
}