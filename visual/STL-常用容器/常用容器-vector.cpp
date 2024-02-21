#include <iostream>
using namespace std;
#include <string>
#include <vector>

template<class T>
void prin(vector<T>& v)
{
    for ( T i : v )
    {
        cout << i << " ";
    }
    cout << endl;
}

void test21()       //���Թ��캯��
{
    vector<int> v1;     //Ĭ�Ϲ���
    for ( int i = 0; i < 10; i++ )
    {
        v1.push_back(i);
    }
    prin(v1);

    //���䷽ʽ����
    vector<int> v2(v1.begin(), v1.end());
    prin(v2);

    //n��elem��ʽ����
    vector<int> v3(10, 12);
    prin(v3);

    //��������
    vector<int> v4(v1);
    prin(v4);
}

void test22()
{
    vector<int> v1;
    for (int i = 0;i<10;i++)
    {
        v1.push_back(i);
    }
    prin(v1);
    v1.resize(20);
    prin(v1);
    v1.resize(30, 3);
    prin(v1);
    v1.resize(10, 3);
    prin(v1);
}

//void main()
//{
    /* 1����������
                    ��1�����ܣ�vector���ݽṹ������ǳ����ƣ�Ҳ��Ϊ��������
                    ��2������ͨ��������𣺲�֮ͬ�����������Ǿ�̬�ռ䣬��vector���Զ�̬��չ
                    ��3����̬��չ���ǿ��ٸ���Ŀռ䣬Ȼ��ԭ���ݿ������¿ռ䣬�ͷ�ԭ�ռ�
                    ��4��vector�����ĵ�������֧��������ʵĵ�����

        2�����캯��
                    vector<T> v;                                             //����ģ����ʵ����ʵ�֣�Ĭ�Ϲ��캯��
                    vector(v.begin(), v.end());                         //��v[begin(), end())�����е�Ԫ�ؿ�������������ҿ���
                    vector(n, elem);                                        //���캯����n��elem����������
                    vector(const vector& vec);                      //�������캯��

        3����ֵ����
                    vector& operator=(const vector& vec);           //���صȺ������
                    assign(beg, end);                                              //��[beg, end)�����е����ݿ���������
                    assign(n, elem);                                                //��n��elem������ֵ������

        4�������ʹ�С
                    boolempty();                             //�ж��Ƿ�Ϊ��
                    int capacity();                            //��������������
                    int size();                                   //����������Ԫ�صĸ���
                    resize(int num);                        //����ָ�������ĳ���Ϊnum���������䳤������Ĭ��ֵ�����λ�ã����������̣���ĩβ�� ���������ȵ�Ԫ�ر�ɾ��             
                    resize(int num, elem);              //����ָ�������ĳ���Ϊnum���������䳤������elemֵ�����λ�ã����������̣���ĩβ�����������ȵ�Ԫ�ص�Ԫ�ر�ɾ��               
        5�������ɾ��
                    push_back(ele);                                                                           //β������Ԫ��elem
                    pop_back();                                                                                 //ɾ�����һ��Ԫ��
                    insert(const_iterator pos, ele);                                                    //������ָ��posλ�ò���Ԫ��ele
                    insert(const_iterator pos, int count, ele);                                    //������ָ��λ��pos����count��Ԫ��ele
                    erase(const_iterator pos);                                                           //ɾ��������ָ���Ԫ�� 
                    erase(const_iterator start, const_iterator end);                          //ɾ����������start��end֮���Ԫ��
                    clear();                                                                                        //ɾ�������е�����Ԫ��

        6�����ݴ�ȡ
                    at(int idx);                     //��������idx��ָ������
                    operator[];                   //��������idx��ָ������
                    front();                         //���������е�һ������Ԫ��
                    back();                         //�������������һ������Ԫ��

        7����������
                    swap(vec);                  //��vec�뱾���Ԫ�ػ���
                    �������û����������������ڴ棺vector<T> (v).swap(v)��
                            �������˴��ɿ����������֣�vector<T>(v) �ڴ˴����ÿ����������Ӷ�������һ����������x(��������x)��һ��������������v�ĳ��Ⱥ�����һ������������
                            ������ִ��(v).swap(v)������x��v��ָ�룬��vָ��x���ٵ��ڴ�ռ䣬xָ������v���ڴ�ռ䣻
                            ���Ҵ����һ�����������������ڴ�ͱ���ͬ�����ˣ��Ӷ�ʹv���ڴ������ʡ���ڴ�

        8��Ԥ���ռ䣺����vector�ڶ�̬��չ����ʱ����չ����
                    reserve(int len);           //����Ԥ��len��Ԫ�أ�Ԥ��λ�ò���ʼ����Ԫ�ز��ɷ���
                    ���壺���������ܴ�ʱ������ֱ��Ԥ���㹻�Ŀռ䣬���ö�ο��ٿռ�
    */
    /*test21();*/
    /*test22();*/

    //vector��������
    //vector<int> v1, v2;
    //for ( int i = 0; i < 10; i++ )
    //{
    //    v1.push_back(i);
    //    v2.push_back(10 - i);
    //}
    //prin(v1);
    //prin(v2);
    //v1.swap(v2);
    //prin(v1);
    //prin(v2);

    ////����swap()�����ڴ棬�����ڴ��˷�
    //vector<int> v3;
    //for ( int i = 0; i < 10000; i++ )
    //{
    //    v3.push_back(i);
    //}
    //cout << v3.capacity() << "\t" << v3.size() << endl;
    //v3.resize(3);
    //cout << v3.capacity() << "\t" << v3.size() << endl;     //���ȱ�С�ˣ�������û�䣬�˷��ڴ�
    //vector<int> (v3).swap(v3);      //����д�������ڴ�ͳ���һ����
    //cout << v3.capacity() << "\t" << v3.size() << endl;

    //Ԥ���ռ�
//    vector<int> v6;
//    int num = 0;
//    int* p = NULL;
//    for ( int i = 0; i < 10000; i++ )
//    {
//        v6.push_back(i);
//        if (p != &v6[0])
//        {
//            p = &v6[0];
//            num++;
//        }
//    }
//    cout << "���ٿռ�Ĵ���Ϊ��" << num << endl;
//    cout << v6.capacity() << endl;
//    cout << v6.size() << endl;
//    vector<int> v7;
//    v7.reserve(100000);     //���������ö��ؿ��ٿռ�
//    int num1 = 0;
//    int* p1 = NULL;
//    for ( int i = 0; i < 10000; i++ )
//    {
//        v7.push_back(i);
//        if (p1 != &v7[0])
//        {
//            p1 = &v7[0];
//            num1++;
//        }
//    }
//    cout << "���ٿռ�Ĵ���Ϊ��" << num1 << endl;
//    cout << v7.capacity() << endl;
//    cout << v7.size() << endl;
//    system("pause");
//}