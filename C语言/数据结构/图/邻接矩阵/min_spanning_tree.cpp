#include "graph.h"
#include<math.h>

//最小生成树

//普里姆Prim算法，从顶点v出发，在图中找出每个顶点加入生成树所需的最小代价(花费)
//时间复杂度：O(|V|)（外层循环） * O(2|V|)（内层循环两遍）
void Prim(MGraph G, int v, int lowCost[]){
    bool isJoin[MaxVertexNum] = {}; //标记对应顶点是否已加入生成树中
    for (int i = 0; i < G.vexnum; i++)
        lowCost[i] = INT_MAX;   //初始化所有花费为无穷（相当）
    int min = v;    //lowCost中当前最小值对应下标，初始化为无穷
    for (int i = 0; i < G.vexnum; i++){ //|V|轮
        isJoin[min] = true; //将该顶点加入生成树中
        //更新lowCost数组中从已有生成树到其它未加入生成树的带权路径长度
        for (int j = 0; j < G.vexnum; j++){ 
            if (!isJoin[j]) //如果该顶点未加入生成树
                //如果新加人生成树的顶点到其它顶点的路径长度小于之前的，则更新最小长度
                G.Edge[min][j] < lowCost[j] ? lowCost[j] = G.Edge[min][j] : 1;
        }
        min = v;    //初始化min对应值为无穷（方便获得最小路径长度对应的顶点下标）
        for (int j = 0; j < G.vexnum; j++){ //遍历lowCast数组
            if (!isJoin[j]){ 
                //找到未加入生成树并且从已有生成树到某顶点路径长度最小的对应顶点
                if (lowCost[j] <= lowCost[min])
                    min = j;
            }
        }
    }
    lowCost[v] = 0; //表示出发顶点到自己的路径长度为0
}
//时间复杂度：O(|V|-1) * O(2|V|)
/* void Prim(MGraph G, int v, int lowCost[]){
    bool isJoin[MaxVertexNum] = {};
    for (int i = 0; i < G.vexnum; i++)
        lowCost[i] = INT_MAX;
    int min = v;
    isJoin[min] = true;
    for (int j = 0; j < G.vexnum; j++){ //第一次初始化lowCost
            if (!isJoin[j])
                G.Edge[min][j] < lowCost[j] ? lowCost[j] = G.Edge[min][j] : 1;
        }
    for (int i = 1; i < G.vexnum; i++){ //|V|-1轮
        min = v;
        for (int j = 0; j < G.vexnum; j++){
            if (!isJoin[j]){
                if (lowCost[j] <= lowCost[min])
                    min = j;
            }
        }
        isJoin[min] = true;
        for (int j = 0; j < G.vexnum; j++){
            if (!isJoin[j])
                G.Edge[min][j] < lowCost[j] ? lowCost[j] = G.Edge[min][j] : 1;
        }
    }
    lowCost[v] = 0;
} */

//初始化等价类，n个类/树均有一个初始元素i
void InitESet(ESet x[], int n) {
    for (int i = 0; i < n; i++){
        x[i].data = i;
        x[i].parent = -1;
    }
}

//查，返回包含结点i的树的根结点
int Find(ESet x[], int i){
    int e = i;
    while (x[e].parent >= 0)
        e = x[e].parent;
    return e;
}

//并，将含结点j的树的根结点并在含结点i的树上，i结点作为其父结点
void Union(ESet x[], int i, int j){
    int t = Find(x, j);
    int e = Find(x, i);
    x[e].parent += x[t].parent;   //该数的绝对值用于表示该树的总结点数
    x[t].parent = i;
}

//克鲁斯卡尔Kruskal算法
void Kruskal(MGraph G, int lowCost[]){
    //储存排好序的边的权值和边对应的两个顶点
    int *orderWeight[/* G.arcnum */20];     //定义指针数组
    for (int i = 0; i < 20; i++)    //指针数组的每个指针指向一个一维数组
        orderWeight[i] = (int *)malloc(sizeof(int) * 3);
    for (int i = 0, k = 0; i < G.vexnum; i++){
            for (int j = 0; j < G.vexnum; j++){
                if (G.Edge[i][j] > 0 && G.Edge[i][j] != INT_MAX){   //如果边存在
                    orderWeight[k][0] = G.Edge[i][j];
                    orderWeight[k][1] = i;
                    orderWeight[k++][2] = j;
                }
            }
        }
    for (int k = 3; k > 0; k--){
        int step = (int)pow(2, k) - 1;
        for (int i = 1; i < G.arcnum; i++){ //希尔排序
            int *temp = orderWeight[i];
            int j = i - step;
            for (; j >= 0 && temp[0] < orderWeight[j][0]; j -= step)
                orderWeight[j + step] = orderWeight[j];
            orderWeight[j + step] = temp;
        }
    }
    ESet x[/* G.vexnum */6];    //并查集
    InitESet(x, G.vexnum);
    for (int i = 0, j = 0; i < G.arcnum; i++){
        if (Find(x, orderWeight[i][1]) != Find(x, orderWeight[i][2])){
            printf("%c--%c\n", G.Vex[orderWeight[i][1]], G.Vex[orderWeight[i][2]]);
            Union(x, orderWeight[i][1], orderWeight[i][2]);
            lowCost[j++] = orderWeight[i][0];
            if (abs(Find(x, orderWeight[i][1])) == G.vexnum)
                break; //如果所有顶点已加入生成树中，就跳出循环
        }
    }
}