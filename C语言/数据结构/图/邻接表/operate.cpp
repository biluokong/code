#include "graph.h"
#include "queue.h"

//以下基本操作都未处理数组下标越界情况

//判断是否存在边<x,y>或(x,y)。时间复杂度：O(1)-O(|V|)
bool IsAdjacent(ALGraph& G, int x, int y) {
    ArcNode* p = G.vertices[x].first;
    while (p) {
        if (p->adjvex == y)
            return true;
        p = p->next;
    }
    return false;
}

//列出无向图中与顶点x邻接的边。时间复杂度：O(1)-O(|V|)
void UDNeighbors(ALGraph& G, int x) {
    ArcNode* p = G.vertices[x].first;
    while (p) {
        printf("<%c,%c> ", G.vertices[x].data, G.vertices[p->adjvex].data);
        p = p->next;
    }
}

//列出有向图中与顶点x邻接的边。时间复杂度：出边[O(1)-O(|V|)] + 入边[O(|E|)]
void DNeighbors(ALGraph& G, int x) {
    UDNeighbors(G, x);  //先输出该顶点的出边
    for (int i = 0; i < G.vexnum; i++) { //遍历剩下的顶点，输出入边
        if (i != x) {
            ArcNode* p = G.vertices[i].first;
            while (p) {
                if (p->adjvex == x)
                    printf("<%c,%c> ", G.vertices[i].data, G.vertices[x].data);
                p = p->next;
            }
        }
    }
}

//获得指定结点的度
int GetDegree(ALGraph& G, int x) {
    int count = 0;
    ArcNode* p = G.vertices[x].first;
    while (p) {
        count++;
        p = p->next;
    }
    for (int i = 0; i < G.vexnum; i++) {
        if (i != x) {
            p = G.vertices[i].first;
            while (p) {
                if (p->adjvex == x) {
                    count++;
                    break;  //只可能有一条出边或重复边
                }
                p = p->next;
            }
        }
    }
    return count;
}

//插入顶点x。时间复杂度：O(1)
bool InsertVertex(ALGraph& G, VertexType x) {
    if (G.vexnum == MaxVertexNum)   //满了
        return false;
    G.vertices[G.vexnum++].data = x;
    return true;
}

//删除顶点x。时间复杂度：无向：O(1)-O(E)；有向：删除出边[O(1)-O(|V|)] + 删除入边[O(|E|)]
bool DeleteVertex(ALGraph& G, int x) {
    ArcNode* p = G.vertices[x].first;
    while (p) {  //删除x的出边
        G.vertices[x].first = p->next;
        free(p);
        p = G.vertices[x].first;
    }
    for (int i = 0; i < G.vexnum; i++) { //删除x的入边
        if (i != x) {
            ArcNode** t = &G.vertices[i].first;
            if (!*t)
                continue;
            while (*t) {
                if ((*t)->adjvex == x) {
                    p = (*t);
                    (*t) = (*t)->next;
                    free(p);
                    break; //对某个顶点，只有一条(有向图)出边/(无向图)重复边到x顶点
                }
                t = &(*t)->next;
            }
        }
    }
    G.vertices[x].data = '\0';
}

//如果(x,y)不存在，则添加这条边（无权值）。时间复杂度：头插法[O(1)]-尾插法[O(|V|)]
bool AddUDEdge(ALGraph& G, int x, int y) {
    if (IsAdjacent(G, x, y))    //如果该边已存在，则添加失败
        return false;
    ArcNode* p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = y;
    p->next = G.vertices[x].first;  //头插法
    G.vertices[x].first = p;
    p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = x;
    p->next = G.vertices[y].first;
    G.vertices[y].first = p;
    return true;
}


//如果<x,y>不存在，则添加这条弧（无权值）。时间复杂度：头插法[O(1)]-尾插法[O(|V|)]
bool AddDEdge(ALGraph& G, int x, int y) {
    if (IsAdjacent(G, x, y))    //如果该弧已存在，则添加失败
        return false;
    ArcNode* p = (ArcNode*)malloc(sizeof(ArcNode));
    p->adjvex = y;
    p->next = G.vertices[x].first; //头插法
    G.vertices[x].first = p;
    return true;
}

//找到顶点x的第一个邻接点，不存在返回-1。（如果是有向图，找出边）
//时间复杂度：无向[O(1)]、有向{出边[O(1))]、入边[O(1)-O(|E|)]}
int FirstNeighbor(ALGraph& G, int x) {
    if (G.vertices[x].first)
        return G.vertices[x].first->adjvex;
    return -1;
}

