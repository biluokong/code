#include <iostream>
using namespace std;
#include <set>

//set/multiset����Ҳ�м�������

/* 1����������
            ��1����飺����Ԫ�ض����ڲ���ʱ�Զ�����
            ��2�����ʣ�set/multiset���ڹ���ʽ�������ײ�ṹ�Ƕ�����
            ��3��set��multiset������     ��set���������������ظ�Ԫ�أ���������ͬԪ�أ��ᱻ����      ��multiset�������������ظ�Ԫ��

    2������͸�ֵ
                ��1������
                            set<T> st;
                            set(const set& st);
                ��2����ֵ
                            set& operator=(const set& st);

    3����С�ͽ���
                size();
                empty();
                swap(st);

    4�������ɾ��
                insert(elem);
                clear();
                erase(pos);                 //ɾ��pos��������ָ��Ԫ�أ�������һ��Ԫ�صĵ�����
                erase(beg, end);        //ɾ������[beg, end)������Ԫ�أ�������һ��Ԫ�صĵ�����
                erase(elem);              //ɾ��������ֵΪelem��Ԫ��

    5�����Һ�ͳ��
                find(key);                  //����key�Ƿ���ڣ����ظü�ֵ��Ԫ�صĵ��������������ڣ�����set.end();
                count(key);               //ͳ��key��Ԫ�صĸ���     �����set����ֻ�ܷ���0��1

    6��set��multiset������
                ��1��set�����Բ����ظ�Ԫ�أ���multiset����
                ��2��set�������ݵ�ͬʱ�᷵�ز���������ʾ�����Ƿ�ɹ����䷵��ֵ��һ��ֵ(iterator, bool)��������pair���ͽ���
                ��3��multiset���������ݣ����һ�������ظ�����

    7��pair���鴴�����������ͷ�ļ���
                ��1�������������ɶԳ��ֵ����ݣ����ö�����Խ�����������
                ��2��������ʽ
                                pair<type, type> p(value1, value2);     //Ĭ�Ϲ���
                                pair<type, type> p = make_pair(value1, value2);
                ��3�����÷�ʽ
                                p.first     //��һ��ֵ
                                p.second    //�ڶ���ֵ

    8������Ĭ�ϴ�С���󣬿����÷º������ı��������Ҫ��set����û����Ԫ��֮ǰָ���������
                    ���Զ����࣬ͬ�������ô˷�����Ҳ��������������<������������ܴ������ã���Ҫ�������ã���Ҫ��const��������
                    ���÷º���ʱ����vs2019���ں������ź��const����
                
*/

//����һ���º���
//class MyCompare
//{
//public:
//    MyCompare();
//    ~MyCompare();
//    bool operator()(int v1, int v2) const
//        {
//            return v1 > v2;
//        }
//private:
//    
//};
//
//MyCompare::MyCompare()
//{}
//
//MyCompare::~MyCompare()
//{}
//
//void main()
//{
//    set<int> s;
//    //����set��������ʱ�ķ���ֵ
//    pair<set<int>::iterator, bool> ret = s.insert(2);
//    if ( ret.second )
//    {
//        cout << "����ɹ�" << endl;
//    }
//    else
//    {
//        cout << "����ʧ��" << endl;
//    }
//    ret = s.insert(2);
//    if ( ret.second )
//    {
//        cout << "����ɹ�" << endl;
//    }
//    else
//    {
//        cout << "����ʧ��" << endl;
//    }
//
//    //�ı�Ĭ������ʽ
//    set<int, MyCompare> s1;
//    s1.insert(2);
//    s1.insert(1);
//    s1.insert(7);
//    s1.insert(3);
//    for ( set<int, MyCompare>::iterator it = s1.begin(); it != s1.end(); it++ )
//    {
//        cout << *it << " ";
//    }
//    system("pause");
//}