
/* 1、基本概念
                （1）是一种先进先出(First In First Out, FIFO)的数据结构，它有两个出口
                （2）从队尾back进数据——入队push；从队头front出数据——出队pop
                （3）只有队头和队尾能被外界访问，因此不能被遍历

    2、常用接口
                （1）构造函数
                                queue<T> que;
                                queue(const queue& que);
                （2）赋值操作
                                queue& operator=(const queue& que);
                （3）数据存取
                                push(elem)                      //从队尾添加元素
                                pop();                              //从队头移除元素
                                back();                             //返回最后一个元素
                                front();                            //返回第一个元素
                （4）大小操作
                                empty();
                                size();
*/