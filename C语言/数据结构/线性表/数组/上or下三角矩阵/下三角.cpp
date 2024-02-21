#include <stdlib.h>
#include <stdio.h>

//储存上三角矩阵（下三角的数可以为某一常数）
void save(int *p, int n, int num[]) {
    int k = 0;
    for (int i = 0; i < n; i++){
        for (int j = 0; j <= i; j++)
            num[k++] = p[i * n + j];
    }
    num[k] = p[(n - 1) * n - 1];
}

//将储存的上三角矩阵还原会原矩阵
void transform(int num[], int *p, int n) {
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (i >= j)
                p[i * n + j] = num[i * (i + 1) / 2 + j];
            else
                p[i * n + j] = num[n * (n + 1) / 2];
        }
    }
}

int main(){
    int n = 4;
    int array[4][4] = {
        {1, 0, 0, 0},
        {7, 2, 0, 0},
        {5, 6, 3, 0},
        {1, 2, 3, 4}
    };
    int num[4 * (4 + 1) / 2 + 1];
    save((int *)array, 4, num);
    for (int i = 0; i < n * (n + 1) / 2 + 1; i++)
        printf("%d ", num[i]);
    printf("\n");
    transform(num, (int *)array, n);
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++)
            printf("%d ", array[i][j]);
        printf("\n");
    }
    return 0;
}