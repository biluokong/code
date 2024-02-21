#include<stdlib.h>
#include<stdio.h>
#include<string.h>

int main() {
    char target[] = "addfddfdddfdslwer";
    char model[] = "fds";
    //方式1
    /* for (int i = 0, j = 0; i <= strlen(target) - strlen(model); i++){
        for (j = 0; j < strlen(model); j++){
            if (target[i + j] != model[j])
                break;
        }
        if (j == strlen(model)){
            printf("%d", i);
            break;
        }
    } */
    //方式2
    int i = 0, j = 0;
    while (target[i] != 0 && model[j] != 0){
        if (target[i] == model[j])
            i++, j++;
        else
            i = i - j + 1, j = 0;
    }
    if (model[j] == 0)
        printf("%d", i - j);
    return 0;
}