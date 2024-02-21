#include<iostream>
#include<string>
using namespace std;

class AbstractDrinking
{
public:

    //��ˮ
    virtual void boil() = 0;

    //����
    virtual void brew() = 0;

    //���˱���
    virtual void pourInCup() = 0;

    //���븨��
    virtual void putSomething() = 0;

    //������Ʒ
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
    //��ˮ
    virtual void boil()
    {
        cout << "��ũ��ɽȪ" << endl;
    }

    //����
    virtual void brew()
    {
        cout << "���ݿ���" << endl;
    }

    //���˱���
    virtual void pourInCup()
    {
        cout << "���벣������" << endl;
    }

    //���븨��
    virtual void putSomething()
    {
        cout << "�����Ǻ�ţ��" << endl;
    }
};

class Tea : public AbstractDrinking
{
public:
    //��ˮ
    virtual void boil()
    {
        cout << "��ˮ" << endl;
    }

    //����
    virtual void brew()
    {
        cout << "���ݲ�Ҷ" << endl;
    }

    //���˱���
    virtual void pourInCup()
    {
        cout << "���벣������" << endl;
    }

    //���븨��
    virtual void putSomething()
    {
        cout << "�������" << endl;
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