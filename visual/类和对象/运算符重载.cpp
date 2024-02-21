#include<iostream>
#include<string>
using namespace std;

class People01
{
    friend ostream& operator<<(ostream& cout, People01 p);      //People01&、const People01&和People都行
    private:
    int money;
    int* age;
public:
    //重载前置++运算符
    //People01& operator++()      //返回引用，能链式调用，对同一数进行自增；若返回值，则不能对同一个对象进行自增
    //{
    //    money++;
    //    return *this;
    //}
    //重载后置++运算符
    //People01 operator++(int)
    //{
    //    //先记录开始结果
    //    People01 temp = *this;
    //    //后递增
    //    money++;
    //    return temp;
    //}

    //重载关系运算符
    bool operator==(People01& p)
    {
        if ( this->money == p.money )
        {
            return true;
        }
        return false;
    }

    // 改写默认赋值运算符函数
    /*People01& operator=(People01& p)
    {
        if ( age != NULL )
        {
            delete(age);
            age = NULL;
        }
        age = new int(*p.age);
        return *this;
    }*/
  
    //重载函数调用运算符
    string operator()(string str)
    {
        cout << str << endl;
        return str;
    }

    //重载加号运算符
   /* People01 operator+(const People01& p)
    {
        People01 temp;
        temp.money = money + p.money;
        return temp;
    }*/
    People01() { money = 0; age = new int(18); }
    People01(const People01& p)
    {
        cout << "拷贝函数" << endl;
        this->money = p.money;
    }

    ~People01()
    {
        if ( age != NULL )
        {
            delete(age);
            age = NULL;
        }
    }
};

//加号运算符重载
//People01& operator+(const People01& p1, const People01& p2)
//{
//    People01* p = new People01;
//    p->money = p1.money + p2.money;
//    return *p;
//}

//左移运算符重载
ostream& operator<<(ostream& cout, People01 p)     //因为cout对象全局只能有一个，所以要用哦stream& cout（记住流对象只能引用不能复制）
{
    cout << "money=" << p.money;
    return cout;
}

//void main()
//{
    /* 1、概念：对已有的运算符重新进行定义，赋予其另一种功能，已适应不同的数据类型
    * 
    *   2、注意事项：
    *            （1） 可通过重载成员函数和全局函数来实现运算符重载，且运算符重载也可以发生函数重载
    * 
    *   3、重载类型：
    * 
    *           （1）加号运算符重载：     类名(返回值) operator+( ){ }     (即写个自定义函数实现新的加法方式，然后令函数名为operator+就行了)
    * 
    *            总结：若返回类型不是没有拷贝函数的类，则返回值类型建议返回本类，不建议返回本类的引用，
    *                      无论哪种都会创建临时副本，调用拷贝函数，而局部变量返回地址不安全；
    *                      也可以在堆区开辟内存，这时返回引用是安全的
    */
    /*People01 p1;
    People01 p2;*/
    /*p1.money = 3;
    p2.money = 6;
    People01 p = p1 + p2;
    cout << p1.money << endl;
    cout << p2.money << endl;
    cout << p.money << endl;  */      //当拷贝构造函数没有赋值时，无论返回值类型为People还是People&，都会输出乱码

    //         （2）左移运算符重载：     ostream& operator<<(ostream out, 类 实例变量 ){ }      
    // 
    //           总结：成员函数实现不了，因为传不了它本身，而且传入cout 也只能简写为"实例变量<<cout",反了。所以要用全局函数;
   //                      当cout访问的实现是私有的，还需要将这个全局函数作为友元，还有记住流对象只能引用不能复制（因为因为cout对象全局只能有一个），所以传入参数要为引用;
   //                      并且如果重载运算符要(不实现返回void)实现链式调用，其返回值也只能为引用，不然会报错：无法重载只按返回值类型区分的函数
    //cout << p1 << endl;
    //          （3）递增运算符重载：     前置：类名/或类的引用 operator++( ) { }
    //                                                   后置：类名/或类的引用 operator++(int) { }        int代表占位参数，可以用来区分前值和后置递增
    //          
    //            总结：若返回引用，则可以对同一个递增进行链式调用，对同一对象进行自增
    //                      若返回值，则只只能单独自增再输入，因为重载的<<运算符传入参数时引用，而返回值的方式所返回的对象是一个临时的匿名对象，自增后就把内存释放了
    //                      前置返回引用，能链式调用；后置返回值，不能链式调用

   /* cout << p1 << endl;
    ++p1;
    cout << ++(++p1) << endl; */      //返回值时会报错，提示：没有与这些操作数匹配的“<<”运算符；
                                                           //可以改写重载<<运算符的传入参数，将引用改为值；或加const；或temp开辟到堆里
    //cout << p1 << endl;
    //cout << (p1++)++ << endl;      //不能链式调用   
    //cout << p1 << endl;

    //          （4）重载赋值运算符：
    //            总结：①C++编译器至少给一个类添加4个函数     （默认构造、默认析构、默认拷贝、赋值运算符operator=，对属性进行赋值拷贝）
    //                      ②如果类中与属性指向堆区，则做赋值操作时会出现深浅拷贝问题：当重写析构函数来释放堆内存时，使用默认赋值运算符函数时，会出现和默认拷贝函数一样的问题
    //                                                                                                                            浅拷贝时，会释放同一个地址的内存两次，引发异常，需要重写赋值运算符函数                              
    /*People01 p3;
    p1 = p2 = p3;*/

    //          （5）重载关系运算符：     bool operator==( ) { }
    /*if ( p1 == p1 )
    {
        cout << "p1和p2是先相等的" << endl;
    }*/

    //          （6）重载函数调用运算符"()"（因为像函数的调用，所以称为仿函数）:     返回值类型 operator()( ) { }
    //            总结：仿函数非常灵活，没有固定的写法
    /*p1("hello world");
    cout << People01()("hello world") << endl;*/      //这里的类名()(参数)创建了一个匿名函数对象，此对象没有名字，且此语句一完就将其内存释放了

    /*system("pause");
}*/