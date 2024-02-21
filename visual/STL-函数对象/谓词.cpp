#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

/*  1、基本概念
                （1）返回bool类型的仿函数称为谓词
                （2）如果operator()接受一个参数，那么叫做一元谓词
                （3）如果operator()接受二个参数，那么叫做二元谓词

    2、一元谓词
*/

//一元谓词
class GreateFive
{
public:
    bool operator()(int val)
    {
        return val > 5;
    }
};

void test1()
{
    vector<int> v;
    for ( int i = 0; i < 10; i++ )
    {
        v.push_back(i);
    }
    //查找容器中有没有大于5的数
    vector<int>::iterator it = find_if(v.begin(), v.end(), GreateFive());      //这里的GreateFive是一个匿名的函数对象
    if ( it == v.end() )
    {
        cout << "未找到" << endl;
    }
    else
    {
        cout << "找到了" << endl;
    }
}

//二元谓词
//使用函数对象改变算法策略
class MyCompare
{
public:
    bool operator()(int val1, int val2)
    {
        return val1 > val2;
    }
};

void test2()
{
    vector<int> v;
    v.push_back(10);
    v.push_back(60);
    v.push_back(50);
    v.push_back(30);
    v.push_back(40);
    sort(v.begin(), v.end());
    for ( vector<int>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << *it << " ";
    }
    cout << endl;
    //用函数对象改变排序规则
    sort(v.begin(), v.end(), MyCompare());
    for ( vector<int>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << *it << " ";
    }
}

//void main()
//{
//    /*test1();*/
//    test2();
//    system("pause");
//}