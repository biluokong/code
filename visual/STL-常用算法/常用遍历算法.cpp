#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

//for_each�º������
class printV
{
public:    
    void operator()(int val)
    {
        cout << val << " ";
    }
};

//for_each��ͨ�������
void printVector(int val)
{
    cout << val << " ";
}

//transform�º���ʵ�ְ���
class Trans
{
public:
    int operator()(int v)
    {
        return v + 100;     //���÷º��������ڰ���ʱ����һЩ��������
    }
};

//void main()
//{
    /* 1��for_each
                        ��1�����ܣ�ʵ�ֱ�������
                        ��2������ԭ�ͣ�
                                        for_each(iterator beg, iterator end, func);
                                        ��������Ԫ�أ�beg����ʼ��������end��������������_func���������ߺ�������
    */
//    vector<int> v;
//    for ( int i = 0; i < 10; i++ )
//    {
//        v.push_back(i);
//    }
//
//    //��һ�ַ�ʽ�����Զ�����ͨ������������������ź���
//    for_each(v.begin(), v.end(), printVector);
//    cout << endl;
//
//    //�ڶ��ַ�ʽ���÷º������ź�������
//    for_each(v.begin(), v.end(), printV());     //Ҫ�����ţ�������һ����������
//    cout << endl;
//
//    /* 2��transform
//                        ��1�����ܣ�������������һ��������
//                        ��2������ԭ�ͣ�
//                                        transform(iterator beg1, iterator end1, iterator beg2, _func);
//                                        beg1��Դ������ʼ��������end1��Դ����������������beg2��Ŀ��������ʼ��������_func���������ߺ�������
//    */
//    vector<int> vTarget;
//    //Ŀ��������Ҫ��ǰ���ٿռ䣬��Ȼ����ʱ�����
//    vTarget.resize(10);
//
//    transform(v.begin(), v.end(), vTarget.begin(), Trans());
//    for ( int i : vTarget )
//    {
//        cout << i << " ";
//    }
//    cout << endl;
//    system("pause");
//}
