#include <iostream>
using namespace std;
#include <string.h>

void test11()       //���Թ��캯��
{
    const char* s = "hello world";
    string str1(s);
    string str2(5, 'c');
    string str3(str1);
    cout << str1 << endl;
    cout << str2 << endl;
    cout << str3 << endl;
}

void test12()       //���Ը�ֵ����
{
    string str1;
    str1 = 'c';
    string str2;
    cout << str1 << endl;
    str2.assign("hello");
    cout << str2 << endl;
    str2.assign("hello", 2);
    cout << str2 << endl;
    str2.assign(str1);
    cout << str2 << endl;
    str2.assign(4, 'd');
    cout << str2 << endl;
}

void test13()       //�����ַ���ƴ��
{
    string str1 = "��";
    str1 += "love you";
    cout << str1 << endl;
    str1 += str1;
    cout << str1 << endl;
    str1.append(str1);
    cout << str1 << endl;
    str1.append(str1, 2);
    cout << str1 << endl;
    str1.append(str1, 3, 6);
    cout << str1 << endl;
}

void test14()       //���Բ��Һ��滻
{
    string str1 = "abceeff";
    int a = str1.find("aa");
    cout << str1.find("ee") << endl;
    cout << str1.find("aa") << "\t" << a << endl;
    cout << str1.rfind("ef") << endl;       //����������
    cout << (int)str1.rfind("cc") << endl;       //����������

    str1.replace(1, 3, "111");
    cout << str1 << endl;
    str1.replace(1, 3, "11111111");
    cout << str1 << endl;
}

//void main()
//{
    /* 1��string����
                ��1���������
                                �ٱ��ʣ���C++�����ַ�������������һ����
                                ����char* ������char*��һ��ָ�룬string��һ���࣬���ڲ���װ��char* ����������ַ�������һ��char*�͵�������
                                ���ص㣺�����ڲ���װ�˺ܶ��Ա�������������find������copy��ɾ��erase���滻replace������insert��
                                             string����char*��������ڴ棬���õ��ĸ���Խ���ȡֵԽ��ȣ������ڲ����и���

                ��2�����캯����
                                ��string();                                      //����һ���յ��ַ���
                                ��string(const char* s);                 //ʹ���ַ�������s��ʼ��
                                ��string(const string& str);          //ʹ��һ��string�����ʼ����һ��string����
                                ��string(int n, char c);                  //ʹ��n���ַ�c��ʼ��

                ��3����ֵ������(����ԭ��)
                                string& operator=(const char* s);                                  //char*�����ַ���(�ַ�������)����ֵ����ǰ���ַ���
                                string& operator=(const string& s);                              //���ַ���s��ֵ����ǰ���ַ���
                                string& operator=(char c);                                             //�ַ���ֵ����ǰ���ַ���
                                string& assign(const char* s);                                        //���ַ���s������ǰ���ַ���
                                string& assign(const char* s, int n);                               //���ַ���s��ǰ��n���ַ�������ǰ�ַ���
                                string& assign(const string& s);                                    //���ַ���s������ǰ�ַ���
                                string& assign(int n, char c);                                          //��n���ַ�c������ǰ�ַ���

                ��4���ַ���ƴ��
                                string& operator+=(const char* str);                                                    //����+=������
                                string& operator+=(const char c);                                                        //����+=������
                                string& operator+=(const string& str);                                                //����+=������
                                string& append=(const char* s);                                                           //���ַ���s���ӵ���ǰ�ַ�����β
                                string& append+=(const char* s, int n);                                               //���ַ���s��ǰn���ַ����ӵ���ǰ�ַ�����β
                                string& append+=(const string& s);                                                    //ͬoperator+=(const string& str)
                                string& append+=(const string& s, int pos, int n);                              //�ַ���s�д�pos��ʼ��n���ַ����ӵ��ַ�����β

                ��5�����Һ��滻
                                int find(const string& str, int pos = 0) const;                                     //����str��һ�γ���λ�ã���pos��ʼ����
                                int find(const char* s, int pos = 0) const;                                           //����s��һ�γ���λ�ã���pos��ʼ����
                                int find(const char* s, int pos, int n) const;                                        //��posλ�ò���s��ǰn���ַ���һ�γ���λ��
                                int find(const char c, int pos = 0) const;                                            //�����ַ�c��һ�γ���λ��
                                int rfind(const string& str, int pos = npos) const;                             //����str���һ�γ���λ�ã���pos��ʼ����
                                int rfind(const char* s, int pos = npos) const;                                   //����s���һ�γ���λ�ã���pos��ʼ����
                                int rfind(const char* s, int pos, int n) const;                                      //��pos��ʼ����s��ǰn���ַ����һ��λ��
                                int rfind(const char c, int pos = 0) const;                                          //�����ַ�c���һ�γ���λ��
                                string& replace(int pos, int n, const string& str) const;                   //�滻ԭ�ַ�����pos��ʼ��n���ַ�Ϊ�ַ���str
                                string& replace(int pos, int n, const char* s);                                   //�滻ԭ�ַ�����pos��ʼ��n���ַ�Ϊ�ַ���s

                ��6���ַ����Ƚ�    (= ����0      >����1        <����-1)
                                int compare(const string& s) const;                                                 //���ַ���s�Ƚ�
                                int compare(const char* s) const;                                                     //���ַ���s�Ƚ�

                ��7���ַ�����ȡ    (���ַ�ʽ����д����)
                                char& operator[](int n);                                                                   //ͨ��[]��ʽȡ�ַ�
                                char& at(int n);                                                                                //ͨ��at������ȡ�ַ�

                ��8�������ɾ��
                                string& insert(int pos, const char* s);                                              //�����ַ���
                                string& insert(int pos, const string& str);                                        //�����ַ�
                                string& insert(int pos, int n, char c);                                                //��ָ��λ�ò���n���ַ�
                                string& erase(int pos = 0, int n = npos);                                         //ɾ����pos��ʼ��n���ַ�

                ��9����ȡ�ַ�
                                string& substr(int pos = 0, int n = npos) const;                            //������pos��ʼ��n���ַ���ɵ��ַ���
    */
   /* test11();*/
    /*test12();*/
    /*test13();*/
    /*test14();*/
    /*string str = "hello world";
    cout << str[3] << endl;
    str.erase(3);
    cout << str << endl;
    str.erase();
    cout << str.size() << endl;
    str = "zhangsang@qq.com";
    cout <<str.substr(0, str.find('@')) << endl;
    system("pause");
}*/