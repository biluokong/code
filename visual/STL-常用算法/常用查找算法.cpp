#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

//find_if��������
class FindIf
{
public:    
    bool operator()(int val)
    {
        return val > 5;
    }
};

bool cif(int val)
{
    return val > 5;
}

//void main()
//{
//    vector<int> v;
//    for ( int i = 0; i < 10; i++ )
//    {
//        v.push_back(i);
//    }
    /* 1���㷨���
                    find                    //����Ԫ��
                    find_if                //����������Ԫ��
                    adjacent_find    //���������ظ�Ԫ��
                    binary_search   //���ֲ��ҷ�
                    count                //ͳ��Ԫ�ظ���
                    count_if            //������ͳ��Ԫ�ظ���

        2��find
                    ��1�����ܣ�����ָ��Ԫ�أ����ҵ������ҵ�Ԫ�صĵ��������Ҳ������ؽ���������end()
                    ��2������ԭ��
                                    find(iterator beg, iterator end, value);    //value�ǲ��ҵ�Ԫ�أ�������Զ����������ͣ�������==������bool���ͣ�����Ϊ (const ����& ������)                                  
    */
    //find����
    /*vector<int>::iterator it1 = find(v.begin(), v.end(), 5);
    if ( it1 == v.end() )
    {
        cout << "û�ҵ�" << endl;
    }
    else
    {
        cout << "�ҵ���" << *it1 << endl;
    }*/

    /* 3��find_if
                    ��1�����ܣ���ֵ����Ԫ�أ��ҵ��󷵻�ָ��λ�õ��������Ҳ������ؽ���������λ��
                    ��2������ԭ�ͣ����find(�ҵ���������==)���������Զ������������
                                    find_if(iterator beg, iterator end, _Pred);         //_Pred����������ν��(������bool���͵ķº���)����Ӧ�Զ������ͣ���ν��(�º���������())
    */
    /*vector<int>::iterator it2 = find_if(v.begin(), v.end(), FindIf());
    if ( it2 == v.end() )
    {
        cout << "û�ҵ�" << endl;
    }
    else
    {
        cout << "�ҵ���" << *it2 << endl;
    }*/

    /* 4��adjacent_find
                    ��1�����ܣ����������ظ�Ԫ�أ�����������ͬԪ�صĵ�һ��Ԫ��λ�õĵ�����
                    ��2������ԭ��
                                    adjacent_find(iterator beg, iterator end);

        5��binary_search
                    ��1�����ܣ�����ָ����Ԫ�أ��鵽����true�����򷵻�false�������������в����ã������ˣ������ȷ��
                    ��2������ԭ��
                                    bool binary_search(iterator beg, iterator end, value);

        6��count
                    ��1������ԭ��
                                    count(iterator beg, iterator end, value);       //ͳ���Զ������ͣ�������==

        7��count_if
                    ��1�����ܣ�������ͳ��Ԫ�ظ���
                    ��2������ԭ��
                                    count_if(iterator beg, iterator end, _Pred);        //_Pred��������ν��(����bool�ķº���)
    */
    /*cout << count_if(v.begin(), v.end(), cif) << endl;*/
    /*system("pause");
}*/