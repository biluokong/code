#include <iostream>
using namespace std;
#include <algorithm>
#include <vector>

void printv(int val)
{
    cout << val << " ";
}

void main()
{
    vector<int> v1;
    vector<int> v2;
    for ( int i = 0; i < 10; i++ )
    {
        v1.push_back(i);
        v2.push_back(i + 5);
    }
    vector<int> vTarget;

    /* 1�����
                    set_intersection        //�����������Ľ���
                    set_union                  //�����������Ĳ���
                    set_difference           //�����������Ĳ������v1��v2�Ĳ������Ϊv1�в���v1��v2�����Ĳ��֣���֮������v2�в���v1��v2�����Ĳ���
    
        2��set_intersection
                        ��1�����ܣ����������ϵĽ����������˽�������Ŀ������ָ��λ�ã�Ȼ�󷵻ؽ������һ��Ԫ����Ŀ��������λ��
                        ��2������ԭ��
                                        set_intersection(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest);    //dest��Ŀ��������ʼ������
                        ��3���ܽ᣺
                                    ���󽻼�����������������ͬ���������У�Ĭ���������轵����Ӳ���_Pred��
                                    ��Ŀ���������ٿռ�����������size����Сֵ
                                    ��set_intersection�ķ���ֵ�ǽ��������һ��Ԫ����Ŀ�������е�λ��
                                    ��Ҫȡ�䷵��ֵ��Ϊ����ʱ�Ľ������������Է�ֹ����ռ��0ֵ���
    */
    //Ŀ��������Ҫ��ǰ���ٿռ䣬���������(��Ŀ�������������ռ�����)������������С������ȡ��С������size����
    //vTarget.resize(min(v1.size(), v2.size()));      //Ҳ�����������жϡ���Ŀ�������ȡ���������ռ�
    //vector<int>::iterator it = set_intersection(v1.begin(), v1.end(), v2.begin(), v2.end(), vTarget.begin());

    ////�����˽���֮�����ռ��ֵ0����Ϊ�˱�����ʽĬ�ϵ�Ŀ�������Ľ����������Ž�������
    //for ( int i : vTarget )
    //{
    //    cout << i << " ";
    //}
    //cout << endl;
    ////���󽻼��㷨�ķ���ֵ���������������Ա����������ռ��0ֵ
    //for_each(vTarget.begin(), it, printv);

    /* 3��set_union
                    ��1�����������ϵĲ����������˲�������Ŀ������ָ��λ�ã�Ȼ�󷵻ز������һ��Ԫ����Ŀ��������λ��
                    ��2������ԭ��
                                    set_union(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest);       //dest��Ŀ�������Ŀ�ʼ������
                    ��3���ܽ᣺
                                    ���󽻼�����������������ͬ���������У�Ĭ���������轵����Ӳ���_Pred��
                                    ��Ŀ���������ٿռ�����������size�ĺ�
                                    ��set_intersection�ķ���ֵ�ǽ��������һ��Ԫ����Ŀ�������е�λ��
                                    ��Ҫȡ�䷵��ֵ��Ϊ����ʱ�Ľ������������Է�ֹ����ռ��0ֵ���
    */
    //����Ŀ�������Ŀռ䣬�������������������û�н���(��Ŀ�������������ռ�����)��ȡ��������size�ĺ�
    /*vTarget.resize(v1.size() + v2.size());
    vector<int>::iterator it = set_union(v1.begin(), v1.end(), v2.begin(), v2.end(), vTarget.begin());
    for_each(vTarget.begin(), it, printv);*/

    /* 4��set_difference
                    ��1�����ܣ������������Ĳ�������˲����Ŀ��������ָ��λ�ã�Ȼ�󷵻ز���һ��Ԫ����Ŀ��������λ��
                    ��2������ԭ��
                                    set_difference(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest);
                    ��3���ܽ᣺
                                    ���󽻼�����������������ͬ���������У�Ĭ���������轵����Ӳ���_Pred��
                                    ��Ŀ���������ٿռ�����������size�����ֵ
                                    ��set_intersection�ķ���ֵ�ǽ��������һ��Ԫ����Ŀ�������е�λ��
                                    ��Ҫȡ�䷵��ֵ��Ϊ����ʱ�Ľ������������Է�ֹ����ռ��0ֵ���
    */
    //����Ŀ�������Ŀռ䣬����������(��Ŀ�������������ռ�����)����������û�н�������ȡ����ĵ�һ��������size��Ϊ��ȫ(��һ������������λ�ÿ��ܽ���)�����ȡ������������size
    vTarget.resize(max(v1.size(), v2.size()));
    vector<int>::iterator it = set_difference(v1.begin(), v1.end(), v2.begin(), v2.end(), vTarget.begin());
    for_each(vTarget.begin(), it, printv);
    system("pause");
}
