#include<iostream>
#include<string>
using namespace std;

class BasePage
{
public:
    int a;
    void header()
    {
        cout << "��ҳ�������Ρ���¼������" << endl;
    }
    void footer()
    {
        cout << "�������ġ�����������վ�ڵ�ͼ������" << endl;  
    }
    BasePage() 
    { 
        cout << "����Ĺ��캯��" << endl;
        a = 0; 
        b = 0; 
        c = 0; 
    }
    ~BasePage()
    {
        cout << "�������������" << endl;
    }
protected:
    int b;
private:
    int c;
};
//javaҳ��
class Java : public BasePage
{
public:
    int a;
    void header()
    {
        cout << "java����ҳ�������Ρ���¼������" << endl;
    }
    void content()
    {
        cout << "Java��ѧϰ��Ƶ" << endl;
        a = 10;     //���Է��ʣ�����Ȩ��
        b = 20;     //���Է��ʣ�����Ȩ��
        /*c = 30; */    //�������ɷ���˽������
    }
    Java()
    {
        a = 10;
    }
};
//C++ҳ��
class CPP : protected BasePage
{
public:
    void content()
    {
        cout << "C++��ѧϰ��Ƶ" << endl;
        a = 10;
        b = 20;
        /*c = 30;*/     //���������Է���˽������
    }
};

class C : private BasePage
{
public:
    int a;
    void header()
    {
        cout << "�������ҳ�������Ρ���¼������" << endl;
    }
    void content()
    {
        cout << "C��ѧϰ��Ƶ" << endl;
        a = 10;
        b = 20;
        /*c = 30;*/     //���������Է���˽������
    }
    C()
    {
        cout << "����Ĺ��캯��" << endl;
        a = 10;
    }
    ~C()
    {
        cout << "�������������" << endl;
    }
};

//void test12()
//{
//    BasePage b;
//    b.a = 10;
//   /* b.b = 20;*/       //������b���ɷ��ʣ�����Ȩ��
//    Java j;
//    j.a = 10;
//   /* j.b = 20;*/       //����Java������b�����Է��ʣ�����Ȩ��
//    CPP cpp;
//   /* cpp.a = 10;
//    cpp.b = 20;*/     //����CPP������a��b�����Է��ʣ�����Ȩ��
//    C c;
//    /*c.a = 10;
//    c.b = 20;
//    c.c + 30;*/     //����C������a��b��c�������Է��ʣ�˽������
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
//    cout << "Java�����size��" << sizeof(Java) << endl;
//    cout << "CPP�����size��" << sizeof(CPP) << endl;
//    cout << "C�����size��" << sizeof(C) << endl;
//}

//void test14()
//{
//    BasePage b;
//    C c;
//}
//int main()
//{
    /* 1���﷨��class ���� ���̳з�ʽ ����       ������Ҳ�������࣬����Ҳ�ƻ��ࣩ
    */
    /*test11();*/

    /* 2���̳з�ʽ���������ּ̳з�ʽ�����������ʸ����е�˽�����ݣ�
    *               ��1�������̳У�����̳и���Ĺ������ݺͱ������ݣ��Ҽ̳е����ݷ���Ȩ�޲���
    *               ��2�������̳У�����̳и���Ĺ������ݺͱ������ݣ�����Щ����ȫ����Ϊ��������
    *               ��3��˽�м̳У�����̳и���Ĺ������ݺͱ������ݣ�����Щ����ȫ����Ϊ˽������
    */
    /*test12(); */

    /* 3���̳��еĶ���ģ�ͣ����������зǾ�̬��Ա���Զ��ᱻ�̳и����ֻ࣬�Ǹ����е�˽�����Իᱻ���������أ�ʹ֮���ʲ�������ʵ�����Ǳ��̳��˵�
    *           ���䣺���ÿ�����Ա��ʾ���߲鿴����ģ�ͣ�������Ա������ʾ����������ת����ǰ�ļ�����·���£�Ȼ�������cl /d1 reportSingleClassLayout���� �ļ���
    *                                                                                                                  ���ɴ򼸸��ַ����� tab���Զ���ȫ����
    */     
   /* test13();*/

    /* 4���̳��еĹ��������˳���ȹ��츸�࣬�ٹ������ࣻ���������࣬�ٹ��츸�ࣨ����һ�������ͬʱ�����ȴ���һ�����ࣩ
    */
   /* test14();*/

    /* 5���̳�ͬ����Ա����ʽ��        �ٷ�������ͬ����Ա��ֱ�ӷ���          �ڷ��ʸ���ͬ����Ա�����������
    */ //����ֻ�ٹ����̳е�����
   /* Java j;     
    j.header();
    cout << j.a << endl;
    j.BasePage::header();
    cout << j.BasePage::a << endl;*/

    /* 6���̳�ͬ����̬��Ա����ʽ������ʽ��̳зǾ�̬����ʽһ�������ȿ�ͨ��������ʣ�Ҳ��ͨ����������
    *        �ر�ģ�ͨ��������������ʸ���ľ�̬��Ա������������::��������::��Ա�� 
    */

    /* 7����̳��﷨��C++�������̳У���class ���� ���̳з�ʽ ����1���̳з�ʽ ����2������
    * 
    *        ע�⣺��̳п���������������ͬ����Ա���֣�������������֣�ʵ�ʿ���ʱ�������ö�̳�
    */
   /* system("pause");
    return 0;
}*/
/* 8�����μ̳У��ֽ���ʯ�̳У�
    * 
    *               ��1���������������̳�ͬһ�����࣬����ĳ����ͬʱ�̳�����������
    * 
    *               ��2�����������⣺       �ٻ���ֶ�����         �ڼ̳������ݻ��࣬�ظ�����ݼ̳�����
    * 
    *               ��3��������̳п��Խ�����̳�֮ǰ���Ϲؼ��֡�virtual��ʹ֮��Ϊ��̳�
    */
//������
class Animal
{
public: 
    int age;
};

//Animal���Ϊ�����
//����
class Sheep : public virtual Animal
{
};
//����
class Tuo : public virtual Animal
{
};
//������
class SheepTuo : public Sheep, public Tuo
{
};
//void main()
//{
//    SheepTuo s;
//    //����������������֣�������ֻ��һ����������ˣ������˷��ڴ�
//    s.Sheep::age = 8;
//    s.Tuo::age = 10;
//    cout << s.Sheep::age << endl;
//    cout << s.Tuo::age << endl;
//    cout << s.age << endl;      //��̳к������������ˣ����ÿ�����Ա������ʾ����̳е�age����Ϊvbptr(�����ָ��)���京��Ϊ��v-vortual��b-base��ptr-pointer���������ָ��
//    system("pause");
//}