//y是顶点x的一个邻接点，返回除顶点y之外顶点x的下一个邻接点的顶点号；(有向找出边)
//若y是x的最后一个邻结点，返回-1。时间复杂度：无向：O(1)-O(V)；有向：O(1）
int NextNeighbor(ALGraph& G, int x, int y) {
    ArcNode* p = G.vertices[x].first;
    while (p) {
        if (p->adjvex == y)
            break;
        p = p->next;
    }
    if (p && p->next)
        return p->next->adjvex;
    return -1;
}

//获取指定弧的权值。时间复杂度：O(1)-O(|V|)
InfoType Get_edge_value(ALGraph& G, int x, int y) {
    ArcNode* p = G.vertices[x].first;
    while (p) {
        if (p->adjvex == y)
            return p->info;
        p = p->next;
    }
    return INFINITY;
}

//设置指定弧的权值（有向）。时间复杂度：O(1)-O(|V|)
void Set_edge_value(ALGraph& G, int x, int y, InfoType v) {
    ArcNode* p = G.vertices[x].first;
    while (p) {
        if (p->adjvex == y) {
            p->info = v;
            return;
        }
        p = p->next;
    }
}
//设置指定弧的权值（无向）。时间复杂度：O(1)-O(|2V|)
void Set_edge_value_UD(ALGraph& G, int x, int y, InfoType v) {
    ArcNode* p = G.vertices[x].first;
    while (p) {
        if (p->adjvex == y) {
            p->info = v;
            break;
        }
        p = p->next;
    }
    p = G.vertices[y].first;
    while (p) {
        if (p->adjvex == x) {
            p->info = v;
            return;
        }
        p = p->next;
    }
}

void Visit(VertexType data) {
    printf("%c ", data);
}

//广度优先遍历。从顶点v出发，遍历连通结点（只能遍历连通结点）(相当于二叉树的层序遍历)
void BFS(ALGraph& G, int v, bool visited[]) {
    LinkQueue Q;
    InitQueue(Q);
    Visit(G.vertices[v].data);    //访问顶点
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    EnQueue(Q, v);  //入队该顶点
    while (!IsEmpty(Q)) {
        DeQueue(Q, v);
        //检测v的所有邻接点
        for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)) {
            if (!visited[w]) {   //如果该邻接点未被访问过
                Visit(G.vertices[w].data);
                visited[w] = true;
                EnQueue(Q, w);
            }
        }
    }
}

//对图进行广度优先遍历（可以遍历所有结点，不论是否连通）
//时间复杂度：无向[访问O(|V|) + 查找O(2|E|)]、有向[访问O(|V|) + 查找O(|E|)]
void BFSTraverse(ALGraph& G) {
    bool visited[MaxVertexNum] = {};    //用于表示顶点是否被访问
    for (int i = 0; i < G.vexnum; i++) { //遍历所有顶点
        if (!visited[i])    //如果该顶点没被访问
            BFS(G, i, visited);
    }
}

//深度优先遍历。从顶点v出发，遍历连通结点（只能遍历连通结点）(相当于二叉树的先序遍历)
void DFS(ALGraph& G, int v, bool visited[]) {
    Visit(G.vertices[v].data);    //访问顶点
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    //检测v的所有邻接点
    for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)) {
        if (!visited[w])   //如果该邻接点未被访问过
            DFS(G, w, visited);
    }
}

//对图进行深度优先遍历（可以遍历所有结点，不论是否连通）
//空间复杂度：最好情况，递归深度O(1)；最坏情况，递归深度为O(|V|)
//时间复杂度：无向[访问O(|V|) + 查找O(2|E|)]、有向[访问O(|V|) + 查找O(|E|)]
void DFSTraverse(ALGraph& G) {
    bool visited[MaxVertexNum] = {};    //用于表示顶点是否被访问
    for (int i = 0; i < G.vexnum; i++) { //遍历所有顶点
        if (!visited[i])    //如果该顶点没被访问
            DFS(G, i, visited);
    }
}

void GetBestPath_DFS(ALGraph& G, int v, bool visited[]) {
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    //检测v的所有邻接点
    for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)) {
        if (w == 0 && !visited[G.vexnum]) {   //如果访问的顶点是始点
            int i = 0;
            for (i = 0; i < G.vexnum; i++) {
                if (!visited[i])
                    break;
            }
            if (i == G.vexnum) {    //并且所有的顶点都已访问 
                printf("%c", G.vertices[0].data);
                visited[G.vexnum] = true;
            }
        }
        if (visited[G.vexnum])	//如果已找到最佳路径
            break;
        if (!visited[w])    //如果该邻接点未被访问过
            GetBestPath_DFS(G, w, visited);
    }
    if (visited[G.vexnum])	//如果已找到最佳路径，输出
        printf("<--%c", G.vertices[v].data);
    visited[v] = false;
}

