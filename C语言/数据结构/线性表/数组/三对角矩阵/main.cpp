#include <stdlib.h>
#include <stdio.h>

//储存三对角矩阵
void save(int *p, int n, int ele[], int num){
    int k = 0;
    for (int i = 0; i < n; i++){
        for (int j = i - 1; j <= i + 1; j++){
            if (j >= 0 && j < n)
                ele[k++] = p[i * n + j];
        }
    }
    ele[k] = num;
}

//将储存的三对角矩阵还原回原矩阵
void transform(int ele[], int *p, int n){
    for (int i = 0, k = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (i - j >= -1 && i - j <= 1)
                p[i * n + j] = ele[k++];
            else
                p[i * n + j] = ele[3 * n - 2];
        }
    }
}

int main(){
    int n = 6;
    int array[6][6] = {
        {1, 1, 0, 0, 0, 0},
        {1, 2, 2, 0, 0, 0},
        {0, 2, 3, 3, 0, 0},
        {0, 0, 3, 4, 4, 0},
        {0, 0, 0, 4, 5, 5},
        {0, 0, 0, 0, 5, 6}
    };
    int ele[3 * n - 1];
    save((int *)array, n, ele, 0);
    for (int i = 0; i < 3 * n - 1; i++)
        printf("%d ", ele[i]);
    printf("\n");
    transform(ele, (int *)array, n);
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++)
            printf("%d ", array[i][j]);
        printf("\n");
    }
    return 0;
}