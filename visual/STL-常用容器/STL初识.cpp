#include <iostream>
using namespace std;
#include <vector>
#include <algorithm>    //��׼�㷨ͷ�ļ�
#include <string.h>

/*
1��STL�ĵ���
        ��1�����������������һֱϣ������һ�ֿ��ظ����õĶ���
        ��2��C++���������ͷ��ͱ��˼�룬Ŀ�ľ��Ǹ����Ե�����
        ��3���������£����ݽṹ���㷨��δ����һ�ױ�׼�����±��ȴ��´����ظ�����
        ��4��Ϊ�˽������ݽṹ���㷨��һ�ױ�׼��������STL

2��STL��������
        ��1��STL(Standard Template Liabrary. ��׼ģ���)
        ��2���ӹ����Ϸ�Ϊ������(container)���㷨(algorithm)�͵�����(iterator)
        ��3���������㷨֮��ͨ�������������޷�����
        ��4��STL�������еĴ��붼������ģ�������ģ�庯��

3��STL�������
        ��1���������������ݽṹ����vector��list��deque��set��map�ȣ������������
        ��2���㷨�����ֳ��õ��㷨����sort��find��copy��for_each��
        ��3�����������������������㷨֮��Ľ��ϼ�
        ��4���º�������Ϊ���ƺ���������Ϊ�㷨��ĳ�ֲ���
        ��5��������(�����)��һ�����������������߷º�����������ӿڵĶ���
        ��6���ռ�������������ռ�����������

4��STL���������㷨��������
        ��1�� ����������֮��Ҳ���ó��������ݽṹ����������
                        ���������֣�
                                    ����ʽ������ǿ��ֵ����������ʽ�����е�ÿһ��Ԫ�ؾ��й̶���λ��
                                    ����ʽ�������������ṹ����Ԫ��֮��û���ϸ�������ϵ�˳���ϵ
        ��2���㷨������֮����Ҳ�������޵Ĳ������߼��ϻ���ѧ�ϵ�����
                        �㷨�����֣�
                                    �ʱ��㷨��ָ��������л���������ڵ�Ԫ�����ݣ����翽�����滻��ɾ���ȵ�
                                    ���ʱ��㷨��ָ��������в�����������ڵ�Ԫ�����ݣ�������ҡ�������������Ѱ�Ҽ�ֵ�ȵ�
        ��3�����������������㷨֮���ճ�ϼ����ṩһ�ַ�����ʹ֮�ܹ�����Ѱ��ĳ�����������ĸ���Ԫ�أ��������豩¶���������ڲ���ʾ��ʽ
                        ÿ�����������Լ�ר���ĵ��������㷨ͨ�����������ܷ��������е�����
                        �������ǳ�����ָ�룬��ѧ�׶ο����Ƚ�������ָ�������
                        ���������ࣺ

                                         ����                         ����                                                                                                      ֧������
                                    ���������            �����ݵ�ֻ������                                                                               ֻ����֧��++��==��!=
                                    ���������            �����ݵ�ֻд����                                                                               ֻд��֧��++
                                    ǰ�������            ��д������������ǰ������ƽ�������                                                 ��д��֧��++��==��!=
                                    ˫�������            ��д������������ǰ��������                                                           ��д��֧��++��--
                                    ������ʵ�����     ��д��������������Ծ�ķ�ʽ�����������ݣ�������ǿ�ĵ�����            ��д��֧��++��--��[n]��-n��<��<=��>��>=

                       ���õ������е���������Ϊ˫�����������������ʵ�����
*/
void myPritnt(int val)
{
    cout << val << endl;
}

void test01()
{
    //����һ��vector����
    vector<int> v;
    //���������������
    v.push_back(10);
    v.push_back(22);
    v.push_back(14);
    //ͨ�����������������е�����
    vector<int>::iterator itBegin = v.begin();      //��ʼ��������ָ�������еĵ�һ��Ԫ��
    vector<int>::iterator itEnd = v.end();          //������������ָ�������е����һ��Ԫ�ص���һ��λ��

    //��һ�ֱ�����ʽ
    while ( itBegin != itEnd )
    {
        cout << *itBegin << endl;
        itBegin++;
    }

    //�ڶ��ֱ�����ʽ�����ã�
    for ( vector<int>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << *it << endl;
    }

    //�����ֱ�����ʽ ����STL�ṩ�����㷨
    for_each(v.begin(), v.end(), myPritnt);

    //�����ֱ�����ʽ����ǿforѭ��
    for(int i : v )
    {
        cout << i << endl;
    }
}

class Person
{
public:
    Person(string name, int age)
    {
        this->m_age = age;
        this->m_Name = name;
    }
    string m_Name;
    int m_age;
};

void test02()
{
    Person p1("aaa", 12);
    Person p2("bbb", 12);
    Person p3("ccc", 33);
    Person p4("ddd", 15);
    vector<Person> v;
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);

    //��ǿforѭ������
    for ( Person p : v )
    {
        cout << "������" << p.m_Name << "\t���䣺" << p.m_age << endl;
    }

    //�������ĺ�������
    for ( vector<Person>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << "������" << (*it).m_Name << "\t���䣺" << (*it).m_age << endl;
        cout << "������" << it->m_Name << "\t���䣺" << it->m_age << endl;
    }
}

void test03()
{
    vector<Person*> v;
    Person p1("aaa", 12);
    Person p2("bbb", 12);
    Person p3("ccc", 33);
    Person p4("ddd", 15);
    v.push_back(&p1);
    v.push_back(&p2);
    v.push_back(&p3);
    v.push_back(&p4);

    //��ǿforѭ��
    for ( Person* p : v )
    {
        cout << "������" << p->m_Name << "\t���䣺" << p->m_age << endl;
    }

    //��������
    for ( vector<Person*>::iterator it = v.begin(); it != v.end(); it++ )
    {
        cout << "������" << (*it)->m_Name << "\t���䣺" << (*it)->m_age << endl;
        cout << "������" << (**it).m_Name << "\t���䣺" << (**it).m_age << endl;
    }
}

void test04()
{
    //����Ƕ������
    vector<vector<int>> v;

    //����С����
    vector<int> v1;
    vector<int> v2;
    vector<int> v3;

    //��С�����������
    for ( int i = 0; i < 3; i++ )
    {
        v1.push_back(i);
        v2.push_back(i + 1);
        v3.push_back(i + 2);
    }

    //����������С����
    v.push_back(v1);
    v.push_back(v2);
    v.push_back(v3);

    //ͨ����������
    for ( vector<vector<int>>::iterator it = v.begin(); it != v.end(); it++ )
    {
        for ( vector<int>::iterator vit = (*it).begin(); vit != (*it).end(); vit++ )
        {
            cout << *vit << endl;
        }
    }

    //��ǿforѭ��
    for ( vector<int> vit : v )
    {
        for ( int i : vit )
        {
            cout << i << endl;
        }
    }
}

//void main()
//{
/*
5�������㷨��������ʶ��STL����õ�������vector���������Ϊ����
        ��1��vector���������������
        ������vector       �㷨��for_reach        ��������vector<int>::iterator
*/
    /*test01();*/

    /* ��2��vector����Զ�����������
    */
   /* test02();*/
    /*test03();*/

    /* ��3��vector����Ƕ������
    */
 /*   test04();
    system("pause");
}*/