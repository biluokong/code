#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>    //标准算法头文件
#include <string.h>

/*
1、STL的诞生
        （1）长久以来，软件界一直希望建立一种可重复利用的东西
        （2）C++的面向对象和泛型编程思想，目的就是复用性的提升
        （3）大多情况下，数据结构和算法都未能有一套标准，导致被迫从事大量重复工作
        （4）为了建立数据结构和算法的一套标准，诞生了STL

2、STL基本概念
        （1）STL(Standard Template Liabrary. 标准模板库)
        （2）从广义上分为：容器(container)、算法(algorithm)和迭代器(iterator)
        （3）容器和算法之间通过迭代器进行无缝连接
        （4）STL几乎所有的代码都采用了模板类或者模板函数

3、STL六大组件
        （1）容器：各种数据结构，如vector、list、deque、set、map等，用来存放数据
        （2）算法：各种常用的算法，如sort、find、copy、for_each等
        （3）迭代器：扮演了容器与算法之间的胶合剂
        （4）仿函数：行为类似函数，可作为算法的某种策略
        （5）适配器(配接器)：一种用来修饰容器或者仿函数或迭代器接口的东西
        （6）空间配置器：负责空间的配置与管理

4、STL中容器、算法、迭代器
        （1） 容器：置物之所也，用常用是数据结构来储存数据
                        容器分两种：
                                    序列式容器：强调值的排序，序列式容器中的每一个元素均有固定的位置
                                    关联式容器：二叉树结构，各元素之间没有严格的物理上的顺序关系
        （2）算法：问题之所解也，用有限的步骤解决逻辑上或数学上的问题
                        算法分两种：
                                    质变算法：指运算过程中会更改区间内的元素内容，例如拷贝、替换、删除等等
                                    非质变算法：指运算过程中不会更改区间内的元素内容，例如查找、计数、遍历、寻找极值等等
        （3）迭代器：容器和算法之间的粘合剂，提供一种方法，使之能够依序寻访某个容器所含的各个元素，而又无需暴露该容器的内部表示方式
                        每个容器都有自己专属的迭代器，算法通过迭代器才能访问容器中的数据
                        迭代器非常类似指针，初学阶段可以先将它当成指针来理解
                        迭代器种类：

                                         种类                         功能                                                                                                      支持运算
                                    输入迭代器            对数据的只读访问                                                                               只读，支持++、==、!=
                                    输出迭代器            对数据的只写访问                                                                               只写，支持++
                                    前向迭代器            读写操作，并能向前和向后推进迭代器                                                 读写，支持++、==、!=
                                    双向迭代器            读写操作，并能向前和向后操作                                                           读写，支持++、--
                                    随机访问迭代器     读写操作，可以以跳跃的方式访问任意数据，功能最强的迭代器            读写，支持++、--、[n]、-n、<、<=、>、>=

                       常用的容器中迭代器种类为双向迭代器，和随机访问迭代器
*/
void myPritnt(int val)
{
    cout << val << endl;
}

void test01()
{
    //创建一个vector容器
    vector<int> v;
    //向容器中添加数据
    v.push_back(10);
    v.push_back(22);
    v.push_back(14);
    //通过迭代器访问容器中的数据
    vector<int>::iterator itBegin = v.begin();      //起始迭代器，指向容器中的第一个元素
    vector<int>::iterator itEnd = v.end();          //结束迭代器，指向容器中的最后一个元素的下一个位置

    //第一种遍历方式
    while ( itBegin != itEnd )
    {
        cout << *itBegin << endl;
        itBegin++;
    }

    //第二种遍历方式（常用）
    for ( vector<int>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << *it << endl;
    }

    //第三种遍历方式 利用STL提供遍历算法
    for_each(v.begin(), v.end(), myPritnt);

    //第四种遍历方式，增强for循环
    for(int i : v )
    {
        cout << i << endl;
    }
}

class Person
{
public:
    Person(string name, int age)
    {
        this->m_age = age;
        this->m_Name = name;
    }
    string m_Name;
    int m_age;
};

void test02()
{
    Person p1("aaa", 12);
    Person p2("bbb", 12);
    Person p3("ccc", 33);
    Person p4("ddd", 15);
    vector<Person> v;
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);

    //增强for循环遍历
    for ( Person p : v )
    {
        cout << "姓名：" << p.m_Name << "\t年龄：" << p.m_age << endl;
    }

    //用容器的函数遍历
    for ( vector<Person>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << "姓名：" << (*it).m_Name << "\t年龄：" << (*it).m_age << endl;
        cout << "姓名：" << it->m_Name << "\t年龄：" << it->m_age << endl;
    }
}

void test03()
{
    vector<Person*> v;
    Person p1("aaa", 12);
    Person p2("bbb", 12);
    Person p3("ccc", 33);
    Person p4("ddd", 15);
    v.push_back(&p1);
    v.push_back(&p2);
    v.push_back(&p3);
    v.push_back(&p4);

    //增强for循环
    for ( Person* p : v )
    {
        cout << "姓名：" << p->m_Name << "\t年龄：" << p->m_age << endl;
    }

    //容器函数
    for ( vector<Person*>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << "姓名：" << (*it)->m_Name << "\t年龄：" << (*it)->m_age << endl;
        cout << "姓名：" << (**it).m_Name << "\t年龄：" << (**it).m_age << endl;
    }
}

void test04()
{
    //容器嵌套容器
    vector<vector<int>> v;

    //创建小容器
    vector<int> v1;
    vector<int> v2;
    vector<int> v3;

    //向小容器添加数据
    for ( int i = 0; i < 3; i++ )
    {
        v1.push_back(i);
        v2.push_back(i + 1);
        v3.push_back(i + 2);
    }

    //向大容器添加小容器
    v.push_back(v1);
    v.push_back(v2);
    v.push_back(v3);

    //通过容器函数
    for ( vector<vector<int>>::iterator it = v.begin(); it != v.end(); it++ )
    {
        for ( vector<int>::iterator vit = (*it).begin(); vit != (*it).end(); vit++ )
        {
            cout << *vit << endl;
        }
    }

    //增强for循环
    for ( vector<int> vit : v )
    {
        for ( int i : vit )
        {
            cout << i << endl;
        }
    }
}

//void main()
//{
/*
5、容器算法迭代器初识：STL中最常用的容器是vector，可以理解为数组
        （1）vector存放内置数据类型
        容器：vector       算法：for_reach        迭代器：vector<int>::iterator
*/
    /*test01();*/

    /* （2）vector存放自定义数据类型
    */
   /* test02();*/
    /*test03();*/

    /* （3）vector容器嵌套容器
    */
 /*   test04();
    system("pause");
}*/