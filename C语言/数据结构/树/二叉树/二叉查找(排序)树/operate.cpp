#include "tree.h"
#define N 10

//中序遍历
void InOrder(BSTree T){
    if (T){
        InOrder(T->lchild);
        printf("%d ", T->key);
        InOrder(T->rchild);
    }
}

//找到第k个最小元素
void SearchByK(BSTree T, int k){
    static int count = 0;
    if (T){
        SearchByK(T->lchild, k);
        if (++count == k){
            printf("%d", T->key);
            return;
        }
        SearchByK(T->rchild, k);
    }
}

//插入（可以用递归或普通循环，普通循环二级指针的坑真大，灵光一闪才想到解决方法）
//用引用或二级指针都一样，只需修改参数类型和p的赋值即可
bool Insert(BSTree &T, Type key){
    //Node **p = T;     //参数为二级指针时的赋值
    Node **p = &T;      //参数为引用时的赋值
    while (*p != NULL){
        if (key < (*p)->key)
            p = &((*p)->lchild);
        else if (key > (*p)->key)
            p = &((*p)->rchild);
        else    //如果有相同key
            return false;
    }
    *p = (Node *)malloc(sizeof(Node));
    (*p)->key = key;
    (*p)->lchild = (*p)->rchild = NULL;
    return true;
}

//插入，递归方法
bool InsertByRecursion(BSTree &T, Type key){
    if (!T){
        T = (Node *)malloc(sizeof(Node));
        T->key = key;
        T->lchild = T->rchild = NULL;
        return true;
    }
    if (key == T->key)
        return false;
    else if (key < T->key)
        return InsertByRecursion(T->lchild, key);
    else
        return InsertByRecursion(T->rchild, key);
}

//在二叉树中查找key为指定值的结点，找不到返回NULL
//可以返回值为bool，没找到返回叶子结点给传入的参数，返回false（方便另外的方法完成插入）
Node* Search(BSTree T, Type key){
    Node *p = T;
    while (p && p->key != key)
        key < p->key ? p = p->lchild : p = p->rchild;
    return p;
}

//删除指定key的结点，传入参数为一级指针（缺点：删除根结点会使代码较复杂）
// 3、删除结点有左子树和右子树：（实际有时只需移动数据即可，不需移动结点）
//法1：用删除结点的直接后继(右子树最小)代替它（右子树中序遍历的第一个结点，即右子树最左下结点）
//法2：用删除结点的直接前驱(左子树最大)代替它
bool Delete(BSTree T, Type key){
    Node *p = T, *t = NULL;
    while (p && p->key != key){
        t = p;  //t保存p结点的父结点
        key < p->key ? p = p->lchild : p = p->rchild;
    }
    if (p == NULL)  //如果没有找到含指定key的结点
        return false;
    if (!p->lchild && !p->rchild){ //删除结点是叶子结点：直接删除
        if (p == T) //如果删除的叶子结点是根结点，无法删除
            return false;
        t->lchild == p ? t->lchild = NULL : t->rchild = NULL;
        free(p);
    }
    else if (p->lchild && p->rchild){ //删除结点有左子树和右子树，用法1(对根结点也可行)
        Node *s = p->lchild;
        while (s->rchild != NULL){
            t = s;
            s = s->rchild;
        }
        p->key = s->key;
        if (s == p->lchild)  //左孩子没有右孩子
            p->lchild = s->lchild;
        else
            t->rchild = s->lchild;
        free(s);
    }
    else{ //删除结点只有一个子树
        if (p == T){ //如果删除结点并且为根结点
            if (p->lchild){ //如果根结点只有左孩子，找左子树最右下结点
                Node *s = p->lchild;
                while (s->rchild != NULL)
                {
                    t = s;
                    s = s->rchild;
                }
                p->key = s->key;
                if (s == p->lchild) //左孩子没有右孩子
                    p->lchild = s->lchild;
                else
                    t->rchild = s->lchild;
                free(s);
            }
            else {  //如果根结点只有右孩子，找右子树的最左下结点
                Node *s = p->rchild;
                while (s->lchild != NULL){
                    t = s;
                    s = s->lchild;
                }
                p->key = s->key;
                if (s == p->rchild) //右孩子没有左孩子
                    p->rchild = s->rchild;
                else
                    t->lchild = s->rchild;
                free(s);
            }
        }
        else{   //删除结点不为根结点
            if (t->lchild == p)
                p->lchild != NULL ? t->lchild = p->lchild : t->lchild = p->rchild;
            else
                p->lchild != NULL ? t->rchild = p->lchild : t->rchild = p->rchild;
            free(p);
        }
    }
    return true;
}

//删除含指定key的结点，传入参数为二级指针
bool Delete(BSTree *T, Type key){
    Node **p = T, *t = NULL, *s = NULL;
    while (*p && (*p)->key != key)
        key < (*p)->key ? p = &((*p)->lchild) : p = &((*p)->rchild);
    if (!(*T))
        return false;
    if (!(*p)->lchild || !(*p)->rchild){    //如果没有右子树或左子树
        t = *p;
        if (!(*p)->lchild)
            (*p) = (*p)->rchild;
        else
            (*p) = (*p)->lchild;
        free(t);
    }
    else { //如果左右子树都不为空
        t = *p;
        s = (*p)->lchild;
        while (s->rchild){  //删除结点如果有左子树，找到左子树最右下结点
            t = s;
            s = s->rchild;
        }
        (*p)->key = s->key;
        if (s == (*p)->lchild)  //如果被删除结点的左孩子没有右子树
            t->lchild = s->lchild;
        else  //如果被删除结点的左孩子有右子树
            t->rchild = s->lchild;
        free(s);
    }
    return true;
}

//根据所给数据获得一个二叉查找树
BSTree GetTree(){
    BSTree T = NULL;
    Type key;
    printf("请输入数据（输入-1停止）：\n");
    while (true){
        scanf("%d", &key);
        if (key == -1)
            break;
        Insert(T, key);
        //InsertByRecursion(T, key);
    }
    return T;
}