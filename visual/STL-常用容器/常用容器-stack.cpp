#include <iostream>
using namespace std;

    /* 1、基本概念
                    （1）概念：是一种先进后出(First In Last Out, FILO)的数据结构，它只有一个出口
                    （2）栈中只有顶端的元素可以被外界使用，因此不能被遍历
                    （3）栈中进入数据称为入栈push
                    （4）栈中弹出数据称为出栈pop

        2、常用接口
                    （1）构造函数
                                    stack<T> stk;
                                    stack(const stack& stk);        //拷贝构造
                    （2）赋值操作
                                    stack& operator=(const stack& stk);
                    （3）数据存取
                                    push(elem);                         //向栈顶添加元素
                                    pop();                                  //从栈顶移除元素
                                    top();                                   //访问栈顶元素
                    （4）大小操作
                                    empty();
                                    size();
    */