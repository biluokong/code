#include "tree.h"

//中序遍历
void InOrder(AVLTree T){
    if (T)
    {
        InOrder(T->lchild);
        printf("%c ", T->key);
        InOrder(T->rchild);
    }
}

//获得树的高度
int TreeHeight(AVLTree T){
    if (!T)
        return 0;
    int l = TreeHeight(T->lchild);
    int r = TreeHeight(T->rchild);
    return l > r ? l + 1 : r + 1;
}

//右旋，作LL调整
void R_Rotate(Node **p){
    Node *L = (*p)->lchild;
    (*p)->lchild = L->rchild;
    L->rchild = *p;
    *p = L;
}

//左旋，作RR调整
void L_Rotate(Node **p){
    Node *R = (*p)->rchild;
    (*p)->rchild = R->lchild;
    R->lchild = *p;
    *p = R;
}

//左旋再右旋，作LR调整（不使用平衡因子）
void LR_Rotate(Node **p){
    L_Rotate(&((*p)->lchild));
    R_Rotate(p);
}

//右旋再左旋，作RL调整（不使用平衡因子）
void RL_Rotate(Node **p){
    R_Rotate(&((*p)->rchild));
    L_Rotate(p);
}

//插入（不使用平衡因子）
Node* Insert(AVLTree &T, Node *p){
    if (!T)
        return p;
    if (p->key == T->key)
        return T;
    else if (p->key < T->key)
        T->lchild = Insert(T->lchild, p);
    else
        T->rchild = Insert(T->rchild, p);

    //使用平衡因子让树平衡
    /* T->balance = TreeHeight(T->lchild) - TreeHeight(T->rchild);//给平衡因子赋值
    if (abs(T->balance) > 1) {
        if (T->key > p->key){ //如果新插入结点在当前最小不平衡结点的左孩子上
            if (T->lchild->balance > 0)
                R_Rotate(&T); //作LL调整，右旋
            else
                LR_Rotate(&T); //左LR调整
        }
        else{
            if (T->rchild->balance < 0)
                L_Rotate(&T); //作RR调整
            else
                RL_Rotate(&T); //左RL调整
        }
    } */

    //让树是平衡的（不使用平衡因子）
    if (abs(TreeHeight(T->lchild) - TreeHeight(T->rchild)) > 1){
        if (T->key > p->key){    //如果新插入结点在当前最小不平衡结点的左孩子上
            if (T->lchild->key > p->key)    //如果新插入结点在左孩子的左子树上
                R_Rotate(&T);   //作LL调整，右旋
            else    //如果新插入结点在左孩子的右子树上
                LR_Rotate(&T);  //左LR调整
        }
        else{    //如果新插入结点在当前最小不平衡结点的右孩子上
            if (T->rchild->key < p->key)    //如果新插入结点在右孩子的右子树上
                L_Rotate(&T);   //作RR调整
            else    //如果新插入结点在右孩子的左子树上
                RL_Rotate(&T);  //左RL调整
        }
    }
    return T;
}

//创建平衡二叉树（不使用平衡因子）
Node* CreatTree(char *str){
    AVLTree T = NULL, p = NULL;
    while (*str){
        p = (Node *)malloc(sizeof(Node));
        p->key = *str;
        p->lchild = p->rchild = NULL;
        T = Insert(T, p);
        str++;
    }
    return T;
}