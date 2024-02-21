#include "graph.h"
#include "queue.h"

//无/有向图获得度的时间复杂度：O(|V|)
//获得无向图第index个结点的度（遍历第index行或第index列即可）
int GetUDegree(MGraph G, int index){
    int count = 0;
    for (int i = 0; i < G.vexnum; i++){
        if (G.Edge[index][i] > 0 && G.Edge[index][i] != INT_MAX)
            count++;
    }
    return count;
}

//获得有向图第index结点的出度
int Get_OutDegree(MGraph G, int index){
    int count = 0;
    for (int i = 0; i < G.vexnum; i++){
        if (G.Edge[index][i] > 0 && G.Edge[index][i] != INT_MAX)
            count++;
    }
    return count;
}

//获得有向图第index结点的入度
int Get_InDegree(MGraph G, int index){
    int count = 0;
    for (int i = 0; i < G.vexnum; i++){
        if (G.Edge[i][index] > 0 && G.Edge[i][index] != INT_MAX)
            count++;
    }
    return count;
}

//获得有向图第index结点的度
int GetDDegree(MGraph G, int index){
    return Get_OutDegree(G, index) + Get_InDegree(G, index);
}

//获得不带权(邻接矩阵的值为0或1)的无向图从第index1结点到index2结点的长度为2的路径数目
// A²[index1][index2] = ∑(A[index1][i] * A[i][index2])（i=0,1,2...MaxVertexNum-1）
// Aⁿ[index1][index2]表示由index1结点到index2结点的长度为n的路径数目（邻接矩阵法的性质）
int GetPathNum(MGraph G, int index1, int index2){
    int count = 0;
    for (int i = 0; i < G.vexnum; i++)
        count += G.Edge[index1][i] * G.Edge[i][index2];
    return count;
}

//图的基本操作（对时间复杂度为O(|V|-1)或O(2|V|)都直接为O(|V|)，不处理数组下标越界情况）
//判断是否存在边<x,y>（有向）或(x,y)（无向）(x和y为顶点的编号)。时间复杂度O(1)
bool IsAdjacent(MGraph G, int x, int y){
    return G.Edge[x][y] > 0 && G.Edge[x][y] != INT_MAX;
}

//列出与顶点x邻接的边（不分有无向图）。时间复杂度O(|V|)
void Neighbors(MGraph G, int x){
    for (int i = 0; i < G.vexnum; i++){
        if (G.Edge[x][i] > 0 && G.Edge[x][i] != INT_MAX)
            printf("<%c,%c> ", G.Vex[x], G.Vex[i]);
    }
}

//插入顶点x。时间复杂度：O(1)
bool InsertVertex(MGraph &G, VertexType x){
    if (G.vexnum == MaxVertexNum)   //满了
        return false;
    G.Vex[G.vexnum++] = x;
    return true;
}

//删除顶点x。若通过移动数据来删除，时间复杂度非常高。可以采用逻辑删除，
//给顶点加一个bool属性，再将该顶点边表的行和列的值都置为0。时间复杂度O(|V|)（实际是2|V|）
//DeleteVertex(MGraph &G, VertexType x) 该方法先不写

//如果(x,y)不存在，则添加这条边（无权值）。时间复杂度：O(1)
bool AddUEdge(MGraph &G, int x, int y){
    if (IsAdjacent(G, x, y))    //如果该边已存在，则添加失败
        return false;
    G.Edge[x][y] = G.Edge[y][x] = 1;
}

//如果<x,y>不存在，则添加这条弧（无权值）。时间复杂度：O(1)
bool AddDEdge(MGraph &G, int x, int y){
    if (IsAdjacent(G, x, y))    //如果该弧已存在，则添加失败
        return false;
    G.Edge[x][y] = 1;
}

//找到顶点x的第一个邻接点(有向是出度)，不存在返回-1。时间复杂度：O(1)-O(|V|)
int FirstNeighbor(MGraph G, int x){
    for (int i = 0; i < G.vexnum; i++){
        if (G.Edge[x][i] > 0 && G.Edge[x][i] != INT_MAX)
            return i;
    }
    return -1;
}

