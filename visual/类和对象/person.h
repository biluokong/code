#pragma once  //��ֹͷ�ļ��ظ�����
#include<iostream>
#include<string>
using namespace std;

class Person
{
    string name;
    bool sex;

public:
    void setName(string name);

    string getName();

    void setSex(bool sex);

    bool getSex();

    void display();
};
