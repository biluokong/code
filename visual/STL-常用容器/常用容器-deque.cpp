#include <iostream>
using namespace std;
#include <deque>

void prindeque(const deque<int>& d)
{
    for ( deque<int>::const_iterator it = d.begin(); it != d.end(); it++ )      //����d�����޸ģ������const�����Ӻ󣬾�Ҫ��ֻ����ֻ���ĵ�������const_iterator����������ͨ������ 
    {
        cout << *it << endl;
    }
    for ( int i : d )
    {
        cout << i << " ";
    }
    cout << endl;
}

void test31()
{
    deque<int> d;
    for ( int i = 0; i < 10; i++ )
    {
        d.push_back(i);
    }
    prindeque(d);
}

//void main()
//{
    /* 1���������
                    ��1�����ܣ�˫�����飬���Զ�ͷ�˽��в���ɾ������
                    ��2��deque��vector������
                                        ��vector����ͷ�˵Ĳ���ɾ��Ч�ʵͣ�������Խ��Ч��Խ��
                                        ��deque��Զ��ԣ���ͷ���Ĳ���ɾ���ٶȻ��vector��
                                        ��vector����Ԫ��ʱ���ٶȱ�deque�죬���������ڲ�ʵ���й�
                    ��3���ڲ�����ԭ�����ڲ��и��п�����ά��ÿ�λ������е����ݣ��������д����ʵ����(��ɢ�б�)���п���ά������ÿ���������ĵ�ַ��ʹ��ʹ��dequeʱ��һƬ�������ڴ�ռ�
                    ��4��deque�����ĵ�����Ҳ��֧��������ʵ�

        2�����캯��
                    deque<T> depT;                            //Ĭ�Ϲ���
                    deque(beg, end);                            //���캯����[beg, end)�����Ԫ�ؿ���������
                    deque(n, elem);                              //���캯����n��elem����������
                    deque(const deque& deq);            //�������캯��

        3����ֵ����
                    deque& operator=(const deque& bed);             //������ֵ������
                    assign(beg, end);                                                  //��[beg, end)�����е����ݿ�����ֵ������
                    assign(n, elem);                                                    //��n��elem������ֵ������

        4����С����
                    deque.empty();                           //�ж������Ƿ�Ϊ��
                    deque.size();                               //����������Ԫ�صĸ���
                    deque.resize(num);                    //����ָ�������ĳ���Ϊnum���������䳤������Ĭ��ֵ�����������̣���ɾ������Ԫ��
                    deque.resize(num, elem);          //����ָ�������ĳ���Ϊnum���������䳤������elem�����������̣���ɾ������Ԫ��
                    �ܽ᣺dequeû�������ĸ������û�л�������ĺ���

        5�������ɾ��
                    ��1�����˲������
                                    push_back(elem);                            //������β�����һ������
                                    push_front(elem);                           //������ͷ�����һ������
                                    pop_back();                                     //ɾ���������һ������
                                    pop_front();                                    //ɾ��������һ������
                    ��2��ָ��λ�ò���
                                    insert(pos, elem);                          //��posλ�ò���һ��elemԪ�صĿ��������������ݵ�λ��
                                    insert(pos, n, elem);                      //��posλ�ò���n��elem���ݣ��޷���ֵ
                                    insert(pos, beg, end);                   //��posλ�ò���[beg, end)��������ݣ��޷���ֵ
                                    clear();                                          //�����������������
                                    erase(beg, end);                           //ɾ��[beg, end)��������ݣ�������һ�����ݵ�λ��
                                    erase(pos);                                   //ɾ��posλ�õ����ݣ�������һ�����ݵ�λ��
                                    ע�⣺��������ɾ���ṩ��λ��(pos)�ǵ�����

        6�����ݴ�ȡ
                    at(int idx);                                    //��������idx��ָ������
                    operator[idx];                              //��������idx��ָ������
                    front();                                         //���������е�һ������Ԫ��
                    back();                                         //�������������һ������Ԫ��

        7�����������ͷ�ļ� algorithm(��׼�㷨��ͷ�ļ�)
                    sort(iterator beg, iterator end);   //��[beg, end]�����ڵ�Ԫ�ؽ�������Ĭ�ϴ�С�����������С�
                    ע����֧��������ʵĵ���������������������sort�㷨ֱ�ӽ�������vector������
    */
    /*test31();
    system("pause");
}*/