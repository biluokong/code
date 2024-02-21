#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>

/*  1����������
                ��1������bool���͵ķº�����Ϊν��
                ��2�����operator()����һ����������ô����һԪν��
                ��3�����operator()���ܶ�����������ô������Ԫν��

    2��һԪν��
*/

//һԪν��
class GreateFive
{
public:
    bool operator()(int val)
    {
        return val > 5;
    }
};

void test1()
{
    vector<int> v;
    for ( int i = 0; i < 10; i++ )
    {
        v.push_back(i);
    }
    //������������û�д���5����
    vector<int>::iterator it = find_if(v.begin(), v.end(), GreateFive());      //�����GreateFive��һ�������ĺ�������
    if ( it == v.end() )
    {
        cout << "δ�ҵ�" << endl;
    }
    else
    {
        cout << "�ҵ���" << endl;
    }
}

//��Ԫν��
//ʹ�ú�������ı��㷨����
class MyCompare
{
public:
    bool operator()(int val1, int val2)
    {
        return val1 > val2;
    }
};

void test2()
{
    vector<int> v;
    v.push_back(10);
    v.push_back(60);
    v.push_back(50);
    v.push_back(30);
    v.push_back(40);
    sort(v.begin(), v.end());
    for ( vector<int>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << *it << " ";
    }
    cout << endl;
    //�ú�������ı��������
    sort(v.begin(), v.end(), MyCompare());
    for ( vector<int>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << *it << " ";
    }
}

//void main()
//{
//    /*test1();*/
//    test2();
//    system("pause");
//}