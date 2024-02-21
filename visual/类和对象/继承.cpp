#include<iostream>
#include<string>
using namespace std;

class BasePage
{
public:
    int a;
    void header()
    {
        cout << "首页、公开课、登录。。。" << endl;
    }
    void footer()
    {
        cout << "帮助中心、交流合作、站内地图。。。" << endl;  
    }
    BasePage() 
    { 
        cout << "父类的构造函数" << endl;
        a = 0; 
        b = 0; 
        c = 0; 
    }
    ~BasePage()
    {
        cout << "父类的析构函数" << endl;
    }
protected:
    int b;
private:
    int c;
};
//java页面
class Java : public BasePage
{
public:
    int a;
    void header()
    {
        cout << "java的首页、公开课、登录。。。" << endl;
    }
    void content()
    {
        cout << "Java的学习视频" << endl;
        a = 10;     //可以访问，公共权限
        b = 20;     //可以访问，保护权限
        /*c = 30; */    //报错，不可访问私有属性
    }
    Java()
    {
        a = 10;
    }
};
//C++页面
class CPP : protected BasePage
{
public:
    void content()
    {
        cout << "C++的学习视频" << endl;
        a = 10;
        b = 20;
        /*c = 30;*/     //报错，不可以访问私有属性
    }
};

class C : private BasePage
{
public:
    int a;
    void header()
    {
        cout << "子类的首页、公开课、登录。。。" << endl;
    }
    void content()
    {
        cout << "C的学习视频" << endl;
        a = 10;
        b = 20;
        /*c = 30;*/     //报错，不可以访问私有属性
    }
    C()
    {
        cout << "子类的构造函数" << endl;
        a = 10;
    }
    ~C()
    {
        cout << "子类的析构函数" << endl;
    }
};

//void test12()
//{
//    BasePage b;
//    b.a = 10;
//   /* b.b = 20;*/       //父类中b不可访问，保护权限
//    Java j;
//    j.a = 10;
//   /* j.b = 20;*/       //报错，Java子类中b不可以访问，保护权限
//    CPP cpp;
//   /* cpp.a = 10;
//    cpp.b = 20;*/     //报错，CPP子类中a和b不可以访问，保护权限
//    C c;
//    /*c.a = 10;
//    c.b = 20;
//    c.c + 30;*/     //报错，C子类中a、b和c都不可以访问，私有属性
//}
//void test11()
//{
//    Java java;
//    CPP cpp;
//    java.header();
//    java.footer();
//    java.content();
//    cpp.header();
//    cpp.footer();
//    cpp.content();
//}

//void test13()
//{
//    cout << "Java子类的size：" << sizeof(Java) << endl;
//    cout << "CPP子类的size：" << sizeof(CPP) << endl;
//    cout << "C子类的size：" << sizeof(C) << endl;
//}

//void test14()
//{
//    BasePage b;
//    C c;
//}
//int main()
//{
    /* 1、语法：class 子类 ：继承方式 父类       （子类也称派生类，父类也称基类）
    */
    /*test11();*/

    /* 2、继承方式（不论哪种继承方式，都方法访问父类中的私有内容）
    *               （1）公共继承：子类继承父类的公共内容和保护内容，且继承的内容访问权限不变
    *               （2）保护继承：子类继承父类的公共内容和保护内容，但这些内容全部变为保护内容
    *               （3）私有继承：子类继承父类的公共内容和保护内容，但这些内容全部变为私有内容
    */
    /*test12(); */

    /* 3、继承中的对象模型：父类中所有非静态成员属性都会被继承给子类，只是父类中的私有属性会被编译器隐藏，使之访问不到，但实际上是被继承了的
    *           补充：利用开发人员提示工具查看对象模型（开发人员命令提示符）：先跳转到当前文件具体路径下，然后用命令“cl /d1 reportSingleClassLayout类名 文件名
    *                                                                                                                  （可打几个字符，按 tab键自动补全）”
    */     
   /* test13();*/

    /* 4、继承中的构造和析构顺序：先构造父类，再构造子类；先析构子类，再构造父类（创建一个子类的同时，会先创建一个父类）
    */
   /* test14();*/

    /* 5、继承同名成员处理方式：        ①访问子类同名成员：直接访问          ②访问父类同名成员：需加作用域
    */ //这里只举公共继承的例子
   /* Java j;     
    j.header();
    cout << j.a << endl;
    j.BasePage::header();
    cout << j.BasePage::a << endl;*/

    /* 6、继承同名静态成员处理方式：处理方式域继承非静态处理方式一样，但既可通过对象访问，也可通过类名访问
    *        特别的：通过子类的类名访问父类的静态成员：“子类类名::父类类名::成员” 
    */

    /* 7、多继承语法（C++中允许多继承）：class 子类 ：继承方式 父类1，继承方式 父类2，……
    * 
    *        注意：多继承可能引发父类中有同名成员出现，需加作用域区分，实际开发时不建议用多继承
    */
   /* system("pause");
    return 0;
}*/
/* 8、菱形继承（又叫钻石继承）
    * 
    *               （1）概念：两个派生类继承同一个基类，又有某个类同时继承两个派生类
    * 
    *               （2）产生的问题：       ①会出现二义性         ②继承了两份基类，重复了这份继承内容
    * 
    *               （3）利用虚继承可以解决，继承之前加上关键字“virtual”使之变为虚继承
    */
//动物类
class Animal
{
public: 
    int age;
};

//Animal类称为虚基类
//羊类
class Sheep : public virtual Animal
{
};
//驼类
class Tuo : public virtual Animal
{
};
//羊驼类
class SheepTuo : public Sheep, public Tuo
{
};
//void main()
//{
//    SheepTuo s;
//    //需加以作用域来区分，但羊驼只需一个年龄就行了，并且浪费内存
//    s.Sheep::age = 8;
//    s.Tuo::age = 10;
//    cout << s.Sheep::age << endl;
//    cout << s.Tuo::age << endl;
//    cout << s.age << endl;      //虚继承后可以如此输入了，再用开发人员命令提示符后继承的age都变为vbptr(虚基类指针)，其含义为：v-vortual；b-base；ptr-pointer，即虚基类指针
//    system("pause");
//}