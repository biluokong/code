#include <iostream>
using namespace std;
#include <functional>
#include <vector>
#include <algorithm>

/* 1、意义：
                （1）概念：STL内建了一些函数对象
                （2）分类：①算术仿函数    ②关系仿函数      ③逻辑仿函数
                （3）用法：仿函数产生的对象，用法和一般函数一样；使用内建函数对象，需要加头文件<functional>

    2、算术仿函数
                （1）功能：实现四则运算；其中negate是一元运算，其它都是二元运算
                （2）仿函数原型
                                template<class T> T plus<T>             //加法仿函数
                                template<class T> T minus<T>          //减法仿函数
                                template<class T> T multiplies<T>    //乘法仿函数
                                template<class T> T divides<T>         //除法仿函数
                                template<class T> T modulus<T>      //取模仿函数
                                template<class T> T negate<T>         //取反仿函数  

    3、关系仿函数
                    template<class T> bool equal_to<T>            //等于
                    template<class T> bool not_equal_to<T>     //不等于
                    template<class T> bool greater<T>              //大于     sort排序是不用传入自定义的排序规则，传入此一样可以
                    template<class T> bool greater_equal<T>    //大于等于
                    template<class T> bool less<T>                    //小于
                    template<class T> bool less_equal<T>         //小于等于

    4、逻辑仿函数
                    template<class T> bool logical_and<T>       //逻辑与
                    template<class T> bool logical_or<T>       //逻辑或
                    template<class T> bool logical_not<T>       //逻辑非
*/
//算术仿函数
void test01()
{
    //取反
    negate<int> n;
    cout << n(50) << endl;

    //加法
    plus<int> p;
    cout << p(12, 23) << endl;
}

//关系仿函数
void test02()
{
    vector<int> v;
    v.push_back(4);
    v.push_back(1);
    v.push_back(6);
    v.push_back(3);
    v.push_back(9);
    sort(v.begin(), v.end());   //默认排序，升序
    for ( int i : v )
    {
        cout << i << " ";
    }
    cout << endl;

    //改变排序方式
    sort(v.begin(), v.end(), greater<int>());
    for ( int i : v )
    {
        cout << i << " ";
    }
}

//逻辑仿函数
void test3()
{
    vector<bool> v;
    v.push_back(true);
    v.push_back(false);
    v.push_back(false);
    v.push_back(true);
    for ( bool b : v )
    {
        cout << b << " ";
    }
    cout << endl;

    //利用逻辑非 将容器v搬运到容器v2中，并执行取反操作
    vector<bool> v2;
    v2.resize(v.size());

    transform(v.begin(), v.end(), v2.begin(), logical_not<bool>());     //搬运算法需提前给容器分配号空间，不然会报错

    for ( bool b : v2 )
    {
        cout << b << " ";
    }
}

void main()
{
    //算术
    /*test01();*/

    //关系
    /*test02();*/

    //逻辑
    test3();
    system("pause");
}