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
    //这两步可以放在一起
    /*ofstream ofs;
    ofs.open("person.txt", ios::out | ios::binary);*/
    ofstream ofs("person.txt", ios::out | ios::binary);
    Person p = { "张三", 18 };
    ofs.write((const char*) &p, sizeof(Person));
    ofs.close();
}

void test04()
{
    ifstream ifs;
    ifs.open("person.txt", ios::in | ios::binary);
    if ( !ifs.is_open() )
    {
        cout << "文件打开失败" << endl;
        return;
    }
    Person p;
    ifs.read((char*) &p, sizeof(Person));
    cout << "姓名：" << p.m_Name << endl;
    cout << "年龄：" << p.m_Age << endl;
    ifs.close();
}

void main()
{
    /* 1、写文件
    *           （1）方式：主要利用流对象调用成员函数write
    *           （2）函数原型：ostream& write(const char* buffer, int len)；
    *           （3）参数解释：字符指针buffer指向内存中一段空间，len是读写的字节数
    */
    /*test03();*/

    /* 2、读文件
    *           （1）方式：主要利用流对象调用成员函数read
    *           （2）函数原型：istream& read(char* buffer, int len);
    *           （3）参数解释：字符指针buffer指向内存中一段储存空间，len是读写的字节数
    */
    test04();
    system("pause");
}