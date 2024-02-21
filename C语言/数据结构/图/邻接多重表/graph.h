#pragma once
#include <stdlib.h>
#include <stdio.h>
#define MaxVertexNum 10
//#define INFINITY INT_MAX    //可以宏定义int类型的最大值表示无穷（两顶点不存在的边）
#define INFINITY -1
typedef char VertexType; //顶点的数据类型
typedef int InfoType;

struct EdgeNode{         //边的结构体
    int i, j;           //边的两个顶点的编号
    // InfoType info;   //权值
    EdgeNode *iLink;     //依附顶点i的下一条边
    EdgeNode *jLink;     //依附顶点j的下一条边
};

typedef struct VNode{       //顶点的结构体
    VertexType data;        //顶点信息
    EdgeNode *firstedge;    //与该顶点相连的第一条边
} AdjList[MaxVertexNum];

//邻接多重表法储存（只适合储存无向图）的空间复杂度：O(|V|+|E|)
struct AMLGraph{        //邻接表储存的图
    AdjList vertices;   //顶点结点的数组
    int vexnum, arcnum; //顶点数和边数
};