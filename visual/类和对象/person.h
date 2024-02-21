#pragma once  //防止头文件重复包含
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