//y是顶点x的一个邻接点，返回除顶点y之外顶点x的下一个邻接点的顶点号(有向是出度)；
//若y是x的最后一个邻结点，返回-1。时间复杂度：O(1)-O(|V|)
int NextNeighbor(MGraph G, int x, int y){
    for (int i = y + 1; i < G.vexnum; i++){
        if (G.Edge[x][i] > 0 && G.Edge[x][i] != INT_MAX)
            return i;
    }
    return -1;
}

//找到顶点x的第一个入度对应的顶点(弧尾)，不存在返回-1。时间复杂度：O(1)-O(|V|)
int FirstPreNeighbor(MGraph G, int x){
    for (int i = 0; i < G.vexnum; i++){
        if (G.Edge[i][x] > 0 && G.Edge[i][x] != INT_MAX)
            return i;
    }
    return -1;
}

//y是顶点x的一个弧尾，返回除顶点y之外顶点x的下一个弧尾；
//若y是x的最后一个邻结点，返回-1。时间复杂度：O(1)-O(|V|)
int PreNeighbor(MGraph G, int x, int y){
    for (int i = y + 1; i < G.vexnum; i++){
        if (G.Edge[i][x] > 0 && G.Edge[i][x] != INT_MAX)
            return i;
    }
    return -1;
}

//获取指定边设置权值。时间复杂度：O(1)
EdgeType Get_edge_value(MGraph G, int x, int y){
    return G.Edge[x][y];
}

//设置指定边的权值。时间复杂度：O(1)
void Set_edge_value(MGraph &G, int x, int y, EdgeType v){
    G.Edge[x][y] = v;
}

void Visit(VertexType data){
    printf("%c ", data);
}

//广度优先遍历。从顶点v出发，遍历连通结点（只能遍历连通结点）
//问题：如果该图为非连通图，则无法遍历完所有结点
void BFS(MGraph G, int v, bool visited[]){
    LinkQueue Q;
    InitQueue(Q);
    Visit(G.Vex[v]);    //访问顶点
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    EnQueue(Q, v);  //入队该顶点
    while (!IsEmpty(Q)) {
        DeQueue(Q, v);
        //检测v的所有邻接点
        for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)){
            if (!visited[w]){   //如果该邻接点未被访问过
                Visit(G.Vex[w]);
                visited[w] = true;
                EnQueue(Q, w);
            }
        }
    }
}

//对图进行广度优先遍历（可以遍历所有结点，不论是否连通）
//时间复杂度：访问O(|V|) + 查找O(|V|²)
void BFSTraverse(MGraph G){
    bool visited[MaxVertexNum] = {};    //用于表示顶点是否被访问
    for (int i = 0; i < G.vexnum; i++){ //遍历所有顶点
        if (!visited[i])    //如果该顶点没被访问
            BFS(G, i, visited);
    }
}

//深度优先遍历。从顶点v出发，遍历连通结点（只能遍历连通结点）(相当于二叉树的先序遍历)
void DFS(MGraph G, int v, bool visited[]){  
    Visit(G.Vex[v]);    //访问顶点
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    //检测v的所有邻接点
    for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)){
        if (!visited[w])   //如果该邻接点未被访问过
            DFS(G, w, visited);
    }
}

//对图进行深度优先遍历（可以遍历所有结点，不论是否连通）
//空间复杂度：最好情况，递归深度O(1)；最坏情况，递归深度为O(|V|)
//时间复杂度：访问O(|V|) + 查找O(|V|²)
void DFSTraverse(MGraph G){
    bool visited[MaxVertexNum] = {};    //用于表示顶点是否被访问
    for (int i = 0; i < G.vexnum; i++){ //遍历所有顶点
        if (!visited[i])    //如果该顶点没被访问
            DFS(G, i, visited);
    }
}

//--------------------最短路径-------------------------
//单源最短路径：BFS算法（只适用于无权图）、Dijkstra算法（适用于有/无权图）
//各顶点间的最短路径(多源最短路径)：Floyd算法（适用于有/无权图）
//带负权值的图只有Floyd算法适用，但带负权回路的图三中算法都不适用

