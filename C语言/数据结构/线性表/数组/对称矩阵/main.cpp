#include <stdlib.h>
#include <stdio.h>

//储存对称矩阵
void save(int *p, int n, int num[]){
    for (int i = 0, k = 0; i < n; i++){
        for (int j = 0; j <= i; j++)
            num[k++] = p[i * n + j];
    }
}

//将储存的对称矩阵转换为原矩阵
void transform(int num[], int *p, int n){
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (i <= j)
                p[i * n + j] = num[j * (j + 1) / 2 + i];
            else
                p[i * n + j] = num[i * (i + 1) / 2 + j];
        }
    }
}

int main(){
    int n = 4;
    int array[4][4] = {
        {1, 2, 3, 4},
        {2, 2, 5, 6},
        {3, 5, 3, 7},
        {4, 6, 7, 4}
    };
    int num[4 * (4 + 1) / 2];
    save((int *)array, 4, num);
    for (int i = 0; i < n * (n + 1) / 2; i++)
        printf("%d ", num[i]);
    printf("\n");
    transform(num, (int *)array, 4);
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++)
            printf("%d ", array[i][j]);
        printf("\n");
    }
        return 0;
}