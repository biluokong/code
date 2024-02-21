#pragma once
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#define MaxVertexNum 10
//#define INFINITY INT_MAX    //可以宏定义int类型的最大值表示无穷（两顶点不存在的边）
#define INFINITY -1
typedef char VertexType; //顶点的数据类型
typedef int InfoType;

struct ArcNode{ //边/弧的结构体
    int adjvex;         //表示边/弧指向结点的下标
    ArcNode *next;      //指向下一条边/弧的指针
    InfoType info;   //边的权值
};

typedef struct VNode{   //顶点的结构体
    VertexType data;    //顶点信息
    ArcNode *first;     //第一条边/弧
} AdjList[MaxVertexNum];

//无向图中边结点的数量为2|E|，整体空间复杂度为：O(|V|+2|E|)（有冗余）
//该储存方式由于数据会冗余，所以删除顶点和边的操作时间复杂度高
//有向图中边结点的数量是|E|，整体空间复杂度为：O(|V|+|E|)
//该储存方式在找有向图某顶点的入度数目时只能全部遍历一遍才能找到（时间复杂度高）
//该储存方式形成的邻接表不唯一（因为表示一个顶点的度的顺序不唯一）
struct ALGraph{ //邻接表储存的图
    AdjList vertices;   //顶点结点的数组
    int vexnum, arcnum; //顶点数和边/弧数
};