#include <iostream>
using namespace std;
#include <list>

void printlist(const list<int>& l)
{
    for ( list<int>::const_iterator it = l.begin(); it != l.end(); it++ )
    {
        cout << *it << " ";
    }
    cout << endl;
}

    /* 1、基本概念
                    （1） 功能：将数据进行链式储存
                    （2）链表是一种物理上非连续的储存结构，数据元素的逻辑顺序是通过链表中的指针链接实现的
                    （3）链表由一系列结点组成，结点由数据域和指针域组成
                    （4）STL中的链表是一个双向循环链表 
                    （5）由于链表的储存方式并不是连续的内存空间，因此链表中的迭代器只支持前移和后移，属于双向迭代器
                    （6）优点：采用动态储存分配，不会造成内存浪费和溢出；链表执行插入和删除操作十分方便，修改指针即可，不需要移动大量元素
                    （7）缺点：链表灵活，但是空间(指针域)和时间(遍历)额外耗费较大
                    （8）重要性质：插入操作和删除操作都不会造成原有list迭代器的实效，这在vector是不成立
                    总结：STL中的list和vector是两个最常用的容器，各有优缺点

        2、构造函数
                    list<T> lst;
                    list(beg, end);                                 //构造函数将[beg, end)区间中的元素拷贝给本身
                    list(n, elem);
                    list(const list& lst);

        3、赋值和交换
                    assign(beg, end);
                    assign(n, elem);
                    list& operator=(const list& lst);
                    swap(lst); 

        4、大小操作
                    size();
                    empty();
                    resize(num);                            //同vector
                    resize(num, elem);                  //同vector

        5、插入和删除
                    push_back(elem);
                    pop_back();
                    push_front(elem);
                    pop_front();
                    insert(pos, elem);                        //在pos位置插入elem数据，返回新数据的位置
                    insert(pos, n, elem);                    //同vector，无返回值
                    insert(pos, beg, end);
                    clear();                                        //清空
                    erase(beg, end);                         //删除[beg, end)区间的数据，返回下一个数据的位置
                    erase(pos);                                 //删除pos位置的数据，返回下一个数据的位置
                    remove(elem)                            //删除容器中所有与elem值匹配的元素

        6、数据存取
                    front();        //返回第一个元素
                    back();         //返回最后一个元素

                    补充：
                            如何验证是否支持随机访问：有一个迭代器 it , 看 it = it +1 是否合法
                            如何验证是否支持双向访问：看 it++, 和 it-- 是否合法

        7、反转和排序
                    reverse()；//反转链表
                    sort();        //链表排序，默认从大到小排序   此处的sort是list内置的函数，不是标准算法的sort
                    补充：想要降序排列怎么办？
                            答：①先排序后，再用reverse()；    ②在sort()里传入一个自定义函数，此函数自己可以定义排序规则；对于自定义类型的排序，也用此方法

                    补充：所有不支持随机访问迭代器的容器，不可以用标准算法；不支持随机访问迭代器的容器，内部会提供对应的算法
    */
 
//方法2：改变排序方式
//bool myCompare(int v1, int v2)
//{
//    return v1 > v2;
//}
//void main()
//{
//    list<int> l;
//    for ( int i = 0; i < 10; i++ )
//    {
//        l.push_back(i);
//    }
//    l.sort();   //默认排序
//    cout << "默认排序结果：" << endl;
//    printlist(l);
//    l.sort(myCompare);        //自定义排序方式
//    cout << "改变排序方式之后的结果：" << endl;
//    printlist(l);
//    system("pause");
//}