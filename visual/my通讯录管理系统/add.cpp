#include "ͨѶ¼����ϵͳ.h"

void add()
{
    cout << "��ʼ�����ϵ�ˣ���������ϵ�˵���Ϣ��" << endl;
    cout << "������" << endl;
    string name;
    cin >> name;
    cout << "�Ա�\n\t1������\n\t2��Ů��" << endl;
    bool sex;
    cin >> sex;
    cout << "���䣺" << endl;
    int age;
    cin >> age;
    cout << "�绰��" << endl;
    string phone;
    cin >> phone;
    cout << "��ͥסַ��" << endl;
    string addr;
    cin >> addr;
    c.add(name, sex, age, phone, addr);
    cout << "��ӳɹ���" << endl;
    system("pause");
    system("cls");
}