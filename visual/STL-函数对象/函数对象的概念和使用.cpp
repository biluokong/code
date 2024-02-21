#include <iostream>
using namespace std;
#include <string.h>

/* 1、基本概念
                （1）概念：重载函数调用操作符的类，其对象常称为函数对象；函数对象使用重载的()时，行为类似函数调用，也叫仿函数
                （2）本质：函数对象(仿函数)是一个类，不是一个函数

    2、使用
                （1）函数对象在使用时，可以像普通函数那样调用，可以有参数，可以有返回值
                （2）函数对象也有超过了普通函数概念的部分，函数对象可以有自己的状态
                （3）函数对象可以作为参数传递
*/
//函数对象像普通函数调用
//class Myadd
//{
//public:
//    int operator()(int v1, int v2)
//    {
//        return v1 + v2;
//    }
//};
//
////函数对象的状态
//class Myprint
//{
//public:
//    Myprint() { count = 0; }
//    void operator()(string s)
//    {
//        cout << s << endl;
//        count++;
//    }
//    int count;  //内部自己的状态
//};
//
////函数对象作为参数
//void test(Myprint& mp, string s)
//{
//    mp(s);
//}

//void main()
//{
//    //像普通函数的定义方式
//    Myadd add;
//    cout << add(10, 10) << endl;
//
//    //不同于普通函数调用的方式，普通函数不是类，而仿函数可以记录类内部的状态
//    Myprint p;
//    p("hellowoo");
//    p("hellowoo");
//    p("hellowoo");
//    p("hellowoo");
//    cout << p.count << endl;
//
//    //函数对象作为参数传递
//    test(p, "eeee");
//    system("pause");
//}