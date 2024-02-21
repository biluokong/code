#include<stdlib.h>
#include<stdio.h>
#include<string.h>

void GetNext(char model[], int next[]){
    int i = 0, j = -1;
    next[0] = -1;
    while (i < strlen(model) - 1){
        if (j == -1 || model[i] == model[j]){
            i++;
            j++;
            next[i] = j;
        }
        else
            j = next[j];
    }
}

//直接获取nextVal数组
void GetNextVal(char model[], int nextVal[]){
    int i = 0, j = -1;
    nextVal[0] = -1;
    while (i < strlen(model) - 1){
        if (j == -1 || model[i] == model[j]){
            i++;
            j++;
            if (model[i] != model[j])
                nextVal[i] = j;
            else
                nextVal[i] = nextVal[j];
        }
        else
            j = nextVal[j];
    }
}

//通过next数组获取nextVal数组
void GetNextVal(char model[], int next[], int nextVal[]){
    nextVal[0] = -1;
    for (int j = 1; j < strlen(model); j++){
        if (model[next[j]] == model[j])
            nextVal[j] = nextVal[next[j]];
        else
            nextVal[j] = next[j];
    }
}

int main(){
    char target[] = "addfddfdddffddslwer";
    char model[] = "aaaab";
    int next[strlen(model)];
    int nextVal[strlen(model)];
    GetNext(model, next);
    GetNextVal(model, next, nextVal);
    for (int i = 0; i < strlen(model); i++)
        printf("%d ", nextVal[i]);
    return 0;
}