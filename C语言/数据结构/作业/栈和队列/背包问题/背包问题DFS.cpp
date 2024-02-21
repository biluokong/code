#include <stdlib.h>
#include <stdio.h>
#define Maxsize 100
int weight[Maxsize];
int T, n;
int count = 0; //计算可行解数量
int DFS(int order, int visited[], int sum)
{
    int i, j = 0;
    visited[order] = 1; //是否被访问
    sum += weight[order];
    if (sum == T) //恰好符合，返回1
        return 1;
    for (i = 0; i <= n - 1; i++)
    {
        if (visited[i] == 1) //全部遍历完之后，没有执行上一句的return 1时，即表示误解
            j++;
    }
    if (j == n) //本次递归无解
        return 0;
    for (i = order + 1; i <= n - 1; i++) //查找后面的元素
    {
        if (visited[i] == 0) //没有被访问时
        {
            if (DFS(i, visited, sum) == 1) //有解
            {
                for (int j = 0; j <= n - 1; j++) //输出该组解
                {
                    if (visited[j] != 0)
                        printf("%d ", weight[j]);
                }
                count++; //累计解的个数
                printf("\n");
            }
            visited[i] = 0; //消除该值访问，进行下一个访问
        }
    }
}

int main()
{
    int i;
    printf("请输入背包可装的总重量与可使用的物品数量(用空格分开)：\n");
    scanf("%d%d", &T, &n);
    printf("请输入每个物品的重量：\n");
    for (i = 0; i <= n - 1; i++) //重量输入
        scanf("%d", &weight[i]);
    printf("该问题解的情况为：\n");
    for (i = 0; i <= n - 1; i++)
    {
        int visited[Maxsize] = {0};
        int sum = 0;
        DFS(i, visited, sum); //每次选取的开头所装物品序号，依次后推
    }
    if (count == 0)
        printf("该问题无解");
    else
        printf("该问题总的解的个数为%d", count);
    return 0;
}