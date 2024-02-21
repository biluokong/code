#include<iostream>
#include<string>
using namespace std;

class book
{
public:
    int page;
    static int p;
    mutable int pa;
    book& add(book& b)   //返回类型不加&号时值传递，会拷贝出临时对象，无法对原对象继续操作
    {
        this->page += b.page;
        return *this;
    }
    void show()
    {
        cout << "这是book类" << endl;
    }
    void showpage()
    {
        if ( this == NULL )     //判断是否是空指针，提高程序的健壮性
        {
            return;
        }
        cout << "页数" << page << endl;       //这里的page默认加了this，实际是this->page
    }
    static void func(){}
    void display() const
    {
        pa = 10;        //加mutable声明后就不会报错了
        /*page = 19; */     //函数后加了const后编译器包错，相当于在this指针前面加了const变成了const book* const this; 常量指针常量  ( 原来是book* const this; 指针常量)
        cout << "page=" << page << endl;
    }
};

//void main()
//{
    /* 1、成员变量和成员函数分开储存
    *           （1）空类占一个字节：是为了区分不同的空对象，让它们有不同的内存地址
    *           （2）非空类所占内存不会算空类的一个字节，因为此时用不着再加字节区分对象了，已经有内存空间可以用来区分对象了
    *           （3）静态成员变量不属于类对象的，计算类对象的内存时，不会算进去
    *           （4）成员函数(不论是否静态)与静态成员变量一样，只在类中有一份（已经够用了），不属于类对象上的，创建对象时，不会算进它们的内存
    */          
    /*book b;
    cout << sizeof(b) << endl;*/

    /* 2、this指针概念
    *           （1）引入：非静态成员函数只有一份，那它怎么区分是哪个对象调用的它呢？（静态成员函数只能访问静态成员变量，用不着this指针，实际也用不了）
    *           （2）可区分原因：this指针指向被调用的成员函数所属的对象（指向实例对象本身，每一个实例对象都有它自己的this指针），每一个非静态成员函数体内都隐含了this指针
    *           （3）用途：  ①当形参和实参同名时，可用this指针来区分      ②在类的非静态成员函数中返回对象本身时，可使用return *this
    *           （4）this指针本质是指针常量，不可以修改的指向
    */
   /* book b;
    b.page = 10;
    book bk;
    bk.page = 0;
    bk.add(b).add(b).add(b);
    cout << bk.page << endl;*/

    /* 3、空指针访问成员函数
    *           （1）C++中空指针也可以调用成员函数，但要注意是否用到了this指针，若用到了，则需加以判断保证代码的健壮性
    *           （2）成员变量在调用时其前面是默认有this.的
    */
    /*book* p = NULL;
    p->show();*/
    /*p->showpage();*/      //运行时复数异常，提示：访问权限冲突，因为这里调用的函数有this指针，会出现空指针异常，相当于NULL.page

    /* 4、const修饰成员函数
    *           （1）常函数： ①成员函数(括号)后加const的函数叫常函数     ②常函数内不可以修改成员属性      ③成员属性声明时加了mutable(可变的) 关键字则在常函数也可以修改
    *           （2）常对象； ①声明对象时加const关键字的对象为常对象      ②常对象只能调用常函数和修改加mutable关键字的成员属性
    */
    /*book b;
    b.display();
    const book bo;*/
    /*bo.show();*/      //报错
    /*bo.page = 10;*/       //报错
    /*bo.pa = 10;*/     //不报错
   /* system("pause");
}*/