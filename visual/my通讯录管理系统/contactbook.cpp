#include "通讯录管理系统.h"

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
    cout << "姓名：" << book[i].name << "\t性别：" << (book[i].sex ? "男" : "女") << "\t年龄：" << book[i].age << "\t电话：" << book[i].phone << "家庭地址：" << book[i].addr << endl;
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