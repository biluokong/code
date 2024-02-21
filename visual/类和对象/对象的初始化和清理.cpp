#include<iostream>
using namespace std;

class Car
{
private:
    string name;
    string* id;
public:
    Car(const Car& c)
    {
        cout << "拷贝构造" << endl;
        name = c.name;
        /*id = c.id;*/      //这是浅拷贝，只是把地址的值赋给了新的对象，是默认方式下的拷贝函数的语句
        id = new string(*c.id);     //重写默认语句
    }
    Car()
    {
        cout << "无参构造函数" << endl;
    }

    ~Car()
    {
        cout << "析构函数" << endl;
        if ( id != NULL )
        {
            delete(id);
            id = NULL;
        }
    }
    Car(string n, string i)
    {
        cout << "有参构造函数" << endl;
        name = n;
        id = new string(i);
    }
    void display()
    {
        cout << "name=" << name << endl;
        cout << "id=" << *id << endl;
        cout << (int) id << endl;
    }
};

void test01()
{
    Car c;     //局部变量
}

Car test03()
{
    Car c;
    cout << "以值方式返回局部对象" << endl;
    cout << (int) &c << endl;
    return c;
}

void test02(Car c)
{
    cout << "值传递方式给函数参数传值" << endl;
    cout << (int) &c << endl;
    Car d = c;
    cout << "==============" << endl;
    cout << (int) &d << endl;
}

void test04()
{
    Car c("张三", "1234");
    c.display();
    Car d(c);
    d.display();
}
//   7、
class Phone
{
    string name;
public:
    Phone(string n) : name(n)
    {
        cout << "phone" << endl;
    }
    ~Phone() { cout << "phone的析构" << endl; }
};
class People
{
    string name;
    Phone p;
public:
    People() : name("张三"), p("苹果")      //p("苹果")等同于Phone p = Phone("苹果")（隐式转换）
    {
        cout << "people" << endl;
    }
    ~People() { cout << "people的析构" << endl; }
};
void test06()
{
    People p;
}
//void main()
//{
/*
* 1、构造函数和析构函数（c++中用来处理初始化和清理的问题，会被编译器自动调用，若程序员没有提供，则编译器会提供它的空实现（空函数体））
*       （1）构造函数：在创建对象时为对象的成员属性赋初值
*                   a、语法：类名 () {}     
*                   b、没有返回值也不用写void（相当于返回自身）
*                   c、函数名和类名相同
*                   d、可以无参数，可以有参数，因此可以发生重载
*                   e、创建对象时编译器自动调用，且只调用一次
*                         
*       （2）析构函数：在对象销毁时执行一些清理工作
*                   a、语法：~类名 () {}
*                   b、没有返回值也不用写void（相当于返回自身）
*                   c、函数名和类名相同，前面再加是~
*                   d、不可以有参数，因此不可以发生重载
*                   e、创建对象时编译器自动调用，且只调用一次
*/
   /* test01();
    cout << "==============" << endl;*/

/* 2、构造函数的分类及调用
*       （1）两种分类方式：
*                   a、按参数：有参构造和无参构造
*                   b、按类型：普通构造和拷贝构造    (拷贝函数写法：类名 (const 类名& 实例变量) {}     将这个对象的实现拷贝到创建的新对象身上，但不要改变了原对象的属性)
* 
*       （2）三种调用方式：(son为Son的实例对象)
                    a、括号法：  ①无括号调无参构造：Son s;        ②有括号无参数则不创建对象，编译器会把它当函数声明：Son s();      ③有括号有参数则调有参：Son s(12);
                    b、显示法：  ①无参：Son s;      ②有参：Son s = Son(10);         单独"Son(10);"会创建一个匿名对象，这一语句一结束，此对象内存会被编译器立马回收；
                                                                                    Son s = Son(son);       单独"Son(son);"等价与Son son；编译器会报错，提示：重定义
                    c、隐式转换法：    ①无参：Son s;      ②有参：Son s = 10;     Son s = son;     ( 等同于Son s = Son(10) 和 Son s = Son(son) )
*/
    /*Car c;
    Car d = Car(10);
    Car e = Car(c);*/
    //Car(c);

/* 3、拷贝函数的三种使用方式：
        （1）初始化一个新的对象：因为使用的是“类名&”的形式，所以不会创建一个临时的实例对象
        （2）值传递方式给函数参数传值：会创建一个临时的实例对象，并用拷贝构造函数初始化
        （3）以值方式返回局部对象：会创建一个临时的实例对象，并用拷贝构造函数初始化
*/
    /*test02(test03());*/

/* 4、构造函数调用规则
*       （1）默认情况下，编译器会给一个类三个函数：默认无参空实现构造函数、默认无参空实现析构函数 和 默认拷贝构造函数
*       （2）如果程序员只给了有参构造，则编译器不再提供默认无参构造，但会提供默认拷贝构造；如果只给了拷贝函数，则编译器不会提供其它构造函数
*/
/* 5、深拷贝和浅拷贝
*       （1）浅拷贝：简单的赋值拷贝操作
*       （2）深拷贝：在堆区重新申请空间，进行拷贝操作
*         若在类中的属性是在堆区转中开辟内存的，则需要重写析构函数来在对象销毁时释放其内存，
*         但此时其属性是一个指针，则当用编译器默认的拷贝函数来进行赋值时，进行的是浅拷贝，只会把地址这个值赋给对象，
           则当编译器调用析构函数时会释放两次指向同一块内存空间的内存，
*         造成读取访问权限冲突的异常，则此时应重写拷贝函数，让其进行深拷贝，在堆区再开辟一块空间来存放数据
*/
    /*test04();*/

/*6、初始化列表
*       （1）语法：构造函数( ) : 属性1(值1), 属性2(值2), ...... { }
*       （2）实例：Car() : name("张三")， id(new string("1234")) { }              不灵活，值固定
*                          Car(string n, string i) :  name(n), id(new string(i)) { }        灵活，值不固定
* 
* 7、类对象作为类成员时，构造时先构造类成员，再构造本类，析构的顺序则相反
*/
    /*test06();*/
    // system("pause");
//} 
/* 8、静态成员（注意，访问权限同样适用于静态成员）
*       （1）静态成员变量：  ①所有对象共用一份数据     ②在编译阶段分配内存      ③类内声明，类外初始化     ④可通过 "对象点" 或 "类名::" 访问
*       （2）静态成员函数：  ①所有对象共享同一个函数        ②静态成员函数只能访问静态成员变量(因为若是非静态，不知道访问哪一个)       ③可通过 "对象点" 或 "类名::" 访问
*/
class pen
{
public:
    static int length;
    int high;
    static void p()
    {
        length = 10;
        /*high = 12; */     //编译器报错
    }
};
int pen::length = 0;
//void main()
//{
//    pen p;
//    p.length = 22;
//}