void Print_Min_Distance(int v, int u, int length, int path[], VertexType Vex[]){
    printf("%c->%c的最短(带权)路径长度为：%d\n", Vex[v], Vex[u], length);
    printf("最短(带权)路径为：%c", Vex[u]);
    int index = path[u];
    while (index != -1){
        printf(" <- %c", Vex[index]);
        index = path[index];
    }
    printf("\n");
}

//求顶点u到其它顶点的最短路径（对无权图，权值当作1，使用BFS。对应高度最小的生成树）
void BFS_Min_Distance(MGraph G, int u){
    LinkQueue Q;
    InitQueue(Q);
    bool visited[MaxVertexNum] = {};
    int d[MaxVertexNum] = {}, path[MaxVertexNum] = {}, t = u;
    for (int i = 0; i < G.vexnum; i++){
        d[i] = INFINITY;    //d[i]表示从u到i结点的最短路径长度
        path[i] = -1;       //表示直接最短路径是从哪个顶点过来到i顶点
    }
    d[u] = 0;   //u顶点自己到自己路径长度为0
    visited[u] = true; //对该顶点作标记，表示该顶点已被访问
    EnQueue(Q, u);  //入队该顶点
    while (!IsEmpty(Q)) {
        DeQueue(Q, u);
        //检测v的所有邻接点
        for (int w = FirstNeighbor(G, u); w >= 0; w = NextNeighbor(G, u, w)){
            if (!visited[w]){   //如果该邻接点未被访问过
                d[w] = d[u] + 1;    //路径长度加1
                path[w] = u;        //当前直接最短路径从u到w
                visited[w] = true;
                EnQueue(Q, w);
            }
        }
    }
    //输出
    for (int i = 0; i < G.vexnum; i++){
        if (i != t)
            Print_Min_Distance(t, i, d[i], path, G.Vex);
    }
}

//获得从顶点u到顶点v的最短路径和最短路径长度（只适用于无权图，BFS实现）
void BFS_Min_Distance(MGraph G, int u, int v){
    LinkQueue Q;
    InitQueue(Q);
    bool visited[MaxVertexNum] = {};
    int d[MaxVertexNum] = {}, path[MaxVertexNum] = {}, t = u;
    for (int i = 0; i < G.vexnum; i++){
        d[i] = INFINITY;    //d[i]表示从u到i结点的最短路径长度
        path[i] = -1;       //表示直接最短路径是从哪个顶点过来到i顶点
    }
    d[u] = 0;   //u顶点自己到自己路径长度为0
    visited[u] = true; //对该顶点作标记，表示该顶点已被访问
    EnQueue(Q, u);  //入队该顶点
    while (!IsEmpty(Q)) {
        DeQueue(Q, u);
        //检测v的所有邻接点
        for (int w = FirstNeighbor(G, u); w >= 0; w = NextNeighbor(G, u, w)){
            if (!visited[w]){   //如果该邻接点未被访问过
                d[w] = d[u] + 1;    //路径长度加1
                path[w] = u;        //当前直接最短路径从u到w
                if (w == v)
                    goto Print; 
                visited[w] = true;
                EnQueue(Q, w);
            }
        }
    }
    //也可以先获取从顶点v到其它所有顶点的最短路径，再从中获取v到指定顶点的长度
    Print:
        Print_Min_Distance(t, v, d[v], path, G.Vex);
}

