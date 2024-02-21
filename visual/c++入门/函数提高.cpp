#include<iostream>
using namespace std;
/*
* 1、函数默认参数
*		（1）语法：返回值类型   函数名   (参数 = 默认值) { }
*					如果传入了参数，就用传入的参数，否则用默认值
*		（2）注意事项：
*					a、如果某个位置已有默认参数，则之后的参数都要有默认值，否则编译器报错，提示：默认实参不在形参列表的末尾
*					b、函数声明和函数实现只能一个有默认参数，否则运行时出错，提示：重定义默认参数
* 
* 2、函数占位参数
*		（1）语法：返回值类型   函数名   (数据类型) { }
*				  意义不大，但可能用到。在只写一个(或多个)数据类型时，传参时必须需要还要再传入这个数据类型的一个(或多个)参数，即占位参数必须填补
*			      占位参数也可以有默认值，不过没什么意义（因为在函数体内用不了）：int func(int a, int  = 10) { } 
* 
* 3、函数重载
*		（1）作用：函数名可以相同，提高复用性
*		（2）满足条件：
*					a、同一个作用域下
					b、函数名称相同
					c、函数参数类型不同 或者 参数个数不同 或者 参数顺序不同
		（3）注意：
					a、函数的返回值不能作为函数重载的条件
					b、引用作为重载条件时：int fun(int& a) { } 和 int fun(const int& a) { } 可以构成重载（类型不同）
							fun(a)   是调用第一个，因为传入的是变量，编译器优先选择可读可写的
							fun(10)   是调用第二个，因为第一个编译无法通过，会报错，只有第二个才能通过
					c、函数碰到默认参数时， 可能 出现二义性，如：int fun(int a, int b = 10) 和 int fun(int a)  
							当传入5时，两个函数都能调用，编译器不知道用哪个，报错，建议尽量二者不要同时使用
*/

//函数默认参数
//int funa(int a, int b = 10, int c, int d = 10)   //报错
//{
//	return a + b + c;
//}

/*nt funb(int a = 10, int b =4);

int funb(int a, int b =56)
{
	return a + b;
}*/;

//函数占位参数
int func(int a, int)
{
	return a;
}

//引用作为重载条件
int fund(int& a)
{
	return 2;
}

int fund(const int& a)
{
	return 12;
}

//函数重载碰到默认参数
//int fune(int a, int b = 10)    报错，二义性
//{
//	return 1122;
//}

int fune(int a)
{
	return 23423;
}

int fune(int a, int b, int c = 20)
{
	return 99;
}

void main()
{
	/*cout << funa(14) << endl;
	cout << funa(25, 25) << endl;*/
	//cout << funa() << endl;   编译器报错
	//cout << funb() << endl;
	//cout << func(3) << endl;   报错，要补全参数
	/*int a = 3;
	cout << fund(a) << endl;
	cout << fund(2) << endl;
	system("pause");*/
	//cout << fune(34) << endl;   编译器报错，有二义性
	cout << fune(2) << endl;
	cout << fune(4, 5) << endl;
}