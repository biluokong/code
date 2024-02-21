#include "graph.h"
#include "operate.cpp"

int main() {
    ALGraph G;
    G.vexnum = 6;
    char str[] = "ABCDEF";
    for (int i = 0; i < G.vexnum; i++) {
        G.vertices[i].data = str[i];
        G.vertices[i].first = NULL;
    }
    ArcNode* p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 1;
    p->info = 2;
    p->next = NULL;
    G.vertices[0].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 2;
    p->info = 3;
    p->next = NULL;
    G.vertices[0].first->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 3;
    p->info = 6;
    p->next = NULL;
    G.vertices[0].first->next->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 0;
    p->info = 1;
    p->next = NULL;
    G.vertices[1].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 4;
    p->info = 4;
    p->next = NULL;
    G.vertices[1].first->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 0;
    p->info = 3;
    p->next = NULL;
    G.vertices[2].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 3;
    p->info = 1;
    p->next = NULL;
    G.vertices[2].first->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 4;
    p->info = 11;
    p->next = NULL;
    G.vertices[2].first->next->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 5;
    p->info = 2;
    p->next = NULL;
    G.vertices[2].first->next->next->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 0;
    p->info = 6;
    p->next = NULL;
    G.vertices[3].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 2;
    p->info = 1;
    p->next = NULL;
    G.vertices[3].first->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 5;
    p->info = 13;
    p->next = NULL;
    G.vertices[3].first->next->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 1;
    p->info = 4;
    p->next = NULL;
    G.vertices[4].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 2;
    p->info = 11;
    p->next = NULL;
    G.vertices[4].first->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 5;
    p->info = 7;
    p->next = NULL;
    G.vertices[4].first->next->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 2;
    p->info = 2;
    p->next = NULL;
    G.vertices[5].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 3;
    p->info = 13;
    p->next = NULL;
    G.vertices[5].first->next = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = 4;
    p->info = 7;
    p->next = NULL;
    G.vertices[5].first->next->next = p;

    //GetAllPath(G, 0, 2);
    GetBestPath(G);
    /* for (int i = 0; i < G.vexnum; i++) {
        p = G.vertices[i].first;
        while (p != NULL) {
            printf("%c--%c=%d\t", G.vertices[i].data, G.vertices[p->adjvex].data, p->info);
            p = p->next;
        }
        printf("\n");
    } */
    //printf("%d, %d\n", IsAdjacent(G, 1, 4), IsAdjacent(G, 5, 3));
    //DNeighbors(G, 2);
    //InsertVertex(G, 'G');
    /* DeleteVertex(G, 2);
    for (int i = 0; i < G.vexnum; i++){
        if (G.vertices[i].data != '\0')
            printf("%c ", G.vertices[i].data);
    } */
    //AddDEdge(G, 0, 4);
    //DNeighbors(G, 0);
    //DFSTraverse(G);

    //printf("%d\n", GetDegree(G, 0));
    //DNeighbors(G, 4);
    //GetBestPath(G);
    //Dijkstra_Min_Distance(G, 0);
    return 0;
}