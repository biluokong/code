#include<iostream>
#include<string.h>
#define MAX 100
using namespace std;

struct Person
{
	string name;
	int sex;
	int age;
	string phone;
	string addr;
};
struct Addressbooks
{
	Person personArray[MAX];
	int size;
};

void showMenu();
void callMenu(Addressbooks& abs);
void add(Addressbooks& abs);
void traverse(Addressbooks& abs);
void delet (Addressbooks& abs);
int locate (Addressbooks& abs);
void modify (Addressbooks& abs);
void clear (Addressbooks& abs);