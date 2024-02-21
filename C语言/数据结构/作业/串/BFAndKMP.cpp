#include <stdlib.h>
#include <stdio.h>
#include <string.h>

//获得Next数组
void GetNext(char model[], int next[])
{
    int i = 0, j = -1;
    next[0] = -1;
    while (i < strlen(model) - 1)
    {
        if (j == -1 || model[i] == model[j])
        {
            i++;
            j++;
            next[i] = j;
        }
        else
            j = next[j];
    }
}

//获取nextVal数组
void GetNextVal(char model[], int nextVal[])
{
    int i = 0, j = -1;
    nextVal[0] = -1;
    while (i < strlen(model) - 1)
    {
        if (j == -1 || model[i] == model[j])
        {
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

//BF算法
int BF(char target[], char model[]){
    int i = 0, j = 0, BFCount = 0;
    while (target[i] != 0 && model[j] != 0)
    {
        if (target[i] == model[j])
            i++, j++;
        else
            i = i - j + 1, j = 0;
        BFCount++;
    }
    if (model[j] == 0)
        printf("%d ", i - j);
    else
        printf("-1 ");
    return BFCount;
}

//KMP算法
int KMP(char target[], char model[]){
    int length = strlen(model);
    int next[length];
    GetNext(model, next);
    int i = 0, j = 0, KMPCount = 0;
    while (target[i] != 0 && model[j] != 0)
    {
        if (target[i] == model[j])
            i++, j++;
        else if (j == 0)
            i++;
        else
            j = next[j];
        KMPCount++;
    }
    if (model[j] == 0)
        printf("%d ", i - j);
    else
        printf("-1 ");
    return KMPCount;
}

int main()
{
    char target1[] = "cddcdc";
    char model1[] = "abcde";
    char target2[] = "aaaaaaaa";
    char model2[] = "aab";

    int BFCount = BF(target1, model1), KMPCount = KMP(target1, model1);
    printf("\n对第一个串；BF算法比较次数：%d，KMP算法比较次数：%d\n", BFCount, KMPCount);
    BFCount = BF(target2, model2), KMPCount = KMP(target2, model2);
    printf("\n对第二个串；BF算法比较次数：%d，KMP算法比较次数：%d", BFCount, KMPCount);
    return 0;
}