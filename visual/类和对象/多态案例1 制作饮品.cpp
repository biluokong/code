#include<iostream>
#include<string>
using namespace std;

class AbstractDrinking
{
public:

    //煮水
    virtual void boil() = 0;

    //冲泡
    virtual void brew() = 0;

    //到人杯中
    virtual void pourInCup() = 0;

    //加入辅料
    virtual void putSomething() = 0;

    //制作饮品
    virtual void makeDrink()
    {
        boil();
        brew();
        pourInCup();
        putSomething();
    }
};

class Coffee : public AbstractDrinking
{
public:
    //煮水
    virtual void boil()
    {
        cout << "煮农夫山泉" << endl;
    }

    //冲泡
    virtual void brew()
    {
        cout << "冲泡咖啡" << endl;
    }

    //到人杯中
    virtual void pourInCup()
    {
        cout << "到入玻璃杯中" << endl;
    }

    //加入辅料
    virtual void putSomething()
    {
        cout << "加入糖和牛奶" << endl;
    }
};

class Tea : public AbstractDrinking
{
public:
    //煮水
    virtual void boil()
    {
        cout << "煮井水" << endl;
    }

    //冲泡
    virtual void brew()
    {
        cout << "冲泡茶叶" << endl;
    }

    //到人杯中
    virtual void pourInCup()
    {
        cout << "到入玻璃杯中" << endl;
    }

    //加入辅料
    virtual void putSomething()
    {
        cout << "加入枸杞" << endl;
    }
};

void doWork(AbstractDrinking* abs)
{
    abs->makeDrink();
    delete(abs);
}

//void main()
//{
//    doWork(new Coffee);
//    cout << endl;
//    doWork(new Tea);
//    system("pause");
//
//}