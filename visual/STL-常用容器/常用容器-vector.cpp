#include <iostream>
using namespace std;
#include <string>
#include <vector>

template<class T>
void prin(vector<T>& v)
{
    for ( T i : v )
    {
        cout << i << " ";
    }
    cout << endl;
}

void test21()       //测试构造函数
{
    vector<int> v1;     //默认构造
    for ( int i = 0; i < 10; i++ )
    {
        v1.push_back(i);
    }
    prin(v1);

    //区间方式构造
    vector<int> v2(v1.begin(), v1.end());
    prin(v2);

    //n个elem方式构造
    vector<int> v3(10, 12);
    prin(v3);

    //拷贝构造
    vector<int> v4(v1);
    prin(v4);
}

void test22()
{
    vector<int> v1;
    for (int i = 0;i<10;i++)
    {
        v1.push_back(i);
    }
    prin(v1);
    v1.resize(20);
    prin(v1);
    v1.resize(30, 3);
    prin(v1);
    v1.resize(10, 3);
    prin(v1);
}

//void main()
//{
    /* 1、基本概念
                    （1）功能：vector数据结构和数组非常相似，也称为单端数组
                    （2）与普通数组的区别：不同之处在于数据是静态空间，而vector可以动态扩展
                    （3）动态扩展：是开辟更大的空间，然后将原数据拷贝到新空间，释放原空间
                    （4）vector容器的迭代器是支持随机访问的迭代器

        2、构造函数
                    vector<T> v;                                             //采用模板类实现类实现，默认构造函数
                    vector(v.begin(), v.end());                         //将v[begin(), end())区间中的元素拷贝给本身（左闭右开）
                    vector(n, elem);                                        //构造函数将n个elem拷贝给本身
                    vector(const vector& vec);                      //拷贝构造函数

        3、赋值操作
                    vector& operator=(const vector& vec);           //重载等号运算符
                    assign(beg, end);                                              //将[beg, end)区间中的数据拷贝给本身
                    assign(n, elem);                                                //将n个elem拷贝赋值给本身

        4、容量和大小
                    boolempty();                             //判断是否为空
                    int capacity();                            //返回容器的容量
                    int size();                                   //返回容器中元素的个数
                    resize(int num);                        //重新指定容器的长度为num，若容器变长，则以默认值填充新位置；如果容器变短，则末尾超 出容器长度的元素被删除             
                    resize(int num, elem);              //重新指定容器的长度为num，若容器变长，则以elem值填充新位置；如果容器变短，则末尾超出容器长度的元素的元素被删除               
        5、插入和删除
                    push_back(ele);                                                                           //尾部插入元素elem
                    pop_back();                                                                                 //删除最后一个元素
                    insert(const_iterator pos, ele);                                                    //迭代器指向pos位置插入元素ele
                    insert(const_iterator pos, int count, ele);                                    //迭代器指向位置pos插入count个元素ele
                    erase(const_iterator pos);                                                           //删除迭代器指向的元素 
                    erase(const_iterator start, const_iterator end);                          //删除迭代器从start到end之间的元素
                    clear();                                                                                        //删除容器中的所有元素

        6、数据存取
                    at(int idx);                     //返回索引idx所指的数据
                    operator[];                   //返回索引idx所指的数据
                    front();                         //返回容器中第一个数据元素
                    back();                         //返回容器中最后一个数据元素

        7、互换容器
                    swap(vec);                  //将vec与本身的元素互换
                    补：巧用互换容器方法收缩内存：vector<T> (v).swap(v)；
                            分析：此处可看作两个部分，vector<T>(v) 在此处调用拷贝函数，从而创建了一个匿名变量x(假设它是x)，一个容量和数据与v的长度和数据一样的匿名变量
                            ；接着执行(v).swap(v)，互换x和v的指针，让v指向x开辟的内存空间，x指向用来v的内存空间；
                            并且此语句一结束，匿名变量的内存就被相同回收了，从而使v的内存合理，节省了内存

        8、预留空间：减少vector在动态拓展容量时的拓展次数
                    reserve(int len);           //容量预留len个元素，预留位置不初始化，元素不可访问
                    意义：在数据量很大时，可以直接预留足够的空间，不用多次开辟空间
    */
    /*test21();*/
    /*test22();*/

    //vector互换容器
    //vector<int> v1, v2;
    //for ( int i = 0; i < 10; i++ )
    //{
    //    v1.push_back(i);
    //    v2.push_back(10 - i);
    //}
    //prin(v1);
    //prin(v2);
    //v1.swap(v2);
    //prin(v1);
    //prin(v2);

    ////巧用swap()收缩内存，减少内存浪费
    //vector<int> v3;
    //for ( int i = 0; i < 10000; i++ )
    //{
    //    v3.push_back(i);
    //}
    //cout << v3.capacity() << "\t" << v3.size() << endl;
    //v3.resize(3);
    //cout << v3.capacity() << "\t" << v3.size() << endl;     //长度变小了，但容量没变，浪费内存
    //vector<int> (v3).swap(v3);      //这样写可以让内存和长度一样大
    //cout << v3.capacity() << "\t" << v3.size() << endl;

    //预留空间
//    vector<int> v6;
//    int num = 0;
//    int* p = NULL;
//    for ( int i = 0; i < 10000; i++ )
//    {
//        v6.push_back(i);
//        if (p != &v6[0])
//        {
//            p = &v6[0];
//            num++;
//        }
//    }
//    cout << "开辟空间的次数为：" << num << endl;
//    cout << v6.capacity() << endl;
//    cout << v6.size() << endl;
//    vector<int> v7;
//    v7.reserve(100000);     //这样，不用多重开辟空间
//    int num1 = 0;
//    int* p1 = NULL;
//    for ( int i = 0; i < 10000; i++ )
//    {
//        v7.push_back(i);
//        if (p1 != &v7[0])
//        {
//            p1 = &v7[0];
//            num1++;
//        }
//    }
//    cout << "开辟空间的次数为：" << num1 << endl;
//    cout << v7.capacity() << endl;
//    cout << v7.size() << endl;
//    system("pause");
//}