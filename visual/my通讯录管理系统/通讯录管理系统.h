#pragma once
#include <iostream>
using namespace std;
#include <string>
#define  MAX 100

void showMenu();
struct Contact
{
	string name;
	bool sex;
	int age;
	string phone;
	string addr;
};
class ContactBook
{
public:
	ContactBook();		//构造方法
	void add(string name, bool sex, int age, string phone, string addr);		//添加联系人
	void display(int i);		//显示下标为i的联系人的信息
	void set(int i, string name, bool sex, int age, string phone, string addr);		//修改联系人的信息
	int getLength();
private:
	Contact book[MAX];
	int length;
};

static ContactBook c;

void add();
void showbook();