#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>
struct Node {
    int index = 11;
    int step[10] = {};
    bool vis[10] = {};
};

void fun(Node n) {
    for (int i = 0; i < 10; i++)
        printf("%d %d\n", n.step[i], n.vis[i]);
}

int main(int argc, char const *argv[])
{
    /* code */
    char str[10] = "  ";
    printf("%s\n", str);
    return 0;
}

