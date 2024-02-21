#include<iostream>
using namespace std;

/*
* 1、代码区：存放函数体的二进制代码，由操作系统进行管理
*     （1）存放CPU执行的机器指令
*	   （2）代码区是共享的，在内存中只需一份代码，以便节省内存
*	   （3）代码区是只读的，以防止程序被意外修改指令
* 
* 2、全局区：存放全局变量和静态变量以及常量
*	   （1）全局区包含了常量区，字符串常量 （由双引号引起来的字符串）和其它常量存放于此（如const修饰的常量，但除局部常量外）
*	   （2）内存在程序结束时由操作释放
* 
* 前两个是程序运行前的，后两个是程序运行后的
* 
* 3、栈区：内存由编译器自动分配和释放，存放函数的参数值和局部变量等
*	   （1）不能返回局部变量的地址(值可以，因为会被接收的只是字面值)，因为其内存已被编译器回收
* 
* 4、堆区：内存由程序员分配和释放，若程序员没释放，程序结束时由操作系统回收
*	   （1）C++中主要用new来开辟堆内存
*/

//2、全局区的测试：
//int g_a = 10;
//int g_b = 10;
//static int s_g_a = 10;
//const int c_g_a = 10;
//const static int c_s_g_a = 10;
//void main ()
//{
//	int a = 10;
//	int b = 10;
//	static int s_b = 10;
//	const int c_a = 10;
//	const static int c_s_a = 10;
//	cout << "局部变量a的地址为：" << (int)&a << endl;
//	cout << "局部变量b的地址为：" << (int)&b << endl;
//	cout << "全部变量g_a的地址为：" << (int)&g_a << endl;
//	cout << "全部变量g_b的地址为：" << (int)&g_b << endl;
//	cout << "静态全局变量s_g_a的地址为：" << (int)&s_g_a << endl;
//	cout << "静态局部变量s_b的地址为：" << (int)&s_b << endl;
//	cout << "字符串常量“abc”的地址为：" << (int)&"abc" << endl;
//	cout << "const修饰局部变量（局部常量）c_a的地址为：" << (int)&c_a << endl;
//	cout << "const修饰的全局变量（全局常量）c_g_a的地址为：" << (int)&c_g_a << endl;
//	cout << "const修饰的静态变量（静态局部常量）c_s_a的地址为：" << (int)&c_s_a << endl;
//	cout << "const修饰的静态全局变量（静态全局常量）c_s_a的地址为：" << (int)&c_s_a << endl;
//	system ("pause");
//}

//栈和堆区的测试
int* func ()
{
	int a = 10;
	return &a;
}

int fun ()
{
	int a = 10;
	cout << (int)&a << endl;
	return a;
}

int* fun1 ()
{
	int* p1 = new int(10);
	cout << (int)p1 << endl;
	return p1;
}
//void main() 
//{
//	int* p = func ();
//	cout << *p << endl;//这里能输出正确结果，是因为vc的编译器做了保留，但这种保留编译器只做一次
//	cout << *p << endl;//所有第二次输出了乱码
//	cout << "=======================" << endl;
//	int a = fun ();
//	cout << (int) &a << endl;
//	cout << a << endl;
//	cout << a << endl;
//	cout << "========================" << endl;
//	int* p1 = fun1();
//	cout << (int) p1 << endl;
//	cout << *p1 << endl;
//	cout << *p1 << endl;
//	delete(p1);
//	//cout << *p1 << endl;  编译器报错，出现异常。因为该内存已被释放
//	cout << (int)p1 << endl;
//	system ("pause");
//	system ("cls");
//}