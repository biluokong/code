#include<iostream>
#include<string>
using namespace std;

//抽象CPU类
class CPU
{
public:
    //抽象的计算函数
    virtual void calculate() = 0;
};

//抽象显卡类
class VideCard
{
public:
    //抽象的显示函数
    virtual void display() = 0;
};

//抽象内存条
class Memory
{
public:
    //抽象的储存函数
    virtual void storage() = 0;
};

//电脑类
class Computer
{
public:
    Computer(CPU* cpu, VideCard* vc, Memory* mem)
    {
        m_cpu = cpu;
        m_vc = vc;
        m_mem = mem;
    }

    void work()
    {
        //让零件工作起来
        m_cpu->calculate();
        m_vc->display();
        m_mem->storage();
    }

    //析构函数
    ~Computer()
    {
        if ( m_cpu != NULL )
        {
            delete m_cpu;
            m_cpu = NULL;
        }
        if ( m_vc != NULL )
        {
            delete m_vc;
            m_vc = NULL;
        }
        if ( m_mem != NULL )
        {
            delete m_mem;
            m_mem = NULL;
        }
    }

private:
    CPU* m_cpu;   //CPU的零件指针
    VideCard* m_vc;   //显卡的零件指针
    Memory* m_mem;    //内存条的零件指针
};

//具体的厂商
class IntelCPU : public CPU
{
public:
    virtual void calculate()
    {
        cout << "Intel的CPU开始计算了" << endl;
    }
};

class IntelVideoCard : public VideCard
{
public:
    virtual void display()
    {
        cout << "Intel的显卡开始显示了" << endl;
    }
};

class IntelMemory : public Memory
{
public:
    virtual void storage()
    {
        cout << "Intel的内存条开始储存了" << endl;
    }
};

void test31()
{
    //创建一台电脑的零件
    CPU* intelCpu = new IntelCPU;
    VideCard* intelCard = new IntelVideoCard;
    Memory* intelMem = new IntelMemory;

    //创建一台电脑
    Computer* intelCom = new Computer(intelCpu, intelCard, intelMem);
    intelCom->work();
    //这里并不能释放干净内存，因为CPU、显卡和内存条并没有释放
    delete intelCom;
}

void main()
{
    test31();
    
    system("pause");
}