#include<iostream>
#include<string>
using namespace std;
/*
* 注意：当成员函数做友元时，类与类、函数的实现所放的顺序需要特别注意，否则编译器会一直报错，提示此类型未定义
*           1、要用的类需提前声明
*           2、函数体内用到的对象属性和函数必须在调用之前已实现，最好直接记住模板，将类的实现(含有另一个类的私有属性的函数)放在类外的另一个类(已实现所有成员)的下面
*                   如：下面代码所示：
*/

class house;
class goodFriend
{
public:
    void visit(house& h);
    void visit2(house& h);
};

class house
{
    friend  void goodFriend::visit2(house& h);      //成员函数做友元
   /* friend class goodFriend;*/        //类做友元
    friend void goodFriend(house& h);       //全局函数做友元
public:
    house();
    string sittingRoom;
private:
    string bedRoom;
};

house::house()
{
    sittingRoom = "客厅";
    bedRoom = "卧室";
}

void goodFriend(house& h)
{
    cout << "好朋友访问了我的" << h.sittingRoom << endl;
    cout << "好朋友访问了我的" << h.bedRoom << endl;        //没加用friend修饰的全局函数声明时：编译器包错，提示：不可访问
}

void goodFriend::visit(house& h)
{
    cout << "好朋友访问了我的" << h.sittingRoom << endl;
    /*cout << "好朋友访问了我的" << h.bedRoom << endl;*/        //没加friend修饰的类声明时，编译器报错，提示：不可访问
}

void goodFriend::visit2(house& h)                                                               //只让visit2函数能访问house类的私有属性，先把goodFriend类的友元声明注释掉
{
    cout << "好朋友访问了我的" << h.sittingRoom << endl;
    cout << "好朋友访问了我的" << h.bedRoom << endl;
}

//void main()
//{
//    /* 1、意义：能让一个函数或者类访问另一个类中的私有成员，其关键字是friend
//    * 
//    *  2、友元的三种实现方式：
//    * 
//    *           （1）全局函数做友元：在类中加 “friend 函数声明”
//    * 
//    *           （2）类做友元：在类中加“friend 类的声明”
//    * 
//    *           （3）成员函数做友元：
//    * 
//    *             补充：类外写成员函数的方法：先在类内声明，再在类外写函数的实现，书写方式：“返回值类型 类名::函数名( ) { }”(即加上作用域)
//    */
//    house h;
//    goodFriend(h);      //全局函数做友元
//    class goodFriend g;     //类名和函数名相同时，编译器无法区分，可用class 类名 变量 方式创建实例对象
//    g.visit(h);             //类做友元
//    g.visit2(h);        //成员函数做友元
//    system("pause");
//}