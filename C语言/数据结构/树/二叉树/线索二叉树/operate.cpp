#include "tree.h"

TBNode *pre = NULL; //指向当前访问结点在序列中的前驱
//线索化的最后一个访问的结点可以指向根结点或NULL；前者可以到达类似循环链表的效果

//打印结点数据
void print(TBNode *node){
    printf("%d ", node->data);
}

void visitThread(TBNode *node){
    print(node);
    //左子树为空，建立当前结点的前驱线索，指向上一个访问的结点（或NULL）
    if (node->lchild == NULL){  
        node->lchild = pre;
        node->ltag = true;
    }
    //如果当前结点的前驱结点不为空，且其右子树为空；建立前驱结点的的后继线索，指向当前结点
    if (pre != NULL && pre->rchild == NULL){
        pre->rchild = node;
        pre->rtag = true;
    }
    pre = node; 
}

//递归实现先序遍历线索化二叉树
void PreThread(TBNode *node, void (*visit)(TBNode *node)){
    if (node != NULL){
        (*visit)(node);
        //如果左子树有孩子才继续遍历
        //加此判断的原因：线索化会让node.lchild不为空，造成死循环
        if (node->ltag == 0)    
        PreThread(node->lchild, visit);
        PreThread(node->rchild, visit);
    }
}

//递归实现中序遍历线索化二叉树
void InThread(TBNode *node, void (*visit)(TBNode *node)){
    if (node != NULL){
        InThread(node->lchild, visit);
        (*visit)(node);
        InThread(node->rchild, visit);
    }
}

//递归实现后序遍历线索化二叉树
void PostThread(TBNode *node, void (*visit)(TBNode *node)){
    if (node != NULL){
        PostThread(node->lchild, visit);
        PostThread(node->rchild, visit);
        (*visit)(node);
    }
}

//中序线索化二叉树
void CreatInThread(ThreadBiTree T){
    pre = NULL;
    if (T != NULL){
        InThread(T, visitThread);
        //当遍历完所有结点，需要检查pre是否有右孩子，没有令pre.rtag=true
        //其实此判断操作多余了，因为中序遍历完后，最后一个结点肯定无右孩子,否则会继续遍历
        //所以这里可以直接令pre.rtag = true
        if (pre->rchild == NULL)
            pre->rtag = true;
    }
}

//先序线索化二叉树
void CreatPreThread(ThreadBiTree T){
    pre = NULL;
    if (T != NULL){
        PreThread(T, visitThread);
        //当遍历完所有结点，需要检查pre是否有右孩子，没有令pre.rtag=true
        //其实此判断操作多余了，因为先序遍历完后，最后一个结点肯定无右孩子,否则会继续遍历
        //所以这里可以直接令pre.rtag = true
        if (pre->rchild == NULL)
            pre->rtag = true;
    }
}

//后序线索化二叉树
void CreatPostThread(ThreadBiTree T){
    pre = NULL;
    if (T != NULL){
        PostThread(T, visitThread);
        //当遍历完所有结点，需要检查pre是否有右孩子，没有令pre.rtag=true
        //后序遍历中此判断操作则是必要的,因为最后访问的结点是根结点
        if (pre->rchild == NULL)
            pre->rtag = true;
    }
}

//在中序线索二叉树中找到结点为p（把p当作根结点）的后继结点
TBNode* NextInOrderNode(TBNode *node){
    //如果该结点有右子树，则它的后继结点为右子树上最左下的结点（因为是中序遍历）
    TBNode *p = node;
    if (p->rtag == 0){
        p = p->rchild;
        while (p->ltag == 0)
            p = p->lchild;
        return p;
    }
    else    //如果该结点有后继线索（即没有右孩子），则该线索所指就是后继结点
        return p->rchild;
}

//在中序线索二叉树中找到结点为p（把p当作根结点）的前驱结点
TBNode* PreInOrderNode(TBNode *node){
    //如果该结点有左子树，则它的前驱结点为左子树最右下的结点
    TBNode *p = node;
    if (p->ltag == 0){
        p = p->lchild;
        while (p->rtag == 0)
            p = p->rchild;
        return p;
    }
    else    //如果该结点有前驱线索，则该线索所指就是前驱结点
        return p->lchild;
}

//利用线索实现中序遍历二叉树（对中序序列的任意结点）
//即按原序列顺序遍历指定结点后面的结点
void InOrder(ThreadBiTree T){
    for (TBNode *p = T; p; p = NextInOrderNode(p))
        print(p);
}

//即按原中序序列顺序逆向遍历指定结点前面的结点
void RevInOrder(ThreadBiTree T){
    for (TBNode *p = T; p; p = PreInOrderNode(p))
        print(p);
}

//找前序线索二叉树某结点的后继结点。二叉链表的前序线索二叉树无法直接找到其前驱结点
//除非使用三叉链表或者用土办法从头来一遍先序遍历
TBNode* NextPreOrderNode(TBNode *node){
    if (node->ltag == 0)   //如果它有左孩子，则左孩子就为其后继结点
        return node->lchild;
    return node->rchild;   //如果它没有左孩子，则其右孩子或后继线索就为其后继结点
}

//找后序线索二叉树某结点的前驱结点。二叉链表的后序线索二叉树无直接找到其后继结点
//除非使用三叉链表或者从头来一遍后序遍历
TBNode* PrePostOrderNode(TBNode *node){
    if (node->rtag == 0)    //有右孩子，则右孩子就为其前驱结点
        return node->rchild;
    return node->lchild;    //没有右孩子，则左孩子就为其前驱结点
}

//按先序顺序创建一个二叉树
void PreCreate(TBNode* &node){
    // printf("请输入要插入的数据(输入0停止)：");
    ElemType data;
    scanf("%d", &data);
    if (data == 0)
        return;
    node = (TBNode *)malloc(sizeof(TBNode));
    if (node == NULL)
        return;
    node->data = data;
    node->lchild = NULL;
    node->rchild = NULL;
    PreCreate(node->lchild);
    PreCreate(node->rchild);
}