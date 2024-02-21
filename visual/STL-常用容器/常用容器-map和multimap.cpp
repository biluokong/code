#include <iostream>
using namespace std;
#include <map>

/* 1、基本概念
                （1）概念：
                                ①map中所有元素都是pair类型
                                ②pair中第一个元素为key(键值)，起到索引作用，第二个元素为value(实值)
                                ③所有元素都会根据元素的键值自动排序
                （2）本质：是关联式容器，底层结构是用二叉树实现
                （3）优点：可以根据键值key快速找到value值
                （4）map和multimap的区别：map不允许重复key值出现，而multimap允许。value都可以重复

    2、构造和赋值
                map<T1, T2> mp
                map(const map& mp);
                map& operator=(const map& mp);

    3、大小和交换
                size();
                empty();
                swap(mp);

    4、插入和删除
                insert(elem);          //四种插入方式：
                                                                        ①mp.insert(pair<int, int>(1, 10));      
                                                                        ②mp.insert(make_pair(2, 10));（第二种不需要指定类型，写模板参数）     建议用第二种
                                                                        ③mp.insert(map<int, int>::value_type(3, 30));
                                                                        ④mp[4] = 40;        不建议，因为当赋值不当时，会默认赋值0；
                clear();
                erase(pos);                 //删除pos迭代器所指的元素，返回下一个元素的迭代器
                erase(beg, end);        //删除区间[beg, end)的所有元素，返回下一个元素的迭代器
                erase(key);                 //删除键值为key的元素

    5、存取
                mp[key]                         //获得键值为key的value
                mp[key] = value;           //对键值为key的对应value赋值
                mp[key];                        //默认赋值0给value

    6、查找和统计
                find(key);                      //同set
                count(key);                   //同set

    7、排序：默认排序规则按照key值从小到大，改变排序规则，同set
*/
void main()
{
    map<int, int> p;
    //第四种插入方法
    p[1] = 2;
    p[2];
    cout << p[1] << endl;
    cout << p[2] << endl;
    cout << p[3] << endl;

    system("pause");
}