// Dijkstra算法求单源(指定顶点到其它顶点的)最短路径（适用有/无权图，类似prim算法）
//不适应与有负权值的带权图，时间复杂度：时间复杂度：O(|V|) * O(2|V|)）（与prim算法一样）
void Dijkstra_Min_Distance(MGraph G, int v){
    bool final[MaxVertexNum] = {};  //标记对应顶点是否已找到最短路径
    int dist[MaxVertexNum + 1] = {};    //从源顶点到其它顶点的最短带权路径长度
    int path[MaxVertexNum] = {};    //储存各个顶点在其最短带权路径上对应的前驱顶点
    // path[v] = -1;   //表示源顶点没有前驱顶点
    for (int i = 0; i < G.vexnum; i++){
        dist[i] = INT_MAX;  //初始化所有花费为无穷（相当）
        path[i] = -1;       //表示当前顶点还为找到带权最短路径上其前驱（除源顶点外）    
    }
    dist[v] = 0;    //表示源顶点到自己的最短带权路径长度为0
    dist[G.vexnum] = INT_MAX;   //用于初始化min对应值
    int min = v;    //dist中当前最小值对应下标，初始化为无穷
    for (int i = 0; i < G.vexnum; i++){ //|V|轮
        final[min] = true; //表示该顶点已找到其对短带权路径
        //更新dist数组中从源顶点到其它未找到带权最短路径顶点的带权路径长度
        for (int j = 0; j < G.vexnum; j++){ 
            if (!final[j]){ //如果该顶点未找到最短带权路径
                //如果从源顶点经过新顶点min而到其它顶点的带权路径长度小于之前的，则更新最小长度
                if (G.Edge[min][j] != INT_MAX && G.Edge[min][j] + dist[min] < dist[j]){
                    dist[j] = G.Edge[min][j] + dist[min];
                    path[j] = min;  //更新path数组
                }
            }
        }
        min = G.vexnum;    //初始化min对应值为无穷（方便获得新的最小带权路径长度对应的顶点）
        for (int j = 0; j < G.vexnum; j++){ //遍历dist数组
            if (!final[j]){ 
                //找到源顶点到某顶点带权路径长度最小的对应顶点
                if (dist[j] <= dist[min])
                    min = j;
            }
        }
    }
    //输出
    for (int i = 0; i < G.vexnum; i++){
        if (i != v)
            Print_Min_Distance(v, i, dist[i], path, G.Vex);
    }
}

void Print_Min_Path(int v, int u, int path[][MaxVertexNum], VertexType Vex[]){
    if (path[v][u] == -1)
        return;
    Print_Min_Path(v, path[v][u], path, Vex);
    Print_Min_Path(path[v][u], u, path, Vex);
    printf(" -> %c", Vex[path[v][u]]);
}

// Floyd算法，获得任意两个顶点之间的最短路径。时间复杂度：O(|V|³)
//适用于有/无权图和带负权值的图，但不适用于带负权回路的图
void Floyd_Min_Distance(MGraph G){
    int A[MaxVertexNum][MaxVertexNum] = {};     //储存各个顶点之间的最短带权路径长度
    int path[MaxVertexNum][MaxVertexNum] = {};  //储存路径的中转顶点
    for (int i = 0; i < G.vexnum; i++){
        for (int j = 0; j < G.vexnum; j++){
            path[i][j] = -1;    //开始时所有顶点未找到路径的中转点
            if (i == j)
                A[i][j] = 0;    //顶点自己到自己的最短带权路径长度为0
            else
                A[i][j] = G.Edge[i][j]; //所有顶点之间无中转点的带权路径长度
        }
    }
    for (int k = 0; k < G.vexnum; k++){     //考虑以Vk顶点为中转点的情况
        for (int i = 0; i < G.vexnum; i++){ //遍历整个矩阵
            for (int j = 0; j < G.vexnum; j++){
                if (A[i][k] != INT_MAX && A[k][j] != INT_MAX && A[i][j] > A[i][k] + A[k][j]){   //如果已Vk为中转点的路径更短
                    A[i][j] = A[i][k] + A[k][j];    //更新带权最短路径长度
                    path[i][j] = k;                 //更新中转点
                }
            }
        }
    }
    //输出
    for (int i = 0; i < G.vexnum; i++){
        for (int j = 0; j < G.vexnum; j++){
            if (i != j){
                printf("%c->%c的最短带权路径长度为：%d\n", G.Vex[i], G.Vex[j], A[i][j]);
                printf("路径为：%c", G.Vex[i]);
                Print_Min_Path(i, j, path, G.Vex);
                printf(" -> %c\n", G.Vex[j]);
            }
        }
    }
}

