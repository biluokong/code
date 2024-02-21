#include "stack.h"
int w[6] = {1, 8, 4, 3, 5, 2};
int count = 0;

void fun(SqStack *s, int i){
    if (i < 6){
        Push(*s, w[i]);
        count += w[i];
        i++;
        if (i == 6){
            if (count == 10)
                print(*s);
            count -= Pop(*s);
            count -= Pop(*s);
        }
        else if (count > 10){
            count -= Pop(*s);
        }
        else if (count < 10){
            fun(s, i);
        }
        else if (count == 10){
            print(*s);
            count -= Pop(*s);
        }
        fun(s, i);
    }
}

int main(){
    SqStack s;
    InitStack(s);
    fun(&s, 0);
    return 0;
}