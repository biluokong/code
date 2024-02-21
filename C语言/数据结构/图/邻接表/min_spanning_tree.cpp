#include "graph.h"

//普里姆Prim算法，从顶点v出发，在图中找出每个顶点加入生成树所需的最小代价(花费)
//时间复杂度：O(|V|)（外层循环） * O(2|V|)（内层循环两遍）
void Prim(ALGraph &G, int v, int lowCost[]) {
    bool isJoin[MaxVertexNum] = {}; //标记对应顶点是否已加入生成树中
    for (int i = 0; i < G.vexnum; i++)
        lowCost[i] = INT_MAX;   //初始化所有花费为无穷（相当）
    int min = v;    //lowCost中当前最小值对应下标，初始化为无穷
    for (int i = 0; i < G.vexnum; i++) {	//|V|轮
        isJoin[min] = true; //将该顶点加入生成树中
        //更新lowCost数组中从已有生成树到其它未加入生成树的带权路径长度
        ArcNode* p = G.vertices[min].first;
        while (p) {
            if (!isJoin[p->adjvex])	//如果该顶点未加入生成树
                //如果新加人生成树的顶点到其它顶点的路径长度小于之前的，则更新最小长度
                p->info < lowCost[p->adjvex] ? lowCost[p->adjvex] = p->info : 1;
            p = p->next;
        }
        min = v;    //初始化min对应值为无穷（方便获得最小路径长度对应的顶点下标）
        for (int j = 0; j < G.vexnum; j++) { //遍历lowCast数组
            if (!isJoin[j]) {
                //找到未加入生成树并且从已有生成树到某顶点路径长度最小的对应顶点
                if (lowCost[j] <= lowCost[min])
                    min = j;
            }
        }
    }
    lowCost[0] = 0; //表示出发顶点到自己的路径长度为0
}