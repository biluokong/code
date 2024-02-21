#include <iostream>
#include <string>
//#include "child.cpp"
#include "child.hpp"    //包含.h一样，后缀名并不是固定要.hpp，其它名字也行，不过建议用.hpp，因为一般程序员后这么命名
using namespace std;

template<class T1, class T2>
class Dad;

template<class T1, class T2>
void print2Dad(Dad<T1, T2> d)      //类内声明没加空模板参数列表时 报错，因为编译器会认为这两个函数不是同一个函数(一个是普通函数，一个是模板函数)
{                                                        //加之后仍然报错，因为全局函数类外实现，需要让编译器提前知到这个函数，                                                             
                                                        //方法：函数具体的实现放在类上面，但因此函数用到类对象，因此还需在函数实现上面加上类的声明，这是很麻烦的
    cout << "姓名：" << d.m_Name << endl;
}

template<class T1, class T2>
class Dad
{
    //全局函数类内实现，加了friend就是类外函数，这个只是声明和实现一起放在类内的全局函数
    friend void printDad(Dad<T1, T2> d)
    {
        cout << "姓名：" << d.m_Name << endl;
    }
        
    //全局函数类外实现，还是加了friend就是类外函数，这里只是在类内声明全局函数，在类外实现而已，需要加空模板参数列表
    friend void print2Dad<>(Dad<T1, T2> d);

public:
    Dad(T1 name, T2 age)
    {
        this->m_Name = name;
        this->m_Age = age;
    }

    T1 m_Name;
    T2 m_Age;
};

//void main()
//{
//    /* （7）类模板分文件编写
//     *                               问题：类模板成员函数创建时机是在调用阶段，导致分文件编写时链接不到
//     *                               解决：①直接包含.cpp源文件         ②将声明和实现写到同一个文件中，并更改后缀名为.hpp，hpp是约定的名称，并不是强制
//    */
//    Child<string, int> c("张三", 20);     //报错，解决方法：第一种，将.h改为.cpp；因为.h中的类模板一开始是不创建的，编译器看不到，不会去找对应.cpp文件里函数的实现；
//                                                           //当包含.cpp时，编译器会直接去.cpp文件里找，而.cpp文件里又包含了.h，这时，编译器就既能看到.h里的类模板，又能看到.cpp里具体的实现了
//                                                           //不过此方法很少用，因为一般都直接包含头文件
//    c.showChild();                                //第二种：将.h和.cpp的内容写在一起，然后将后缀名改成.hpp(约定俗成的后缀名命名方法)

    /* （8）类模板与友元
    *                   全局函数类内实现，直接在类内声明友元
    *                   全局函数类外实现，需要提前让编译器知道全局函数的存在，在类内声明时需加一个空模板参数列表，以保证让编译器自动它与类外实现的全局函数时同一个函数
    */
    /*Dad<string, int> d("知道", 22);
    printDad(d);
    print2Dad(d);*/
    /*system("pause");
}*/