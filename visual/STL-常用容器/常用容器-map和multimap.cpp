#include <iostream>
using namespace std;
#include <map>

/* 1����������
                ��1�����
                                ��map������Ԫ�ض���pair����
                                ��pair�е�һ��Ԫ��Ϊkey(��ֵ)�����������ã��ڶ���Ԫ��Ϊvalue(ʵֵ)
                                ������Ԫ�ض������Ԫ�صļ�ֵ�Զ�����
                ��2�����ʣ��ǹ���ʽ�������ײ�ṹ���ö�����ʵ��
                ��3���ŵ㣺���Ը��ݼ�ֵkey�����ҵ�valueֵ
                ��4��map��multimap������map�������ظ�keyֵ���֣���multimap����value�������ظ�

    2������͸�ֵ
                map<T1, T2> mp
                map(const map& mp);
                map& operator=(const map& mp);

    3����С�ͽ���
                size();
                empty();
                swap(mp);

    4�������ɾ��
                insert(elem);          //���ֲ��뷽ʽ��
                                                                        ��mp.insert(pair<int, int>(1, 10));      
                                                                        ��mp.insert(make_pair(2, 10));���ڶ��ֲ���Ҫָ�����ͣ�дģ�������     �����õڶ���
                                                                        ��mp.insert(map<int, int>::value_type(3, 30));
                                                                        ��mp[4] = 40;        �����飬��Ϊ����ֵ����ʱ����Ĭ�ϸ�ֵ0��
                clear();
                erase(pos);                 //ɾ��pos��������ָ��Ԫ�أ�������һ��Ԫ�صĵ�����
                erase(beg, end);        //ɾ������[beg, end)������Ԫ�أ�������һ��Ԫ�صĵ�����
                erase(key);                 //ɾ����ֵΪkey��Ԫ��

    5����ȡ
                mp[key]                         //��ü�ֵΪkey��value
                mp[key] = value;           //�Լ�ֵΪkey�Ķ�Ӧvalue��ֵ
                mp[key];                        //Ĭ�ϸ�ֵ0��value

    6�����Һ�ͳ��
                find(key);                      //ͬset
                count(key);                   //ͬset

    7������Ĭ�����������keyֵ��С���󣬸ı��������ͬset
*/
void main()
{
    map<int, int> p;
    //�����ֲ��뷽��
    p[1] = 2;
    p[2];
    cout << p[1] << endl;
    cout << p[2] << endl;
    cout << p[3] << endl;

    system("pause");
}