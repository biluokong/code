#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

//find_if测试用类
class FindIf
{
public:    
    bool operator()(int val)
    {
        return val > 5;
    }
};

bool cif(int val)
{
    return val > 5;
}

//void main()
//{
//    vector<int> v;
//    for ( int i = 0; i < 10; i++ )
//    {
//        v.push_back(i);
//    }
    /* 1、算法简介
                    find                    //查找元素
                    find_if                //按条件查找元素
                    adjacent_find    //查找相邻重复元素
                    binary_search   //二分查找法
                    count                //统计元素个数
                    count_if            //按条件统计元素个数

        2、find
                    （1）功能：查找指定元素，若找到返回找到元素的迭代器，找不到返回结束迭代器end()
                    （2）函数原型
                                    find(iterator beg, iterator end, value);    //value是查找的元素，如果是自定义数据类型，需重载==，返回bool类型，参数为 (const 类名& 对象名)                                  
    */
    //find测试
    /*vector<int>::iterator it1 = find(v.begin(), v.end(), 5);
    if ( it1 == v.end() )
    {
        cout << "没找到" << endl;
    }
    else
    {
        cout << "找到了" << *it1 << endl;
    }*/

    /* 3、find_if
                    （1）功能：按值查找元素，找到后返回指定位置迭代器，找不到返回结束迭代器位置
                    （2）函数原型（其比find(找到的条件是==)更灵活，可以自定义查找条件）
                                    find_if(iterator beg, iterator end, _Pred);         //_Pred—函数或者谓词(即返回bool类型的仿函数)，对应自定义类型，用谓词(仿函数，重载())
    */
    /*vector<int>::iterator it2 = find_if(v.begin(), v.end(), FindIf());
    if ( it2 == v.end() )
    {
        cout << "没找到" << endl;
    }
    else
    {
        cout << "找到了" << *it2 << endl;
    }*/

    /* 4、adjacent_find
                    （1）功能：重载相邻重复元素，返回相邻相同元素的第一个元素位置的迭代器
                    （2）函数原型
                                    adjacent_find(iterator beg, iterator end);

        5、binary_search
                    （1）功能：查找指定的元素，查到返回true，否则返回false，在无序序列中不可用，若用了，结果不确定
                    （2）函数原型
                                    bool binary_search(iterator beg, iterator end, value);

        6、count
                    （1）函数原型
                                    count(iterator beg, iterator end, value);       //统计自定义类型，需重载==

        7、count_if
                    （1）功能：按条件统计元素个数
                    （2）函数原型
                                    count_if(iterator beg, iterator end, _Pred);        //_Pred—函数或谓词(返回bool的仿函数)
    */
    /*cout << count_if(v.begin(), v.end(), cif) << endl;*/
    /*system("pause");
}*/