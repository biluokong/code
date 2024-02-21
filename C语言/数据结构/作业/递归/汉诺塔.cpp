#include <stdlib.h>
#include <stdio.h>

//将n个盘子从fromPeg楔子移动到toPeg楔子上，auxPeg为辅助楔子
void Towers(int n, char fromPeg, char toPeg, char auxPeg){
    if (n == 1){
        printf("把盘子1从楔子%c移动到楔子%c上\n", fromPeg, toPeg);
        return;
    }
    //先把n-1个盘子从楔子fromPeg移动到auxPeg上，toPeg为辅助楔子
    Towers(n - 1, fromPeg, auxPeg, toPeg);
    //把第n个盘子直接从fromPeg移动到toPeg上
    printf("把盘子%d从楔子%c移动到楔子%c上\n", n, fromPeg, toPeg);
    //再把n-1个盘子从auxPeg移动到toPeg上，fromPeg为辅助楔子
    Towers(n - 1, auxPeg, toPeg, fromPeg);
}

int main(){
    Towers(4, 'A', 'C', 'B');
}