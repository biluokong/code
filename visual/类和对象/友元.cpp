#include<iostream>
#include<string>
using namespace std;
/*
* ע�⣺����Ա��������Ԫʱ�������ࡢ������ʵ�����ŵ�˳����Ҫ�ر�ע�⣬�����������һֱ������ʾ������δ����
*           1��Ҫ�õ�������ǰ����
*           2�����������õ��Ķ������Ժͺ��������ڵ���֮ǰ��ʵ�֣����ֱ�Ӽ�סģ�壬�����ʵ��(������һ�����˽�����Եĺ���)�����������һ����(��ʵ�����г�Ա)������
*                   �磺���������ʾ��
*/

class house;
class goodFriend
{
public:
    void visit(house& h);
    void visit2(house& h);
};

class house
{
    friend  void goodFriend::visit2(house& h);      //��Ա��������Ԫ
   /* friend class goodFriend;*/        //������Ԫ
    friend void goodFriend(house& h);       //ȫ�ֺ�������Ԫ
public:
    house();
    string sittingRoom;
private:
    string bedRoom;
};

house::house()
{
    sittingRoom = "����";
    bedRoom = "����";
}

void goodFriend(house& h)
{
    cout << "�����ѷ������ҵ�" << h.sittingRoom << endl;
    cout << "�����ѷ������ҵ�" << h.bedRoom << endl;        //û����friend���ε�ȫ�ֺ�������ʱ��������������ʾ�����ɷ���
}

void goodFriend::visit(house& h)
{
    cout << "�����ѷ������ҵ�" << h.sittingRoom << endl;
    /*cout << "�����ѷ������ҵ�" << h.bedRoom << endl;*/        //û��friend���ε�������ʱ��������������ʾ�����ɷ���
}

void goodFriend::visit2(house& h)                                                               //ֻ��visit2�����ܷ���house���˽�����ԣ��Ȱ�goodFriend�����Ԫ����ע�͵�
{
    cout << "�����ѷ������ҵ�" << h.sittingRoom << endl;
    cout << "�����ѷ������ҵ�" << h.bedRoom << endl;
}

//void main()
//{
//    /* 1�����壺����һ�����������������һ�����е�˽�г�Ա����ؼ�����friend
//    * 
//    *  2����Ԫ������ʵ�ַ�ʽ��
//    * 
//    *           ��1��ȫ�ֺ�������Ԫ�������м� ��friend ����������
//    * 
//    *           ��2��������Ԫ�������мӡ�friend ���������
//    * 
//    *           ��3����Ա��������Ԫ��
//    * 
//    *             ���䣺����д��Ա�����ķ���������������������������д������ʵ�֣���д��ʽ��������ֵ���� ����::������( ) { }��(������������)
//    */
//    house h;
//    goodFriend(h);      //ȫ�ֺ�������Ԫ
//    class goodFriend g;     //�����ͺ�������ͬʱ���������޷����֣�����class ���� ���� ��ʽ����ʵ������
//    g.visit(h);             //������Ԫ
//    g.visit2(h);        //��Ա��������Ԫ
//    system("pause");
//}