#include "tree.h"

//建立哈夫曼树
void Haffman(int weight[], int n, HaffNode haffTree[]){
    int m1, m2, x1, x2;
    //初始化哈夫曼树
    for (int i = 0; i < 2 * n - 1; i++){
        if (i < n)  //如果该结点是叶子结点
            haffTree[i].weight = weight[i];
        else
            haffTree[i].weight = 0;
        haffTree[i].flag = false;   //表示未加入哈夫曼树
        haffTree[i].parent = haffTree[i].lchild = haffTree[i].rchild = -1;
    }
    //构造哈夫曼树
    for (int i = 0; i < n - 1; i++){
        m1 = m2 = INT_MAX;
        x1 = x2 = 0;
        for (int j = 0; j < n + i; j++){  //找出未加入哈夫曼树而权值又最小和次小的结点
            if (haffTree[j].weight < m1 && !haffTree[j].flag){
                m2 = m1;
                x2 = x1;
                m1 = haffTree[j].weight;
                x1 = j;
            }
            else if (haffTree[j].weight < m2 && !haffTree[j].flag){
                m2 = haffTree[j].weight;
                x2 = j;
            }
        }
        //前n个结点是叶子结点，后n-1个结点都是分支结点，是其它结点的双亲结点
        haffTree[x1].parent = haffTree[x2].parent = n + i;
        haffTree[x1].flag = haffTree[x2].flag = true;
        haffTree[n + i].weight = haffTree[x1].weight + haffTree[x2].weight;
        haffTree[n + i].lchild = x1;
        haffTree[n + i].rchild = x2;
    }
}

//构造哈夫曼编码
void HaffmanCode(HaffNode haffTree[], int n, Code haffCode[]){
    Code *code = (Code *)malloc(sizeof(Code));
    int child, parent;
    //求n个叶子结点的哈夫曼编码
    for (int i = 0; i < n; i++){
        code->start = n - 1;
        code->weight = haffTree[i].weight;
        child = i;
        parent = haffTree[child].parent;
        //由叶子结点向上，直到根结点为止
        while (parent != -1) {
            if (haffTree[parent].lchild == child)
                code->bit[code->start] = 0;   //左孩子分支编码为0
            else
                code->bit[code->start] = 1;   //右孩子分支编码为1
            code->start--;
            child = parent;
            parent = haffTree[child].parent;
        }
        for (int j = code->start + 1; j < n; j++)   //保存叶子结点的编码
            haffCode[i].bit[j] = code->bit[j];
        haffCode[i].start = code->start + 1;        //保存叶子结点编码的起始下标
        haffCode[i].weight = code->weight;          //保存编码对应的权值
    }
}
