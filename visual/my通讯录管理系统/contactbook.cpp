#include "ͨѶ¼����ϵͳ.h"

ContactBook::ContactBook()
{
    length = 0;
}

void ContactBook::add(string name, bool sex, int age, string phone, string addr)
{
    book[length].name = name;
    book[length].sex = sex;
    book[length].age = age;
    book[length].phone = phone;
    book[length].addr = addr;
    length++;
}

void ContactBook::display(int i)
{
    cout << "������" << book[i].name << "\t�Ա�" << (book[i].sex ? "��" : "Ů") << "\t���䣺" << book[i].age << "\t�绰��" << book[i].phone << "��ͥ��ַ��" << book[i].addr << endl;
}

void ContactBook::set(int i, string name, bool sex, int age, string phone, string addr)
{
    book[i].name = name;
    book[i].sex = sex;
    book[i].age = age;
    book[i].phone = phone;
    book[i].addr = addr;
}

int ContactBook::getLength()
{
    return length;
}