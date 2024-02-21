#include <iostream>
using namespace std;
#include <deque>

void prindeque(const deque<int>& d)
{
    for ( deque<int>::const_iterator it = d.begin(); it != d.end(); it++ )      //若想d不被修改，则需加const，但加后，就要用只允许只读的迭代器：const_iterator，不能用普通迭代器 
    {
        cout << *it << endl;
    }
    for ( int i : d )
    {
        cout << i << " ";
    }
    cout << endl;
}

void test31()
{
    deque<int> d;
    for ( int i = 0; i < 10; i++ )
    {
        d.push_back(i);
    }
    prindeque(d);
}

//void main()
//{
    /* 1、基本概念：
                    （1）功能：双端数组，可以对头端进行插入删除操作
                    （2）deque和vector的区别
                                        ①vector对于头端的插入删除效率低，数据量越大，效率越低
                                        ②deque相对而言，对头部的插入删除速度会比vector快
                                        ③vector访问元素时的速度比deque快，这与两者内部实现有关
                    （3）内部工作原理：其内部有个中控器，维护每段缓冲区中的内容，缓冲区中存放真实数据(像散列表)；中控器维护的是每个缓冲区的地址，使得使用deque时像一片连续的内存空间
                    （4）deque容器的迭代器也是支持随机访问的

        2、构造函数
                    deque<T> depT;                            //默认构造
                    deque(beg, end);                            //构造函数将[beg, end)区间的元素拷贝给本身
                    deque(n, elem);                              //构造函数将n个elem拷贝给本身
                    deque(const deque& deq);            //拷贝构造函数

        3、赋值操作
                    deque& operator=(const deque& bed);             //操作赋值操作符
                    assign(beg, end);                                                  //将[beg, end)区间中的数据拷贝赋值给本身
                    assign(n, elem);                                                    //将n个elem拷贝赋值给本身

        4、大小操作
                    deque.empty();                           //判断容器是否为空
                    deque.size();                               //返回容器中元素的个数
                    deque.resize(num);                    //重新指定容器的长度为num，若容器变长，则以默认值填补；若容器变短，则删除超出元素
                    deque.resize(num, elem);          //重新指定容器的长度为num，若容器变长，则以elem填补；若容器变短，则删除超出元素
                    总结：deque没有容器的概念，所以没有获得容器的函数

        5、插入和删除
                    （1）两端插入操作
                                    push_back(elem);                            //在容器尾部添加一个数据
                                    push_front(elem);                           //在容器头部添加一个数据
                                    pop_back();                                     //删除容器最后一个数据
                                    pop_front();                                    //删除容器第一个数据
                    （2）指定位置操作
                                    insert(pos, elem);                          //在pos位置插入一个elem元素的拷贝，返回新数据的位置
                                    insert(pos, n, elem);                      //在pos位置插入n个elem数据，无返回值
                                    insert(pos, beg, end);                   //在pos位置插入[beg, end)区间的数据，无返回值
                                    clear();                                          //清空容器的所有数据
                                    erase(beg, end);                           //删除[beg, end)区间的数据，返回下一个数据的位置
                                    erase(pos);                                   //删除pos位置的数据，返回下一个数据的位置
                                    注意：这里插入和删除提供的位置(pos)是迭代器

        6、数据存取
                    at(int idx);                                    //返回索引idx所指的数据
                    operator[idx];                              //返回索引idx所指的数据
                    front();                                         //返回容器中第一个数据元素
                    back();                                         //返回容器中最后一个数据元素

        7、排序：需包含头文件 algorithm(标准算法的头文件)
                    sort(iterator beg, iterator end);   //对[beg, end]区间内的元素进行排序，默认从小到大，升序排列。
                    注：对支持随机访问的迭代器的容器，都可以用sort算法直接进行排序vector可以用
    */
    /*test31();
    system("pause");
}*/