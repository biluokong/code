#include <iostream>
using namespace std;
#include <list>

void printlist(const list<int>& l)
{
    for ( list<int>::const_iterator it = l.begin(); it != l.end(); it++ )
    {
        cout << *it << " ";
    }
    cout << endl;
}

    /* 1����������
                    ��1�� ���ܣ������ݽ�����ʽ����
                    ��2��������һ�������Ϸ������Ĵ���ṹ������Ԫ�ص��߼�˳����ͨ�������е�ָ������ʵ�ֵ�
                    ��3��������һϵ�н����ɣ�������������ָ�������
                    ��4��STL�е�������һ��˫��ѭ������ 
                    ��5����������Ĵ��淽ʽ�������������ڴ�ռ䣬��������еĵ�����ֻ֧��ǰ�ƺͺ��ƣ�����˫�������
                    ��6���ŵ㣺���ö�̬������䣬��������ڴ��˷Ѻ����������ִ�в����ɾ������ʮ�ַ��㣬�޸�ָ�뼴�ɣ�����Ҫ�ƶ�����Ԫ��
                    ��7��ȱ�㣺���������ǿռ�(ָ����)��ʱ��(����)����ķѽϴ�
                    ��8����Ҫ���ʣ����������ɾ���������������ԭ��list��������ʵЧ������vector�ǲ�����
                    �ܽ᣺STL�е�list��vector��������õ�������������ȱ��

        2�����캯��
                    list<T> lst;
                    list(beg, end);                                 //���캯����[beg, end)�����е�Ԫ�ؿ���������
                    list(n, elem);
                    list(const list& lst);

        3����ֵ�ͽ���
                    assign(beg, end);
                    assign(n, elem);
                    list& operator=(const list& lst);
                    swap(lst); 

        4����С����
                    size();
                    empty();
                    resize(num);                            //ͬvector
                    resize(num, elem);                  //ͬvector

        5�������ɾ��
                    push_back(elem);
                    pop_back();
                    push_front(elem);
                    pop_front();
                    insert(pos, elem);                        //��posλ�ò���elem���ݣ����������ݵ�λ��
                    insert(pos, n, elem);                    //ͬvector���޷���ֵ
                    insert(pos, beg, end);
                    clear();                                        //���
                    erase(beg, end);                         //ɾ��[beg, end)��������ݣ�������һ�����ݵ�λ��
                    erase(pos);                                 //ɾ��posλ�õ����ݣ�������һ�����ݵ�λ��
                    remove(elem)                            //ɾ��������������elemֵƥ���Ԫ��

        6�����ݴ�ȡ
                    front();        //���ص�һ��Ԫ��
                    back();         //�������һ��Ԫ��

                    ���䣺
                            �����֤�Ƿ�֧��������ʣ���һ�������� it , �� it = it +1 �Ƿ�Ϸ�
                            �����֤�Ƿ�֧��˫����ʣ��� it++, �� it-- �Ƿ�Ϸ�

        7����ת������
                    reverse()��//��ת����
                    sort();        //��������Ĭ�ϴӴ�С����   �˴���sort��list���õĺ��������Ǳ�׼�㷨��sort
                    ���䣺��Ҫ����������ô�죿
                            �𣺢������������reverse()��    ����sort()�ﴫ��һ���Զ��庯�����˺����Լ����Զ���������򣻶����Զ������͵�����Ҳ�ô˷���

                    ���䣺���в�֧��������ʵ��������������������ñ�׼�㷨����֧��������ʵ��������������ڲ����ṩ��Ӧ���㷨
    */
 
//����2���ı�����ʽ
//bool myCompare(int v1, int v2)
//{
//    return v1 > v2;
//}
//void main()
//{
//    list<int> l;
//    for ( int i = 0; i < 10; i++ )
//    {
//        l.push_back(i);
//    }
//    l.sort();   //Ĭ������
//    cout << "Ĭ����������" << endl;
//    printlist(l);
//    l.sort(myCompare);        //�Զ�������ʽ
//    cout << "�ı�����ʽ֮��Ľ����" << endl;
//    printlist(l);
//    system("pause");
//}