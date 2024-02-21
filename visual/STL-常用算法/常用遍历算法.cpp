#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

//for_each仿函数输出
class printV
{
public:    
    void operator()(int val)
    {
        cout << val << " ";
    }
};

//for_each普通函数输出
void printVector(int val)
{
    cout << val << " ";
}

//transform仿函数实现搬运
class Trans
{
public:
    int operator()(int v)
    {
        return v + 100;     //利用仿函数可以在搬运时进行一些其它运算
    }
};

//void main()
//{
    /* 1、for_each
                        （1）功能：实现遍历容器
                        （2）函数原型：
                                        for_each(iterator beg, iterator end, func);
                                        遍历容器元素，beg—开始迭代器，end—结束迭代器，_func—函数或者函数对象
    */
//    vector<int> v;
//    for ( int i = 0; i < 10; i++ )
//    {
//        v.push_back(i);
//    }
//
//    //第一种方式，用自定义普通函数，来遍历输出，放函数
//    for_each(v.begin(), v.end(), printVector);
//    cout << endl;
//
//    //第二种方式，用仿函数，放函数对象
//    for_each(v.begin(), v.end(), printV());     //要加括号，代表创建一个匿名对象
//    cout << endl;
//
//    /* 2、transform
//                        （1）功能：搬运容器到另一个容器中
//                        （2）函数原型：
//                                        transform(iterator beg1, iterator end1, iterator beg2, _func);
//                                        beg1—源容器开始迭代器，end1—源容器结束迭代器，beg2—目标容器开始迭代器，_func—函数或者函数对象
//    */
//    vector<int> vTarget;
//    //目标容器需要提前开辟空间，不然运行时会崩溃
//    vTarget.resize(10);
//
//    transform(v.begin(), v.end(), vTarget.begin(), Trans());
//    for ( int i : vTarget )
//    {
//        cout << i << " ";
//    }
//    cout << endl;
//    system("pause");
//}
