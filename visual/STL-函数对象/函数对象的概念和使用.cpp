#include <iostream>
using namespace std;
#include <string.h>

/* 1����������
                ��1��������غ������ò��������࣬����󳣳�Ϊ�������󣻺�������ʹ�����ص�()ʱ����Ϊ���ƺ������ã�Ҳ�зº���
                ��2�����ʣ���������(�º���)��һ���࣬����һ������

    2��ʹ��
                ��1������������ʹ��ʱ����������ͨ�����������ã������в����������з���ֵ
                ��2����������Ҳ�г�������ͨ��������Ĳ��֣���������������Լ���״̬
                ��3���������������Ϊ��������
*/
//������������ͨ��������
//class Myadd
//{
//public:
//    int operator()(int v1, int v2)
//    {
//        return v1 + v2;
//    }
//};
//
////���������״̬
//class Myprint
//{
//public:
//    Myprint() { count = 0; }
//    void operator()(string s)
//    {
//        cout << s << endl;
//        count++;
//    }
//    int count;  //�ڲ��Լ���״̬
//};
//
////����������Ϊ����
//void test(Myprint& mp, string s)
//{
//    mp(s);
//}

//void main()
//{
//    //����ͨ�����Ķ��巽ʽ
//    Myadd add;
//    cout << add(10, 10) << endl;
//
//    //��ͬ����ͨ�������õķ�ʽ����ͨ���������࣬���º������Լ�¼���ڲ���״̬
//    Myprint p;
//    p("hellowoo");
//    p("hellowoo");
//    p("hellowoo");
//    p("hellowoo");
//    cout << p.count << endl;
//
//    //����������Ϊ��������
//    test(p, "eeee");
//    system("pause");
//}