#include <iostream>
using namespace std;
#include <functional>
#include <vector>
#include <algorithm>

/* 1�����壺
                ��1�����STL�ڽ���һЩ��������
                ��2�����ࣺ�������º���    �ڹ�ϵ�º���      ���߼��º���
                ��3���÷����º��������Ķ����÷���һ�㺯��һ����ʹ���ڽ�����������Ҫ��ͷ�ļ�<functional>

    2�������º���
                ��1�����ܣ�ʵ���������㣻����negate��һԪ���㣬�������Ƕ�Ԫ����
                ��2���º���ԭ��
                                template<class T> T plus<T>             //�ӷ��º���
                                template<class T> T minus<T>          //�����º���
                                template<class T> T multiplies<T>    //�˷��º���
                                template<class T> T divides<T>         //�����º���
                                template<class T> T modulus<T>      //ȡģ�º���
                                template<class T> T negate<T>         //ȡ���º���  

    3����ϵ�º���
                    template<class T> bool equal_to<T>            //����
                    template<class T> bool not_equal_to<T>     //������
                    template<class T> bool greater<T>              //����     sort�����ǲ��ô����Զ����������򣬴����һ������
                    template<class T> bool greater_equal<T>    //���ڵ���
                    template<class T> bool less<T>                    //С��
                    template<class T> bool less_equal<T>         //С�ڵ���

    4���߼��º���
                    template<class T> bool logical_and<T>       //�߼���
                    template<class T> bool logical_or<T>       //�߼���
                    template<class T> bool logical_not<T>       //�߼���
*/
//�����º���
void test01()
{
    //ȡ��
    negate<int> n;
    cout << n(50) << endl;

    //�ӷ�
    plus<int> p;
    cout << p(12, 23) << endl;
}

//��ϵ�º���
void test02()
{
    vector<int> v;
    v.push_back(4);
    v.push_back(1);
    v.push_back(6);
    v.push_back(3);
    v.push_back(9);
    sort(v.begin(), v.end());   //Ĭ����������
    for ( int i : v )
    {
        cout << i << " ";
    }
    cout << endl;

    //�ı�����ʽ
    sort(v.begin(), v.end(), greater<int>());
    for ( int i : v )
    {
        cout << i << " ";
    }
}

//�߼��º���
void test3()
{
    vector<bool> v;
    v.push_back(true);
    v.push_back(false);
    v.push_back(false);
    v.push_back(true);
    for ( bool b : v )
    {
        cout << b << " ";
    }
    cout << endl;

    //�����߼��� ������v���˵�����v2�У���ִ��ȡ������
    vector<bool> v2;
    v2.resize(v.size());

    transform(v.begin(), v.end(), v2.begin(), logical_not<bool>());     //�����㷨����ǰ����������ſռ䣬��Ȼ�ᱨ��

    for ( bool b : v2 )
    {
        cout << b << " ";
    }
}

void main()
{
    //����
    /*test01();*/

    //��ϵ
    /*test02();*/

    //�߼�
    test3();
    system("pause");
}