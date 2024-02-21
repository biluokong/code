#include<iostream>
#include<string>
#include"person.h"
using namespace std;
/*
* 1、意义：
*		（1）能将属性和行为作为一个整体，表现生活中的事物
*		（2）能将属性和行为加以权限控制
* 
* 2、访问权限有三种：
		（1）public(公共权限)：类内类外以及子类都可以访问
		（2）protected(保护权限)：类内可以访问，类外不可以访问，子类可以访问
		（3）private(私有权限)：类内可以访问，类外不可以访问，子类不可以访问

 3、C++中struct和class的区别：struct默认权限为public，class默认权限为private，其它地方基本没有区别（只指在c++中） 

 4、分文件编写程序：头文件中放类名和类体中所有属性和函数的声明，.cpp文件中放函数具体的实现，但函数名前要加 "类名::"  ( "类名" 加 "::" 表示是这个的作用域下)
*/

class Student
{
public :  //公共权限
	//属性
	string m_Name;    //姓名
	string m_Id;	//学号

	//行为
	//给学生对象的所有成员属性赋值
	void setStudent(string name, string id)
	{
		m_Name = name;
		m_Id = id;
	}
	//给学生姓名属性赋值
	void setName(string name)
	{
		m_Name = name;
	}
	//给学生学号属性赋值
	void setId(string id)
	{
		m_Id = id;
	}
	//打印学生信息
	void display()
	{
		cout << "姓名：" << m_Name << "\t学号：" << m_Id << endl;
	}

};

//void main()
//{
//	Student student;
//	student.setStudent("张三", "12341");
//	student.display();
//	Person p;
//	p.setName("张三");
//	p.setSex(true);
//	p.display();
//	system("pause");
//}