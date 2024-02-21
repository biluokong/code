#include <stdlib.h>
#include <stdio.h>
typedef char Data;

typedef struct BTreeNode{
    Data data;                  //数据
    BTreeNode *lchild, *rchild; //左后孩子
} BTNode, *BTree;

//打印结点数据
void print(BTNode node) {
    printf("%c ", node.data);
}

//先序遍历结点
void traver(BTNode *node) {
    if (node != NULL) {
        print(*node);
        traver(node->lchild);
        traver(node->rchild);
    }
}

//左插入结点
BTNode* InsertLeftNode(BTNode *node, Data data) {
    if (node == NULL)
        return NULL;
    BTNode *t = node->lchild, *p = (BTNode *)malloc(sizeof(BTNode));
    p->data = data;
    p->lchild = t;
    p->rchild = NULL;
    node->lchild = p;
    return node->lchild;
}

//右插入结点
BTNode *InsertRightNode(BTNode *node, Data data) {
    if (node == NULL)
        return NULL;
    BTNode *t = node->rchild, *p = (BTNode *)malloc(sizeof(BTNode));
    p->data = data;
    p->lchild = NULL;
    p->rchild = t;
    node->rchild = p;
    return node->rchild;
}

int main(){
    //顺序储存法
    Data data[10] = {};
    data[0] = 'A';
    data[1] = 'B';
    data[2] = 'E';
    data[4] = 'C';
    data[6] = 'F';
    data[9] = 'D';
    printf("顺序储存，层次遍历：\n");
    for (int i = 0; i < 10; i++){
        if (data[i] != '\0')
            printf("%c ", data[i]);
    }

    //链式直接储存
    BTree root = (BTNode *)malloc(sizeof(BTNode));
    root->data = 'A';
    root->lchild = (BTNode *)malloc(sizeof(BTNode));
    root->lchild->data = 'B';
    root->rchild = (BTNode *)malloc(sizeof(BTNode));
    root->rchild->data = 'E';
    root->lchild->lchild = NULL;
    root->lchild->rchild = (BTNode *)malloc(sizeof(BTNode));
    root->lchild->rchild->data = 'C';
    root->rchild->lchild = NULL;
    root->rchild->rchild = (BTNode *)malloc(sizeof(BTNode));
    root->rchild->rchild->data = 'F';
    root->rchild->rchild->lchild = NULL;
    root->rchild->rchild->rchild = NULL;
    root->lchild->rchild->lchild = (BTNode *)malloc(sizeof(BTNode));
    root->lchild->rchild->lchild->data = 'D';
    root->lchild->rchild->lchild->lchild = NULL;
    root->lchild->rchild->lchild->rchild = NULL;
    root->lchild->rchild->rchild = NULL;
    printf("\n链式直接储存，先序遍历：\n");
    traver(root);

    //链式非直接储存
    BTree bTree = (BTNode *)malloc(sizeof(BTNode));
    bTree->data = 'A';
    bTree->lchild = NULL;
    bTree->rchild = NULL;
    BTNode *p = InsertLeftNode(bTree, 'B');
    p = InsertRightNode(p, 'C');
    InsertLeftNode(p, 'D');
    p = InsertRightNode(bTree, 'E');
    InsertRightNode(p, 'F');
    printf("\n链式非直接储存，先序遍历：\n");
    traver(bTree);
    return 0;
}