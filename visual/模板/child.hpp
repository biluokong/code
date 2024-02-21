#pragma once
#include <iostream>
#include <string.h>
using namespace std;

template<class T1, class T2>
class Child
{
public:
    Child(T1 name, T2 age);
    void showChild();
    T1 m_Name;
    T2 m_Age;
};

template<class T1, class T2>
Child<T1, T2>::Child(T1 name, T2 age)
{
    m_Name = name;
    m_Age = age;
}

template<class T1, class T2>
void Child<T1, T2>::showChild()
{
    cout << "ÐÕÃû£º" << m_Name << endl;
    cout << "ÄêÁä£º" << m_Age << endl;
}
