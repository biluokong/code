#include "tree.h"
BTNode *p;  //p指向目标结点
BTNode *pre = NULL; //指向目标结点的前驱（序列意义上的前驱和后继）
BTNode *post = NULL;      //指向目标结点的后继（序列意义上的前驱和后继）
BTNode *current = NULL;   //记录当前访问结点
bool flag = false;  //标志是否也获得了目标结点的前驱

//打印结点数据
void print(BTNode node){
    printf("%d ", node.data);
}

void visit(BTNode *node){
    //打印结点数据
    print(*node);

    //获得序列中某结点的前驱和后继
    /* if (node == p){  //当前访问的结点刚好是目标结点p
        pre = current;    //最终结果就为p结点的前驱结点
        flag = true;
    }
    else{    
        current = node;    //pre指向当前访问的结点
        if (flag){
            post = node; //最终结果就为p结点的后继结点
            flag = false;
        }
    } */
        
}

//打印二叉树
void PrintBiTree(BiTree T, int n){
    int i;
    if (T == NULL)
        return;
    PrintBiTree(T->rchild, n + 1);
    for (i = 0; i < n -1; i++)
        printf("   ");
    if (n > 0){
        printf("---");
        printf("%d\n", T->data);
    }
    PrintBiTree(T->lchild, n + 1);
}

//递归实现先序遍历
void PreOrder(BTNode *node){
    if (node != NULL){
        visit(node);
        PreOrder(node->lchild);
        PreOrder(node->rchild);
    }
}

//递归实现中序遍历
void InOrder(BTNode *node){
    if (node != NULL){
        InOrder(node->lchild);
        visit(node);
        InOrder(node->rchild);
    }
}

//递归实现后序遍历
void PostOrder(BTNode *node){
    if (node != NULL)   {
        PostOrder(node->lchild);
        PostOrder(node->rchild);
        visit(node);
    }
}

//使用栈实现先序遍历
void PreOrderByStack(BiTree T){
    if (T == NULL)
        return;
    LinkStack S;
    InitStack(S);
    BTNode *p;
    //方法一：先让分支结点入栈，如果弹出并访问它；之后让该结点的右孩子、左孩子入栈;一直重复
    Push(S, T);
    while (!IsEmpty(S)){
        Pop(S, p);
        print(*p);
        if (p->rchild != NULL)
            Push(S, p->rchild);
        if (p->lchild != NULL)
            Push(S, p->lchild);
    }
    //方法二：先访问分支结点，再让它入栈；然后访问左孩子，并将它入栈；
    //一直重复到左孩子为叶子结点后，回溯到双亲结点，再访问右孩子......
    /* p = T;
    while ( p || !IsEmpty(S)){
        if (p){
            print(*p);
            Push(S, p);
            p = p->lchild;
        }
        else {
            Pop(S, p);
            p = p->rchild;
        }
    } */
}

//使用栈实现中序遍历（类似前序遍历方法二，只是访问时节不一样）
void InOrderByStack(BiTree T){
    if (T == NULL)
        return;
    LinkStack S;
    InitStack(S);
    BTNode *p = T;
    while ( p || !IsEmpty(S)){
        while (p) {
            Push(S, p);
            p = p->lchild;
        }
        Pop(S, p);
        print(*p);
        p = p->rchild;
    }
}

//使用栈实现后序遍历（用一个栈实现或两个栈实现）
//用一个栈实现有两种方法（根据某结点的访问次数 或 先根右左反着实现，再将结果反置）
//两个栈实现：一个栈实现根右左，再将结果反过来放入另一个栈
void PostOrderByStack(BiTree T){
    if (!T)
        return;
    LinkStack S;
    InitStack(S);
    BTNode *p = T, *pre = NULL;
    //一个栈实现
    //在结点第二次访问或其右孩子为null时弹出并获取值（使用hashmap或一个结点记录访问次数）
    /* while ( p || !IsEmpty(S)){
        while (p){
            Push(S, p);
            p = p->lchild;
        }
        Pop(S, p);
        if (p->rchild == pre || !p->rchild){    //如果第二次访问该结点或其有孩子为空
            print(*p);
            pre = p;
            p = NULL;   //需要再次弹出一个结点
        } else {    //如果是第一次访问且右孩子不为空，则让此结点重新压回栈中，访问右孩子
            Push(S, p);
            p = p->rchild;
        }
    } */
    //用两个栈实现
    LinkStack S2;
    InitStack(S2);
    Push(S, T);
    while (!IsEmpty(S)){
        Pop(S, p);
        Push(S2, p);
        if (p->lchild)
            Push(S, p->lchild);
        if (p->rchild)
            Push(S, p->rchild);
    }
    while (!IsEmpty(S2)){
        Pop(S2, p);
        print(*p);
    }
}

