#include "graph.h"
#include "operate.cpp"
#include "min_spanning_tree.cpp"

int main(){
    MGraph G;
    /* G.vexnum = 9;
    G.arcnum = 8;
    char str[] = "ABCDEFGHI";
    for (int i = 0; i < G.vexnum; i++){
        G.Vex[i] = str[i];
        for (int j = 0; j < G.vexnum; j++)
            G.Edge[i][j] = 0;
    }
    G.Edge[0][1] = 1;
    G.Edge[0][2] = 1;
    G.Edge[0][3] = 1;
    G.Edge[1][0] = 1;
    G.Edge[2][0] = 1;
    G.Edge[2][4] = 1;
    G.Edge[2][5] = 1;
    G.Edge[3][0] = 1;
    G.Edge[4][2] = 1;
    G.Edge[4][5] = 1;
    G.Edge[5][2] = 1;
    G.Edge[5][4] = 1;
    G.Edge[6][7] = 1;
    G.Edge[6][8] = 1;
    G.Edge[7][6] = 1;
    G.Edge[8][6] = 1;
    bool visited[MaxVertexNum] = {};    
    BFS_Min_Distance(G, 0, 4); */

    //测试最小生成树算法
    G.vexnum = 6;
    G.arcnum = 20;
    char str[] = "ABCDEF";
    for (int i = 0; i < G.vexnum; i++){
        G.Vex[i] = str[i];
        for (int j = 0; j < G.vexnum; j++)
            G.Edge[i][j] = INT_MAX;
    }
    G.Edge[0][1] = 6;
    G.Edge[0][2] = 1;
    G.Edge[0][3] = 5;
    G.Edge[1][0] = 6;
    G.Edge[1][2] = 5;
    G.Edge[1][4] = 3;
    G.Edge[2][0] = 1;
    G.Edge[2][1] = 5;
    G.Edge[2][3] = 4;
    G.Edge[2][4] = 6;
    G.Edge[2][5] = 4;
    G.Edge[3][0] = 5;
    G.Edge[3][2] = 4;
    G.Edge[3][5] = 2;
    G.Edge[4][1] = 3;
    G.Edge[4][2] = 6;
    G.Edge[4][5] = 6;
    G.Edge[5][2] = 4;
    G.Edge[5][3] = 2;
    G.Edge[5][4] = 6;
    Dijkstra_Min_Distance(G, 0);
    //Floyd_Min_Distance(G);
    int lowCast[MaxVertexNum];
    //Kruskal(G, lowCast);
    //for (int i = 0; i < G.vexnum - 1; i++)
    //    printf("%d ", lowCast[i]);

    //测试拓扑排序算法
    //G.Edge[0][1] = 1;
    //G.Edge[1][4] = 1;    //加这两行后就会存在回路
    //G.Edge[4][0] = 1;
    /* G.Edge[0][4] = 1;
    G.Edge[1][2] = 1;
    G.Edge[2][5] = 1;
    G.Edge[3][1] = 1;
    G.Edge[4][2] = 1; */
    //ReverseTopologicalSort(G);
    //printf("\n%d", DFSTraverse_ReverseTopo(G));

    //测试关键路径算法
    /* G.arcnum = 8;
    G.vexnum = 6;
    char str[] = "123456";
    for (int i = 0; i < G.vexnum; i++){
        G.Vex[i] = str[i];
        for (int j = 0; j < G.vexnum; j++)
            G.Edge[i][j] = INT_MAX;
    }
    G.Edge[0][1] = 3;
    G.Edge[0][2] = 2;
    G.Edge[1][3] = 2;
    G.Edge[1][4] = 3;
    G.Edge[2][3] = 4;
    G.Edge[2][5] = 3;
    G.Edge[3][5] = 2;
    G.Edge[4][5] = 1;
    Critical_Path(G); */
    return 0;
}