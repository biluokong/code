#include "main.h"
#pragma warning(disable : 4996)
# include "operate.cpp"
/*
(1+2)*(9-6)
result = 9.000000
3/4*(4+6)*(8-7)
result = 7.500000
(4-6)*(3-5)*(1-3)/2
result = -4.000000
*/
int main()
{
    char s[100];
    // printf("input infix: ");
    scanf("%s", s);
    printf("result = %f\n", ComputeInfix(s));
}
