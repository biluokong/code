#include<iostream>
#include<string>
using namespace std;

//����CPU��
class CPU
{
public:
    //����ļ��㺯��
    virtual void calculate() = 0;
};

//�����Կ���
class VideCard
{
public:
    //�������ʾ����
    virtual void display() = 0;
};

//�����ڴ���
class Memory
{
public:
    //����Ĵ��溯��
    virtual void storage() = 0;
};

//������
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
        //�������������
        m_cpu->calculate();
        m_vc->display();
        m_mem->storage();
    }

    //��������
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
    CPU* m_cpu;   //CPU�����ָ��
    VideCard* m_vc;   //�Կ������ָ��
    Memory* m_mem;    //�ڴ��������ָ��
};

//����ĳ���
class IntelCPU : public CPU
{
public:
    virtual void calculate()
    {
        cout << "Intel��CPU��ʼ������" << endl;
    }
};

class IntelVideoCard : public VideCard
{
public:
    virtual void display()
    {
        cout << "Intel���Կ���ʼ��ʾ��" << endl;
    }
};

class IntelMemory : public Memory
{
public:
    virtual void storage()
    {
        cout << "Intel���ڴ�����ʼ������" << endl;
    }
};

void test31()
{
    //����һ̨���Ե����
    CPU* intelCpu = new IntelCPU;
    VideCard* intelCard = new IntelVideoCard;
    Memory* intelMem = new IntelMemory;

    //����һ̨����
    Computer* intelCom = new Computer(intelCpu, intelCard, intelMem);
    intelCom->work();
    //���ﲢ�����ͷŸɾ��ڴ棬��ΪCPU���Կ����ڴ�����û���ͷ�
    delete intelCom;
}

void main()
{
    test31();
    
    system("pause");
}