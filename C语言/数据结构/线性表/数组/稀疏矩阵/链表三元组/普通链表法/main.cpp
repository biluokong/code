#include <stdlib.h>
#include <stdio.h>

typedef struct SpareMatrixElement{
    int row;   //行号/总行数
    int col;   //列号/总列数
    int value; //对应的值/总元素个数/常数值
    SpareMatrixElement *next;    //指向下一个稀疏矩阵元素
} MatrixEle;

//储存稀疏矩阵
void save(int *p, int n, MatrixEle *eleHead, int num){
    eleHead->row = n;
    eleHead->col = n;
    eleHead->value = num;
    eleHead->next = NULL;
    MatrixEle *s = eleHead, *t = NULL;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (p[i * n + j] != num){
                t = (MatrixEle *)malloc(sizeof(MatrixEle));
                t->row = i;
                t->col = j;
                t->value = p[i * n + j];
                t->next = NULL;
                s->next = t;
                s = t;
            }
        }
    }
}

//将储存的稀疏矩阵还原回原数组
void transform(MatrixEle *eleHead, int *p){
    MatrixEle *t = eleHead->next;
    for (int i = 0, k = 1; i < eleHead->row; i++){
        for (int j = 0; j < eleHead->col; j++){
            if (i == t->row && j == t->col){
                p[i * eleHead->row + j] = t->value;
                if (t->next != NULL)
                    t = t->next;
            }
            else
                p[i * eleHead->row + j] = eleHead->value;
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
    MatrixEle *eleHead = (MatrixEle *)malloc(sizeof(MatrixEle));
    save((int *)array, n, eleHead, 0);
    MatrixEle *t = eleHead->next;
    while (t != NULL){
        printf("%d %d %d\n", t->row, t->col, t->value);
        t = t->next;
    }
    transform(eleHead, (int *)array);
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++)
            printf("%d ", array[i][j]);
        printf("\n");
    }
    return 0;
}