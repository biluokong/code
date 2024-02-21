#include "通讯录管理系统.h"

void add()
{
    cout << "开始添加联系人，请输入联系人的信息：" << endl;
    cout << "姓名：" << endl;
    string name;
    cin >> name;
    cout << "性别：\n\t1、男性\n\t2、女性" << endl;
    bool sex;
    cin >> sex;
    cout << "年龄：" << endl;
    int age;
    cin >> age;
    cout << "电话：" << endl;
    string phone;
    cin >> phone;
    cout << "家庭住址：" << endl;
    string addr;
    cin >> addr;
    c.add(name, sex, age, phone, addr);
    cout << "添加成功！" << endl;
    system("pause");
    system("cls");
}