//拓扑排序，只能对AOV网(用顶点表示活动的网)进行排序（排序序列不唯一，按入度为0来排序）
//AOV网：用DAG图(有向无环图)表示一个工程，顶点表示活动，有向边表示<i,j>表示活动i要先与活动j进行
//时间复杂度：邻接矩阵 O(|V|²)、邻接表 O(|V|+|E|)
bool TopologicalSort(MGraph G, int print[]){
    LinkQueue Q;    //用栈也行，用于储存入度为0的顶点
    InitQueue(Q);
    int indegree[MaxVertexNum] = {};    //储存每个顶点的入度
    //int print[MaxVertexNum] = {};       //储存拓扑序列
    for (int i = 0; i < G.vexnum; i++){
        indegree[i] = Get_InDegree(G, i);   //初始化每个顶点的入度
        print[i] = -1;  //初始化拓扑序列
        if (indegree[i] == 0)   //将入度为0的顶点入队
            EnQueue(Q, i);
    }
    int count = 0, index = 0;  //count用于记录已访问过的顶点数
    while (!IsEmpty(Q)){    //出队，访问队列中入度为0的顶点
        DeQueue(Q, index);  
        print[count++] = index; //更新拓扑序列
        //将所有i的出度对应的顶点的入度减1，表示把顶点index从图中删除
        for (int i = FirstNeighbor(G, index); i != -1; i = NextNeighbor(G, index, i)){
            if (--indegree[i] == 0)
                EnQueue(Q, i);  //减一后入度为0则如入队
        }
    }
    if (count < G.vexnum)
        return false;   //排序失败，有向图中有回路
    //输出路径
    /* printf("%c", G.Vex[0]);
    for (int i = 1; i < G.vexnum; i++)
        printf(" -> %c", G.Vex[print[i]]); */
    return true;
}

//逆拓扑排序，能对AOV网(用顶点表示活动的网络)进行排序（排序序列不唯一，按出度为0来排序）
//时间复杂度：邻接矩阵 O(|V|²)、邻接表 O(|V|+|E|)
//除了下面的函数实现，也可逆置得到的拓扑序列和DFS算法来实现
bool ReverseTopologicalSort(MGraph G, int print[]){
    LinkQueue Q;    //用栈也行，用于储存出度为0的顶点
    InitQueue(Q);
    int outdegree[MaxVertexNum] = {};    //储存每个顶点的出度
    //int print[MaxVertexNum] = {};       //储存逆拓扑序列
    for (int i = 0; i < G.vexnum; i++){
        outdegree[i] = Get_OutDegree(G, i);   //初始化每个顶点的出度
        print[i] = -1;  //初始化逆拓扑序列
        if (outdegree[i] == 0)   //将出度为0的顶点入队
            EnQueue(Q, i);
    }
    int count = 0, index = 0;  //count用于记录已访问过的顶点数
    while (!IsEmpty(Q)){    //出队，访问队列中出度为0的顶点
        DeQueue(Q, index);  
        print[count++] = index; //更新拓扑序列
        //将所有i的出度对应的顶点的入度减1，表示把顶点index从图中删除
        for (int i = FirstPreNeighbor(G, index); i != -1; i = PreNeighbor(G, index, i)){
            if (--outdegree[i] == 0)
                EnQueue(Q, i);  //减一后出度0为则如入队
        }
    }
    if (count < G.vexnum)
        return false;   //排序失败，有向图中有回路
    //输出路径
    /* printf("%c", G.Vex[print[0]]);
    for (int i = 1; i < G.vexnum; i++)
        printf(" -> %c", G.Vex[print[i]]); */
    return true;
}

void DFS_Topo(MGraph G, int v, bool visited[], bool before[]){  
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    before[v] = true;
    //检测v的所有邻接点
    for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)){
        for (int i = 0; i < G.vexnum; i++){
            if (!before[i]) //如果遍历到不是当前顶点来源路径上的顶点
                break;
            if (i == w) {   //如果当前顶点回到了它的来源路径上的顶点
                before[G.vexnum] = true;
                break;
            }
        }
        if (!visited[w])   //如果该邻接点未被访问过
            DFS_Topo(G, w, visited, before);
    }
    Visit(G.Vex[v]);   //访问顶点
    before[v] = false;
}

