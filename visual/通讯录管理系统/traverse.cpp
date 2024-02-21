#include"通讯录管理系统.h"

void traverse(Addressbooks& abs)
{
	if (abs.size == 0)
	{
		cout << "当前记录为空" << endl;
	}
	else
	{
		for ( int i = 0; i < abs.size; i++)
		{
			cout << "姓名：" << abs.personArray[i].name << '\t';
			cout << "性别：" << ((abs.personArray[i].sex == 1) ? "男" : "女") << '\t';
			cout << "年龄：" << abs.personArray[i].age << '\t';
			cout << "联系电话：" << abs.personArray[i].phone << "\t\t";
			cout << "地址：" << abs.personArray[i].addr << endl;
		}
	}
	system("pause");
	system("cls");
}