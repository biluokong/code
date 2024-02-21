#include<iostream>
#include<fstream>
#include<string>
using namespace std;

//文本文件以文本的ASCII码形式储存

//操作文件的三大类：     ①ofstream：写操作       ②ifstream：读操作       ③fstream：读写操作

/*  1、写文件
* 
*               （1）步骤：  ①包含头文件：#include<fstream>        ②创建流对象：ofstream ofs;        ③打开文件：ofs.open("文件路径"，打开方式)；
*                                    ④写数据：ofs<<"写入的数据"；        ⑤关闭文件：ofs.close();
* 
*               （2）打开方式：    ①ios::in    为读文件而打开文件       ②ios::out   为写文件而打开文件（会清除后覆盖）       ③ios::ate   初始位置：文件尾部
*                                             ④ios::app     追加方式写文件         ⑤ios::trunc     如果文件存在先删除，再创建           ⑥ios::binary    二进制方式
* 
*                                       注意：文件打开方式可配合使用，利用“|”操作符，如：ios::binary | ios::out
*/
//写文件
void test01()
{
    ofstream ofs;
    //若文件不存在，会创建文件在当前cpp文件同目录下
    ofs.open("test.txt", ios::out);
    ofs << "姓名：张三" << endl;
    ofs << "性别：男" << endl;
    ofs.close();
}

void test02()
{
    ifstream ifs;
    ifs.open("test.txt", ios::in);
    if ( !ifs.is_open() )
    {
        cout << "文件打开失败" << endl;
        return;
    }
    //读数据
    //第一种：用字符数组，一个字符一个字符的读
    /*char buf1[1024] = { 0 };
    while ( ifs >> buf1 )
    {
        cout << buf1 << endl;
    }*/

    //第二种方式：一行字符一行字符的读
    /*char buf2[1024] = { 0 };
    while ( ifs.getline(buf2, sizeof(buf2)) )
    {
        cout << buf2 << endl;
    }*/

    //第三种方式：用全局函数getling()
    /*string buf;
    while ( getline(ifs, buf))
    {
        cout << buf << endl;
    }*/

    //第四种方式：用字符变量，一个一个字符的读, 此方式会把回车符读入，不用加也不能加endl
    char c;
    while ( (c = ifs.get()) != EOF )
    {
        cout << c;
    }

    ifs.close();
}

//void main()
//{
//   /* test01();*/
//
//    /* 2、读文件
//    *           （1）步骤：  ①包含头文件：#include<fstream>        ②创建流对象：ifstream ifs;        ③打开文件并判断文件是否打开成功：ifs.open("文件路径"，打开方式)；
//    *                                判断ifs.isope()的真假               ④读数据：四种方式读取             ⑤关闭文件：ifs.close();
//    */
//    test02();
//    system("pause");
//}
