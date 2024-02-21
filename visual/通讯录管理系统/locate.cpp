#include"通讯录管理系统.h"

int locate (Addressbooks& abs)
{
	string name;
	cout << "请输入你要执行操作的人的姓名：" << endl;
	cin >> name;
	for ( int i = 0; i < abs.size; i++ )
	{
		if ( abs.personArray[i].name == name )
		{
			cout << "已找到" << endl;
			cout << "姓名：" << abs.personArray[i].name << '\t';
			cout << "性别：" << ((abs.personArray[i].sex == 1) ? "男" : "女") << '\t';
			cout << "年龄：" << abs.personArray[i].age << '\t';
			cout << "联系电话：" << abs.personArray[i].phone << "\t\t";
			cout << "地址：" << abs.personArray[i].addr << endl;
			system ("pause");
			system ("cls");
			return i;
		}
	}
	cout << "该联系人不存在" << endl;
	system ("pause");
	system ("cls");
	return -1;
}