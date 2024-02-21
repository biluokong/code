#include <stdlib.h>
#include <stdio.h>

typedef struct SpareMatrixElement{
    int row;    //行号/总行数
    int col;    //列号/总列数
    int value;    //对应的值/总元素个数/常数值
} MatrixEle;

//储存稀疏矩阵
void save(int *p, int n, MatrixEle ele[], int num){
    ele[0].row = n;
    ele[0].col = n;
    ele[0].value = num;
    for (int i = 0, k = 1; i < n; i++){
        for (int j = 0; j < n; j++){
            if (p[i*n+j] != num){
                ele[k].row = i;
                ele[k].col = j;
                ele[k++].value = p[i * n + j];
            }
        }
    }
}

//将储存的稀疏矩阵还原回原数组
void transform(MatrixEle ele[], int *p){
    for (int i = 0, k = 1; i < ele[0].row; i++){
        for (int j = 0; j < ele[0].col; j++){
            if (i == ele[k].row && j == ele[k].col)
                p[i * ele[0].row + j] = ele[k++].value;
            else
                p[i * ele[0].row + j] = ele[0].value;
        }
    }
}

int main(){
    int n = 6;
    int array[6][6] = {
        {0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 4, 0, 0},
        {8, 0, 0, 0, 0, 0},
        {0, 0, 0, 9, 0, 0},
        {0, 0, 0, 0, 2, 0}
    };
    MatrixEle ele[5+1];
    save((int *)array, n, ele, 0);
    for (int i = 0; i < 6; i++)
        printf("%d %d %d\n", ele[i].row, ele[i].col, ele[i].value);
    transform(ele, (int *)array);
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++)
            printf("%d ", array[i][j]);
        printf("\n");
    }
        return 0;
}