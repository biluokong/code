#include<iostream>
#include <string.h>
using namespace std;

class Ren
{
public:
    void showRen()
    {
        cout << "kkds" << endl;
    }
};

template<class NameType, class AgeType = int>       //������Լ�Ĭ�ϲ�����Ȼ����ʹ��ʱ���Բ��üӴ����͵���ʾָ������
class People
{
public:
    People(){}

    People(NameType name, AgeType age)
    {
        m_Name = name;
        m_Age = age;
    }

    void func()
    {
        m_Name.showRen();        //�ڲ�ȷ��m_Name�������ǲ���Ren������±�����������˵����ģ���еĺ����ڵ���ʱ�Ŵ���
    }

    void show()
    {
        cout << "������" << m_Name << endl;
        cout << "���䣺" << m_Age << endl;
    }
    NameType m_Name;
    AgeType m_Age;
};

/*class ssren : public People<string, int> {};*/              //ֱ�Ӽ̳���ģ��Ļ�����ָ��T1, T2�����ͣ��������޷�ȷ��Man��Ӧ�÷�������ڴ棬�ᱨ��

template<class T1, class T2>            //����ģ�巽���̳���ģ�壬���Ը��ݴ����T2ȷ���̳еĸ����NameType����
class ssren : public People<T2>     
{
public:
    void showssren()
    {
        cout << "T1������" << typeid(T1).name() << endl;
        cout << "T2������" << typeid(T2).name() << endl;
    }
};

void test02()
{
    People<string, int> p("����", 22);     //��û����ʾָ�����ͣ���ᱨ����Ϊ��ģ��û���Զ������Ƶ�
    People<string> p1("����", 23);        //��Ϊ����ģ��Ĭ�ϲ���������int���Բ��ӣ�Ҳ���Լ�
    p.show();
    p1.show();
}

void test03(People<string, int> p)      //ָ���������ͣ����ַ����õ����
{
    p.show();
}

template<class T1, class T2>
void test04(People<T1, T2> p)       //����ģ�廯
{
    p.show();
    cout << "T1������" << typeid(T1).name() << endl;       //���ô˷���֪��ģ�����ʵ�ʵ�����
}

template<class T>
void test05(T& p)       //������ģ�廯
{
    p.show();
    cout << "T������" << typeid(T).name() << endl;
}

//void main()
//{
    /* 3����ģ��
    *           ��1���﷨��template<typename T>      ͬ��typename���Ի���class
    *                    �����������
    *           ��2����ģ��ͺ���ģ�������     ����ģ��û���Զ������Ƶ���ʹ�÷���       ����ģ����ģ������б��п�����Ĭ�ϲ���
    *           ��3����ģ���г�Ա��������ʱ�������ڳ�Ա��������ʱ�Ŵ�������ͨ��ĳ�Ա������һ��ʼ�Ϳ��Դ�����
    *           ��4����ģ���������������
    *                           ���뷽ʽ����ָ����������͡���ֱ����ʾ�������������      �ڲ���ģ�廯�����������еĲ�����Ϊģ����д���     ��������ģ�廯�����������������ģ�廯���д���
    *           ��5����ģ����̳�
    *                           �ٵ�����̳еĸ�����һ����ģ��ʱ��������������ʱ��Ҫָ����������T�����ͣ������ָ�����������޷�����������ڴ�
    *                           ����������ָ���������е�T�����ͣ�����Ҳ���Ϊ��ģ��
    *           ��6����ģ���Ա��������ʵ��
    *                           ��People�࣬����ʵ�֣�����ֻ������������Ȼ��������ʵ��
    *                                                                 ʵ�ַ������ٹ��캯��    template<class T2, class T2>                                                        �ڳ�Ա����   template<class T1, class T2>
    *                                                                                                       People<T1, T2>::People(T1 name, T2 age) {��������岿��}                            void People<T1, T2>::show(){���庯����}
    */
    /*test02();*/
    /*People<string, int> p("����", 100);
    test03(p);
    test04(p);
    test05(p);*/
    /*ssren<int, string> m;
    m.showssren();
    system("pause");
}*/