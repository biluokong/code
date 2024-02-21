#include <iostream>
using namespace std;
#include <algorithm>
#include <vector>

void printv(int val)
{
    cout << val << " ";
}

void main()
{
    vector<int> v1;
    vector<int> v2;
    for ( int i = 0; i < 10; i++ )
    {
        v1.push_back(i);
        v2.push_back(i + 5);
    }
    vector<int> vTarget;

    /* 1、简介
                    set_intersection        //求两个容器的交集
                    set_union                  //求两个容器的并集
                    set_difference           //求两个容器的差集，若求v1和v2的差集，则结果为v1中不是v1和v2交集的部分；反之，则是v2中不是v1和v2交集的部分
    
        2、set_intersection
                        （1）功能：求两个集合的交集，并将此交集放入目标容器指定位置，然后返回交集最后一个元素在目标容器的位置
                        （2）函数原型
                                        set_intersection(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest);    //dest—目标容器起始迭代器
                        （3）总结：
                                    ①求交集的两个容器必须是同向有序序列（默认升序，如需降序，需加参数_Pred）
                                    ②目标容器开辟空间是两个容器size的最小值
                                    ③set_intersection的返回值是交集中最后一个元素在目标容器中的位置
                                    ④要取其返回值作为遍历时的结束迭代器，以防止多余空间的0值输出
    */
    //目标容器需要提前开辟空间，最特殊情况(即目标容器所需最大空间的情况)，大容器包括小容器，取最小容器的size即可
    //vTarget.resize(min(v1.size(), v2.size()));      //也可以用条件判断、三目运算符来取得所需最大空间
    //vector<int>::iterator it = set_intersection(v1.begin(), v1.end(), v2.begin(), v2.end(), vTarget.begin());

    ////输入了交集之外多余空间的值0，因为此遍历方式默认到目标容器的结束迭代器才结束遍历
    //for ( int i : vTarget )
    //{
    //    cout << i << " ";
    //}
    //cout << endl;
    ////用求交集算法的返回值作结束迭代器可以避免输出多余空间的0值
    //for_each(vTarget.begin(), it, printv);

    /* 3、set_union
                    （1）求两个集合的并集，并将此并集放人目标容器指定位置，然后返回并集最后一个元素在目标容器的位置
                    （2）函数原型
                                    set_union(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest);       //dest—目标容器的开始迭代器
                    （3）总结：
                                    ①求交集的两个容器必须是同向有序序列（默认升序，如需降序，需加参数_Pred）
                                    ②目标容器开辟空间是两个容器size的和
                                    ③set_intersection的返回值是交集中最后一个元素在目标容器中的位置
                                    ④要取其返回值作为遍历时的结束迭代器，以防止多余空间的0值输出
    */
    //开辟目标容器的空间，最特殊情况，两个集合没有交集(即目标容器所需最大空间的情况)，取两个容器size的和
    /*vTarget.resize(v1.size() + v2.size());
    vector<int>::iterator it = set_union(v1.begin(), v1.end(), v2.begin(), v2.end(), vTarget.begin());
    for_each(vTarget.begin(), it, printv);*/

    /* 4、set_difference
                    （1）功能：求两个容器的差集，并将此差集放入目标容器的指定位置，然后返回差集最后一个元素在目标容器的位置
                    （2）函数原型
                                    set_difference(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest);
                    （3）总结：
                                    ①求交集的两个容器必须是同向有序序列（默认升序，如需降序，需加参数_Pred）
                                    ②目标容器开辟空间是两个容器size的最大值
                                    ③set_intersection的返回值是交集中最后一个元素在目标容器中的位置
                                    ④要取其返回值作为遍历时的结束迭代器，以防止多余空间的0值输出
    */
    //开辟目标容器的空间，最特殊的情况(即目标容器所需最大空间的情况)，两个集合没有交集，则取放入的第一个容器的size；为安全(第一个放入容器的位置可能交换)起见，取两个容器最大的size
    vTarget.resize(max(v1.size(), v2.size()));
    vector<int>::iterator it = set_difference(v1.begin(), v1.end(), v2.begin(), v2.end(), vTarget.begin());
    for_each(vTarget.begin(), it, printv);
    system("pause");
}
