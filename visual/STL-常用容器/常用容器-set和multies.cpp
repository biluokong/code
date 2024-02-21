#include <iostream>
using namespace std;
#include <set>

//set/multiset容器也叫集合容器

/* 1、基本概念
            （1）简介：所有元素都会在插入时自动排序
            （2）本质：set/multiset属于关联式容器，底层结构是二叉树
            （3）set与multiset的区别：     ①set不允许容器中用重复元素，若放入相同元素，会被覆盖      ②multiset允许容器中有重复元素

    2、构造和赋值
                （1）构造
                            set<T> st;
                            set(const set& st);
                （2）赋值
                            set& operator=(const set& st);

    3、大小和交换
                size();
                empty();
                swap(st);

    4、插入和删除
                insert(elem);
                clear();
                erase(pos);                 //删除pos迭代器所指的元素，返回下一个元素的迭代器
                erase(beg, end);        //删除区间[beg, end)的所有元素，返回下一个元素的迭代器
                erase(elem);              //删除容器中值为elem的元素

    5、查找和统计
                find(key);                  //查找key是否存在，返回该键值的元素的迭代器；若不存在，返回set.end();
                count(key);               //统计key的元素的个数     如果是set对象，只能返回0或1

    6、set和multiset的区别
                （1）set不可以插入重复元素，而multiset可以
                （2）set插入数据的同时会返回插入结果，表示插入是否成功。其返回值是一对值(iterator, bool)，可以用pair类型接收
                （3）multiset不会检查数据，因此一个插入重复数据

    7、pair对组创建（不需包含头文件）
                （1）功能描述：成对出现的数据，利用对组可以接收两个数据
                （2）创建方式
                                pair<type, type> p(value1, value2);     //默认构造
                                pair<type, type> p = make_pair(value1, value2);
                （3）调用方式
                                p.first     //第一个值
                                p.second    //第二个值

    8、排序：默认从小到大，可利用仿函数，改变排序规则。要在set对象没插入元素之前指定排序规则
                    对自定义类，同样可以用此方法，也可以在类中重载<运算符；但不能传入引用，若要传入引用，则要加const修饰引用
                    利用仿函数时，在vs2019需在函数括号后加const修饰
                
*/

//创建一个仿函数
//class MyCompare
//{
//public:
//    MyCompare();
//    ~MyCompare();
//    bool operator()(int v1, int v2) const
//        {
//            return v1 > v2;
//        }
//private:
//    
//};
//
//MyCompare::MyCompare()
//{}
//
//MyCompare::~MyCompare()
//{}
//
//void main()
//{
//    set<int> s;
//    //接收set插入数据时的返回值
//    pair<set<int>::iterator, bool> ret = s.insert(2);
//    if ( ret.second )
//    {
//        cout << "插入成功" << endl;
//    }
//    else
//    {
//        cout << "插入失败" << endl;
//    }
//    ret = s.insert(2);
//    if ( ret.second )
//    {
//        cout << "插入成功" << endl;
//    }
//    else
//    {
//        cout << "插入失败" << endl;
//    }
//
//    //改变默认排序方式
//    set<int, MyCompare> s1;
//    s1.insert(2);
//    s1.insert(1);
//    s1.insert(7);
//    s1.insert(3);
//    for ( set<int, MyCompare>::iterator it = s1.begin(); it != s1.end(); it++ )
//    {
//        cout << *it << " ";
//    }
//    system("pause");
//}