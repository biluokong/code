#pragma once
#include<stdlib.h>
#include<stdio.h>
#define MaxVertexNum 10
//#define INFINITY INT_MAX    //可以宏定义int类型的最大值表示无穷（两顶点不存在的边）
#define INFINITY -1 //这里我为了方便，定义-1表示无穷（自己指向自己的边也可以用0表示）
typedef char VertexType;    //顶点的数据类型
typedef int EdgeType;   //带权图边上权值的类型（非带权图用bool类型即可，即用0和1表示边的有无）

//该储存方式空间复杂度高，只适合储存稠密图（由于邻接矩阵是对称矩阵，可以压缩储存）
struct MGraph{  //无/有向图的结构体（空间复杂度：O(|V|²)）
    VertexType Vex[MaxVertexNum]; //顶点表
    EdgeType Edge[MaxVertexNum][MaxVertexNum];   //邻接矩阵，边表（边的权）
    int vexnum, arcnum; //图的当前顶点数和边数/弧数
};

struct ESet{    //等价类，双亲表示法的树结构
    int data;   //元素
    int parent; //双亲指针
};