//DFS算法实现逆拓扑排序（判断有无回路）
bool DFSTraverse_ReverseTopo(MGraph G){
    bool visited[MaxVertexNum] = {};    //用于表示顶点是否被访问
    bool before[MaxVertexNum + 1] = {};     //用于记录当前顶点的来源路径上的所有顶点
    for (int i = 0; i < G.vexnum; i++){ //遍历所有顶点
        if (!visited[i])    //如果该顶点没被访问
            DFS_Topo(G, i, visited, before);
    }
    if (before[G.vexnum])
        return false;   //有回路
    return true;
}

//AOE网(用边表示活动的网络)：在带权图中已顶点表示事件，有向边表示活动，边上的权值表示完成活动的开销
//AOE网中只有一个入度为0和出度为0的顶点，称为开始顶点(源点)和结束顶点(汇点)，表示整个工程的开始和结束
//关键路径：从源点到汇点的所有路径中，具有最大路径长度的路径
//关键活动：关键路径上的活动
//关键路径：长度为完成工程需要的最短时间，若关键活动不能按时完成，则该工程的完成时间就会延长
void Critical_Path(MGraph G){
    int ve[MaxVertexNum] = {};  //所有事件的最早发生时间
    int vl[MaxVertexNum] = {};  //所有事件的最迟发生时间
    int e[/* G.arcnum */8][2] = {};   //所有活动的最早发生时间
    int l[/* G.arcnum */8] = {};      //所有活动的最迟发生时间
    int print[MaxVertexNum] = {};   //用于获得拓扑序列，方便按顺序获得ve
    TopologicalSort(G, print);
    ve[print[0]] = 0;   //源点最早发生时间为0
    // 1、获得所有事件的最早发生时间
    for (int i = 1; i < G.vexnum; i++){ 
        int max = -1;   //要最大值，是因为该事件的前置活动都做完后，该事件才能开始
        for (int j = 0; j < i; j++){
            if (IsAdjacent(G, print[j], print[i])){
                int temp = ve[print[j]] + Get_edge_value(G, print[j], print[i]);
                if (temp > max)
                    max = temp;
            }
        }
        ve[print[i]] = max;
        printf("%d ", max);
    }
    printf("\n");
    ReverseTopologicalSort(G, print);   //获得逆拓扑序列，方便按顺序获得vl
    //汇点的最迟发生时间等于汇点的最早发生时间（因为该工程在汇点结束）
    vl[print[0]] = ve[print[0]];
    // 2、获得所有事件的最迟发生时间
    for (int i = 1; i < G.vexnum; i++){ 
        int min = INT_MAX;  //要最小值，是因为需要该事件的后置活动都有足够的时间完成
        for (int j = 0; j < i; j++){
            if (IsAdjacent(G, print[i], print[j])){ //是有向图，所以这里的i在j前面
                int temp = vl[print[j]] - Get_edge_value(G, print[i], print[j]);
                if (temp < min)
                    min = temp;
            }
        }
        vl[print[i]] = min;
        printf("%d ", min);
    }
    // 3、获得所有活动的最早发生时间和最迟发生时间
    for (int i = 0, m = 0, n = 0; i < G.vexnum - 1; i++){
        for (int j = i + 1; j < G.vexnum; j++){
            if (IsAdjacent(G, i, j)){
                e[m][0] = ve[i];
                e[m++][1] = j;  //该活动(有向边指向)的尾顶点
                l[n++] = vl[j] - Get_edge_value(G, i, j);
            }
        }
    }
    // 4、获得所有活动的时间余量，为0的即为关键活动
    printf("\n%c", G.Vex[0]);
    for (int i = 0; i < G.arcnum; i++){
        if (e[i][0] - l[i] == 0)
            printf(" -> %c", G.Vex[e[i][1]]);
    }
}
