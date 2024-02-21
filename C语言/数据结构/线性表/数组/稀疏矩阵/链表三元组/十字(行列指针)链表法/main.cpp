#include <stdlib.h>
#include <stdio.h>
typedef struct SpareMatrixElement{
    int col;   //列号/总列数
    int value; //对应的值/总元素个数
    SpareMatrixElement *rowNext;
    SpareMatrixElement *colNext;
} MatrixEle;

//储存稀疏数组
void save(int *p, int n, MatrixEle rowEle[], MatrixEle colEle[], int num){
    for (int i = 0; i < n; i++){
        rowEle[i].rowNext = NULL;
        rowEle[i].colNext = NULL;
        colEle[i].rowNext = NULL;
        colEle[i].colNext = NULL;
    }
    MatrixEle *(row[6]), *(col[6]), *t = NULL;
    for (int i = 0; i < 6; i++){
        row[i] = &rowEle[i];
        col[i] = &colEle[i];
    }
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (p[i * n + j] != num){
                t = (MatrixEle *)malloc(sizeof(MatrixEle));
                t->col = j;
                t->value = p[i * n + j];
                t->rowNext = NULL;
                t->colNext = NULL;
                row[i]->rowNext = t;
                col[j]->colNext = t;
                row[i] = t;
                col[j] = t;
            }
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
        {0, 0, 0, 0, 2, 0}};
    MatrixEle row[6], col[6];
    save((int *)array, n, row, col, 0);
    MatrixEle *(t[6]);
    for (int i = 0; i < 6; i++)
        t[i] = &row[i];
    for (int i = 0; i < n; i++){
        while (t[i]->rowNext != NULL){
            printf("%d %d %d\n", i, t[i]->rowNext->col, t[i]->rowNext->value);
            t[i] = t[i]->rowNext;
        }
    }
    return 0;
}