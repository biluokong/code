#include<iostream>
#include<fstream>
using namespace std;

class Person
{
public:
    char m_Name[64];
    int m_Age;
};

void test03()
{
    //���������Է���һ��
    /*ofstream ofs;
    ofs.open("person.txt", ios::out | ios::binary);*/
    ofstream ofs("person.txt", ios::out | ios::binary);
    Person p = { "����", 18 };
    ofs.write((const char*) &p, sizeof(Person));
    ofs.close();
}

void test04()
{
    ifstream ifs;
    ifs.open("person.txt", ios::in | ios::binary);
    if ( !ifs.is_open() )
    {
        cout << "�ļ���ʧ��" << endl;
        return;
    }
    Person p;
    ifs.read((char*) &p, sizeof(Person));
    cout << "������" << p.m_Name << endl;
    cout << "���䣺" << p.m_Age << endl;
    ifs.close();
}

void main()
{
    /* 1��д�ļ�
    *           ��1����ʽ����Ҫ������������ó�Ա����write
    *           ��2������ԭ�ͣ�ostream& write(const char* buffer, int len)��
    *           ��3���������ͣ��ַ�ָ��bufferָ���ڴ���һ�οռ䣬len�Ƕ�д���ֽ���
    */
    /*test03();*/

    /* 2�����ļ�
    *           ��1����ʽ����Ҫ������������ó�Ա����read
    *           ��2������ԭ�ͣ�istream& read(char* buffer, int len);
    *           ��3���������ͣ��ַ�ָ��bufferָ���ڴ���һ�δ���ռ䣬len�Ƕ�д���ֽ���
    */
    test04();
    system("pause");
}