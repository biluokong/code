#include <stdlib.h>
#include <stdio.h>
typedef struct SpareMatrixElement{
    int col;    //列号/总列数
    int value;  //对应的值/总元素个数
    SpareMatrixElement *next;
} MatrixEle;

//储存稀疏数组
void save(int *p, int n, MatrixEle ele[], int num){
    ele[0].col = n;
    ele[0].value = num;
    for (int i = 0; i < n; i++)
        ele[i].next = NULL;
    MatrixEle *(s[6]), *t = NULL;
    for (int i = 0; i < 6; i++)
        s[i] = &ele[i];
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (p[i*n+j] != num){
                t = (MatrixEle *)malloc(sizeof(MatrixEle));
                t->col = j;
                t->value = p[i * n + j];
                t->next = NULL;
                s[i]->next = t;
                s[i] = t;
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
        {0, 0, 0, 0, 2, 0}
    };
    MatrixEle ele[6];
    save((int *)array, n, ele, 0);
    MatrixEle *(t[6]);
    for (int i = 0; i < 6; i++)
        t[i] = &ele[i];
    for (int i = 0; i < n; i++){
        while (t[i]->next != NULL){
            printf("%d %d %d\n", i, t[i]->next->col, t[i]->next->value);
            t[i] = t[i]->next;
        }
    }
    return 0;
}