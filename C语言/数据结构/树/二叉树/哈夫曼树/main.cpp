#include "tree.h"
#include "operate.cpp"

int main() {
    int weight[] = {1, 3, 2, 5, 7, 12};
    HaffNode haffTree[2 * 6 - 1];
    Haffman(weight, 6, haffTree);
    for (int i = 0; i < 2 * 6 - 2; i++)
        printf("叶子结点%d的双亲结点为：%d\n", haffTree[i].weight, haffTree[haffTree[i].parent].weight);
    Code haffmanCode[6];
    HaffmanCode(haffTree, 6, haffmanCode);
    for (int i = 0; i < 6; i++){
        for (int j = haffmanCode[i].start; j < MaxBit; j++)
            printf("%d", haffmanCode[i].bit[j]);
        printf("\n");
    }
    return 0;
}