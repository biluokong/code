  #include<iostream>
using namespace std;
/*
* 1、引用基本语法：
*			数据类型& 别名 = 原名
*			如：int& b = a;
*		    实际a和b指向同一块内存空间，相当为a的内存空间取个别名b，有点类似指针，但比指针更安全
*			在C++内部其本质是一个指针常量
* 
* 2、注意事项：
*		（1）引用必须初始化
*		（2）引用在初始化后，不可以修改
*		（3）引用做函数的返回值时：
*					a、不要返回局部变量的引用  (因为和指针一样)
*					b、函数调用可以作为左值  （类似函数名就是返回变量的一个别名）
*		（4）常量引用：
*					使用场景：修饰形参，将其变为只读，防止误操作
*					int& ret = 10;   编译器报错非常量引用的初始值必须为合法的内存空间
*					const int& ret = 10;   编译器不报错，编译器会自动将代码变成：int temp = 10;  const int& ret = temp;
*/
//int& fun()
//{
//	int a = 10;
//	return a;
//}
//
//int& func()
//{
//	static int a = 10;
//	return a;
//}
//
//int* const funs()
//{
//	static int a = 123;
//	return &a;
//}
//
//void main() 
//{
//	int a = 10;
//	int c = 3;
//	int& b = a;
//	cout << b << endl;
//	//int& c;  编译器报错
////	b = &c;  //编译器报错，不能修改引用的指向
//	b = c;  //这个实际是赋值操作
//	cout << b << endl;
//	cout << "==================" << endl;
//	int* p = &a;
//	cout << (int)&a << endl;
//	cout << (int)&b << endl;
//	cout << *p << endl;
//	cout << (int)p << endl;
//	cout << (int)&p << endl;
//	cout << "=============" << endl;
//	int& d = fun();
//	cout << d << endl;//第一次输出正常，因为编译器做了一次保存
//	cout << d << endl;//第二次则是乱码
//	cout << "===============" << endl;
//	int& e = func();
//	cout << e << endl;
//	func() = 100;
//	cout << e << endl;
//	cout << func() << endl;
//	cout << "=================" << endl;
//	int* const f = funs();
//	cout << *f << endl;
//	//funs() = 124232;  编译器报错，引用并不完全等同于指针常量
//	cout << *f << endl;
//	const int& ret = 10;
//	//int& re = 10;   编译器报错非常量引用的初始值必须为可引用类型
//	system("pause");
//}