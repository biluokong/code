#include <iostream>
using namespace std;
#include <string.h>

void test11()       //测试构造函数
{
    const char* s = "hello world";
    string str1(s);
    string str2(5, 'c');
    string str3(str1);
    cout << str1 << endl;
    cout << str2 << endl;
    cout << str3 << endl;
}

void test12()       //测试赋值函数
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

void test13()       //测试字符串拼接
{
    string str1 = "我";
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

void test14()       //测试查找和替换
{
    string str1 = "abceeff";
    int a = str1.find("aa");
    cout << str1.find("ee") << endl;
    cout << str1.find("aa") << "\t" << a << endl;
    cout << str1.rfind("ef") << endl;       //从右往左找
    cout << (int)str1.rfind("cc") << endl;       //从右往左找

    str1.replace(1, 3, "111");
    cout << str1 << endl;
    str1.replace(1, 3, "11111111");
    cout << str1 << endl;
}

//void main()
//{
    /* 1、string容器
                （1）基本概念：
                                ①本质：是C++风格的字符串，本质上是一个类
                                ②与char* 的区别：char*是一个指针，string是一个类，类内部封装了char* ，管理这个字符串，是一个char*型的容器。
                                ③特点：其类内部封装了很多成员方法（例如查找find、拷贝copy、删除erase、替换replace、插入insert）
                                             string管理char*所分配的内存，不用担心复制越界和取值越界等，由类内部进行负责

                （2）构造函数：
                                ①string();                                      //创建一个空的字符串
                                ②string(const char* s);                 //使用字符串常量s初始化
                                ③string(const string& str);          //使用一个string对象初始化另一个string对象
                                ④string(int n, char c);                  //使用n个字符c初始化

                （3）赋值操作：(函数原型)
                                string& operator=(const char* s);                                  //char*类型字符串(字符串常量)，赋值给当前的字符串
                                string& operator=(const string& s);                              //把字符串s赋值给当前的字符串
                                string& operator=(char c);                                             //字符赋值给当前的字符串
                                string& assign(const char* s);                                        //把字符串s赋给当前的字符串
                                string& assign(const char* s, int n);                               //把字符串s的前你n个字符赋给当前字符串
                                string& assign(const string& s);                                    //把字符串s赋给当前字符串
                                string& assign(int n, char c);                                          //用n个字符c赋给当前字符串

                （4）字符串拼接
                                string& operator+=(const char* str);                                                    //重载+=操作符
                                string& operator+=(const char c);                                                        //重载+=操作符
                                string& operator+=(const string& str);                                                //重载+=操作符
                                string& append=(const char* s);                                                           //把字符串s连接到当前字符串结尾
                                string& append+=(const char* s, int n);                                               //把字符串s的前n个字符连接到当前字符串结尾
                                string& append+=(const string& s);                                                    //同operator+=(const string& str)
                                string& append+=(const string& s, int pos, int n);                              //字符串s中从pos开始的n个字符连接到字符串结尾

                （5）查找和替换
                                int find(const string& str, int pos = 0) const;                                     //查找str第一次出现位置，从pos开始查找
                                int find(const char* s, int pos = 0) const;                                           //查找s第一次出现位置，从pos开始查找
                                int find(const char* s, int pos, int n) const;                                        //从pos位置查找s的前n个字符第一次出现位置
                                int find(const char c, int pos = 0) const;                                            //查找字符c第一次出现位置
                                int rfind(const string& str, int pos = npos) const;                             //查找str最后一次出现位置，从pos开始查找
                                int rfind(const char* s, int pos = npos) const;                                   //查找s最后一次出现位置，从pos开始查找
                                int rfind(const char* s, int pos, int n) const;                                      //从pos开始查找s的前n个字符最后一次位置
                                int rfind(const char c, int pos = 0) const;                                          //查找字符c最后一次出现位置
                                string& replace(int pos, int n, const string& str) const;                   //替换原字符串从pos开始的n个字符为字符串str
                                string& replace(int pos, int n, const char* s);                                   //替换原字符串从pos开始的n个字符为字符串s

                （6）字符串比较    (= 返回0      >返回1        <返回-1)
                                int compare(const string& s) const;                                                 //与字符串s比较
                                int compare(const char* s) const;                                                     //与字符串s比较

                （7）字符串存取    (两种方式读和写都行)
                                char& operator[](int n);                                                                   //通过[]方式取字符
                                char& at(int n);                                                                                //通过at方法获取字符

                （8）插入和删除
                                string& insert(int pos, const char* s);                                              //插入字符串
                                string& insert(int pos, const string& str);                                        //插入字符
                                string& insert(int pos, int n, char c);                                                //在指定位置插入n个字符
                                string& erase(int pos = 0, int n = npos);                                         //删除从pos开始的n个字符

                （9）获取字符
                                string& substr(int pos = 0, int n = npos) const;                            //返回由pos开始的n个字符组成的字符串
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