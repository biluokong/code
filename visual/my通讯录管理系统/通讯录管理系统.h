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
	ContactBook();		//���췽��
	void add(string name, bool sex, int age, string phone, string addr);		//�����ϵ��
	void display(int i);		//��ʾ�±�Ϊi����ϵ�˵���Ϣ
	void set(int i, string name, bool sex, int age, string phone, string addr);		//�޸���ϵ�˵���Ϣ
	int getLength();
private:
	Contact book[MAX];
	int length;
};

static ContactBook c;

void add();
void showbook();