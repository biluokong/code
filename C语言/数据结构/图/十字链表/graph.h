#pragma once
#include <stdlib.h>
#include <stdio.h>
#define MaxVertexNum 10
//#define INFINITY INT_MAX    //可以宏定义int类型的最大值表示无穷（两顶点不存在的边）
#define INFINITY -1
typedef char VertexType; //顶点的数据类型
typedef int InfoType;

struct ArcNode{     //弧的结构体
    int tailvex;    //弧尾顶点编号
    int headvex;    //弧头顶点编号
    // InfoType info;   //权值
    ArcNode *hlink; //弧头相同的下一条弧
    ArcNode *tlink; //弧尾相同的下一条弧
};

typedef struct VNode{   //顶点的结构体
    VertexType data;    //顶点信息
    ArcNode *firstin;   //该顶点作为弧头的第一条弧
    ArcNode *firstout;  //该顶点作为弧尾的第一条弧
} AdjList[MaxVertexNum];

//十字链表法储存（只适合储存有向图）的空间复杂度：O(|V|+|E|)
struct CLGraph{         //邻接表储存的图
    AdjList vertices;   //顶点结点的数组
    int vexnum, arcnum; //顶点数和弧数
};