//获得从始点开始无重复经过所有其它顶点并回到始点的路径（最佳路径）
void GetBestPath(ALGraph& G) {
    bool visited[MaxVertexNum + 1] = {};
    GetBestPath_DFS(G, 0, visited);
    if (visited[G.vexnum])	//如果找到了一条最近路径就返回 
        return;
    printf("最佳路径不存在");
}

void Print_Min_Distance(int v, int u, int length, int path[], VNode V[]) {
    printf("%c->%c的最短(带权)路径长度为：%d\n", V[v].data, V[u].data, length);
    printf("最短(带权)路径为：%c", V[u].data);
    int index = path[u];
    while (index != -1) {
        printf(" <- %c", V[index].data);
        index = path[index];
    }
    printf("\n");
}

// Dijkstra算法求单源(指定顶点到其它顶点的)最短路径（适用有/无权图，类似prim算法）
//不适应与有负权值的带权图，时间复杂度：时间复杂度：O(|V|) * O(2|V|)）（与prim算法一样）
void Dijkstra_Min_Distance(ALGraph& G, int v) {
    bool final[MaxVertexNum] = {};  //标记对应顶点是否已找到最短路径
    InfoType dist[MaxVertexNum + 1] = {};    //从源顶点到其它顶点的最短带权路径长度
    int path[MaxVertexNum] = {};    //储存各个顶点在其最短带权路径上对应的前驱顶点
    // path[v] = -1;   //表示源顶点没有前驱顶点
    for (int i = 0; i < G.vexnum; i++) {
        dist[i] = INT_MAX;  //初始化所有花费为无穷（相当）
        path[i] = -1;       //表示当前顶点还为找到带权最短路径上其前驱（除源顶点外）    
    }
    dist[v] = 0;    //表示源顶点到自己的最短带权路径长度为0
    dist[G.vexnum] = INT_MAX;   //用于初始化min对应值
    int min = v;    //dist中当前最小值对应下标，初始化为无穷
    for (int i = 0; i < G.vexnum; i++) { //|V|轮
        final[min] = true; //表示该顶点已找到其对短带权路径
        //更新dist数组中从源顶点到其它未找到带权最短路径顶点的带权路径长度
        ArcNode* p = G.vertices[min].first;
        while (p) {
            if (!final[p->adjvex]) {    //如果该顶点未找到最短带权路径
                //如果从源顶点经过新顶点min而到其它顶点的带权路径长度小于之前的，则更新最小长度
                if (p->info + dist[min] < dist[p->adjvex]) {
                    dist[p->adjvex] = p->info + dist[min];
                    path[p->adjvex] = min;
                }
            }
            p = p->next;
        }
        min = G.vexnum;    //初始化min对应值为无穷（方便获得新的最小带权路径长度对应的顶点）
        for (int j = 0; j < G.vexnum; j++) { //遍历dist数组
            if (!final[j]) {
                //找到源顶点到某顶点带权路径长度最小的对应顶点
                if (dist[j] <= dist[min])
                    min = j;
            }
        }
    }
    //输出
    for (int i = 0; i < G.vexnum; i++) {
        if (i != v)
            Print_Min_Distance(v, i, dist[i], path, G.vertices);
    }
}

char str[MaxVertexNum * (MaxVertexNum - 1) / 2][MaxVertexNum] = {};
int count = 0;

void GetAllPath_DFS(ALGraph& G, int t, int v, bool visited[]) {
    visited[v] = true;  //对该顶点作标记，表示该顶点已被访问
    char temp[2] = { G.vertices[v].data };
    strcat(str[count], temp);
    if (t == v) {
        str[++count][0] = '\0';
        strcat(str[count], str[count - 1]);
    }
    else {
        //检测v的所有邻接点
        for (int w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)) {
            if (!visited[w])    //如果该邻接点未被访问过
                GetAllPath_DFS(G, t, w, visited);
        }
    }
    str[count][strlen(str[count]) - 1] = '\0';
    visited[v] = false;
}

//获得指定两顶点之间不经过重复顶点的所有路径
void GetAllPath(ALGraph& G, int v, int t) {
    bool visited[MaxVertexNum + 1] = {};
    GetAllPath_DFS(G, t, v, visited);
    for (int i = 0; i < count; i++)
        printf("%s\n", str[i]);
}
