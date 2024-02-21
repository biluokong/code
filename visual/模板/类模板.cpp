#include<iostream>
#include <string.h>
using namespace std;

class Ren
{
public:
    void showRen()
    {
        cout << "kkds" << endl;
    }
};

template<class NameType, class AgeType = int>       //这里可以加默认参数，然后在使用时可以不用加此类型的显示指定类型
class People
{
public:
    People(){}

    People(NameType name, AgeType age)
    {
        m_Name = name;
        m_Age = age;
    }

    void func()
    {
        m_Name.showRen();        //在不确定m_Name的类型是不是Ren的情况下编译器不报错，说明类模板中的函数在调用时才创建
    }

    void show()
    {
        cout << "姓名：" << m_Name << endl;
        cout << "年龄：" << m_Age << endl;
    }
    NameType m_Name;
    AgeType m_Age;
};

/*class ssren : public People<string, int> {};*/              //直接继承类模板的话，不指定T1, T2的类型，编译器无法确定Man类应该分配多少内存，会报错

template<class T1, class T2>            //用类模板方法继承类模板，可以根据传入的T2确定继承的父类的NameType类型
class ssren : public People<T2>     
{
public:
    void showssren()
    {
        cout << "T1的类型" << typeid(T1).name() << endl;
        cout << "T2的类型" << typeid(T2).name() << endl;
    }
};

void test02()
{
    People<string, int> p("李四", 22);     //若没有显示指定类型，则会报错，因为类模板没有自动类型推导
    People<string> p1("张三", 23);        //因为已有模板默认参数，所以int可以不加，也可以加
    p.show();
    p1.show();
}

void test03(People<string, int> p)      //指定传入类型，这种方法用的最多
{
    p.show();
}

template<class T1, class T2>
void test04(People<T1, T2> p)       //参数模板化
{
    p.show();
    cout << "T1的类型" << typeid(T1).name() << endl;       //可用此方法知道模板参数实际的类型
}

template<class T>
void test05(T& p)       //整个类模板化
{
    p.show();
    cout << "T的类型" << typeid(T).name() << endl;
}

//void main()
//{
    /* 3、类模板
    *           （1）语法：template<typename T>      同上typename可以换成class
    *                    类的声明或定义
    *           （2）类模板和函数模板的区别：     ①类模板没有自动类型推导的使用方法       ②类模板在模板参数列表中可以有默认参数
    *           （3）类模板中成员函数创建时机：是在成员函数调用时才创建（普通类的成员函数在一开始就可以创建）
    *           （4）类模板对象做函数参数
    *                           传入方式：①指定传入的类型——直接显示对象的数据类型      ②参数模板化——将对象中的参数变为模板进行传递     ③整个类模板化——将这个对象类型模板化进行传递
    *           （5）类模板与继承
    *                           ①当子类继承的父类是一个类模板时，子类在声明的时候，要指定出父类中T的类型，如果不指定，编译器无法给子类分配内存
    *                           ②如果想灵活指定出父类中的T的类型，子类也需变为类模板
    *           （6）类模板成员函数类外实现
    *                           对People类，类外实现：首先只在类内声明，然后在类外实现
    *                                                                 实现方法：①构造函数    template<class T2, class T2>                                                        ②成员函数   template<class T1, class T2>
    *                                                                                                       People<T1, T2>::People(T1 name, T2 age) {函数体具体部分}                            void People<T1, T2>::show(){具体函数体}
    */
    /*test02();*/
    /*People<string, int> p("李浪", 100);
    test03(p);
    test04(p);
    test05(p);*/
    /*ssren<int, string> m;
    m.showssren();
    system("pause");
}*/