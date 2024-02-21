#include "search.h"
#include "operate.cpp"

int main() {
    int nums[] = {-1, 2, 3, 5, 8, 9, 22, 25, 58 };
    SSTable ST;
    ST.elem = nums;
    ST.TableLen = 9;
    //printf("%d", Search_Seq2(ST, 2));
    printf("%d", Binary_Search_R(ST, -22));
    return 0;
}