//使用队列实现层序遍历（可以用一个队列或两个队列实现）
void LevelOrder(BiTree T){
    LinkQueue Q;
    InitQueue(Q);
    BTNode *p;
    EnQueue(Q, T);
    while (!IsEmpty(Q)){
        DeQueue(Q, p);
        print(*p);
        if (p->lchild)
            EnQueue(Q, p->lchild);
        if (p->rchild)
            EnQueue(Q, p->rchild);
    }
}

//递归插入形成一个二叉树（一直往左边偏移）
void Insert(BTNode *node){
    printf("请输入要插入的数据(输入-1停止)：");
    Data data;
    scanf("%d", &data);
    if (data == -1) return;
    BTNode *p = (BTNode *)malloc(sizeof(BTNode));
    if (p == NULL)
        return;
    p->data = data;
    p->lchild = NULL;
    p->rchild = NULL;
    if (node->lchild == NULL){
        node->lchild = p;
        Insert(node);
    }
    else{
        node->rchild = p;
        Insert(node->lchild);
    }
}

//按先序顺序创建一个二叉树
void PreCreate(BTNode **node){
    //printf("请输入要插入的数据(输入0停止)：");
    Data data;
    scanf("%d", &data);
    if (data == 0)
        return;
    *node = (BTNode *)malloc(sizeof(BTNode));
    if (*node == NULL)
        return;
    (*node)->data = data;
    (*node)->lchild = NULL;
    (*node)->rchild = NULL;
    PreCreate(&(*node)->lchild);
    PreCreate(&(*node)->rchild);
}

//获得树的深度（相当于后序遍历）
int GetTreeDepth(BiTree T){
    if (T == NULL)
        return 0;
    int l = GetTreeDepth(T->lchild);
    int r = GetTreeDepth(T->rchild);
    return l > r ? l + 1 : r + 1;   //visit()
}

//判断一颗二叉树是否为完全二叉树（层序遍历，遇到第一个空结点就判断队列中是否还有非空结点）
bool IsCBTree(BiTree T){
    LinkQueue Q;
    InitQueue(Q);
    BTNode *p;
    EnQueue(Q, T);
    while (!IsEmpty(Q)){
        DeQueue(Q, p);
        if (!p) //如果遇到第一个空结点就退出循环
            break;
        EnQueue(Q, p->lchild);
        EnQueue(Q, p->rchild);
    }
    while (!IsEmpty(Q)){
        DeQueue(Q, p);
        if (p)  //如果队列中剩余非空结点，则此二叉树不是完全二叉树 
            return false;
    }
    return true;
}

//统计叶子结点的个数
int CountLeaf(BiTree T){
    if (!T)
        return 0;
    if (!T->lchild && !T->rchild)
        return 1;
    return CountLeaf(T->lchild) + CountLeaf(T->rchild);
}

//统计结点个数
int CountNode(BiTree T){
    if (!T)
        return 0;
    return 1 + CountNode(T->lchild) + CountNode(T->rchild);
}

//统计单分支（度为1）结点个数
int CountOneChild(BiTree T){
    if (!T || (!T->lchild && !T->rchild))
        return 0;
    if (T->lchild && T->rchild)
        return CountOneChild(T->lchild) + CountOneChild(T->rchild);
    return 1 + CountOneChild(T->lchild) + CountOneChild(T->rchild);
}

//统计双分支（度为2）结点的个数
int CountTwoChild(BiTree T){
    if (!T || (!T->lchild && !T->rchild))
        return 0;
    if (T->lchild && T->rchild)
        return 1 + CountTwoChild(T->lchild) + CountTwoChild(T->rchild);
    return CountTwoChild(T->lchild) + CountTwoChild(T->rchild);
}

//求二叉树同深度结点权值之和最大的深度（和相同的去深度小的，根结点深度为1）
int getDepthByMaxSum(BiTree T){
    LinkQueue Q1, Q2;
    InitQueue(Q1);
    InitQueue(Q2);
    BTNode *p;
    int sum = 0, temp = 0, depth = 0, count = 0;
    EnQueue(Q1, T);
    while (!IsEmpty(Q1) || !IsEmpty(Q2)){
        temp = 0;
        count++;
        while (!IsEmpty(Q1)){
            DeQueue(Q1, p);
            temp += p->data;
            if (p->lchild)
                EnQueue(Q2, p->lchild);
            if (p->rchild)
                EnQueue(Q2, p->rchild);
        }
        if (temp > sum){
            sum = temp;
            depth = count;
        }
        temp = 0;
        count++;
        while (!IsEmpty(Q2)){
            DeQueue(Q2, p);
            temp += p->data;
            if (p->lchild)
                EnQueue(Q1, p->lchild);
            if (p->rchild)
                EnQueue(Q1, p->rchild);
        }
        if (temp > sum){
            sum = temp;
            depth = count;
        }
    }
    return depth;
}
    