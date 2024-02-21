
/* 1、基本概念：算术生成算法属于小型算法，使用时需要包含头文件<numeric>
        
    2、accumulate
                （1）功能：计算容器内指定范围内所有元素的总和
                （2）函数原型
                                accumulate(iterator beg, itetator end, value);      //value—起始累加值，一般为0即可。若不为0，则最终结果是所有元素的和加上此值

    3、fill
                （1）功能：向容器中指定范围内填充(若已存在元素，则会用指定元素覆盖所有范围内的元素)指定的元素
                （2）函数原型
                                fill(iterator beg, iterator end, value);        //
*/
//#include <iostream>
//using namespace std;
//#include <vector>
//#include <numeric>
//
//void main()
//{
//    vector<int> v;
//    for ( int i = 0; i < 10; i++ )
//    {
//        v.push_back(i);
//    }
//    fill(v.begin(), v.end(), 100);
//    for ( int i : v )
//    {
//        cout << i << " ";
//    }
//    system("pause");
//}
