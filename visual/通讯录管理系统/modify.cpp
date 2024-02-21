#include"通讯录管理系统.h"

void modify (Addressbooks& abs)
{
	int n = locate (abs);
	cout << "请修改" << endl;

	string name;
	cout << "请输入姓名：" << endl;
	cin >> name;
	abs.personArray[n].name = name;

	int sex;
	while ( true )
	{
		cout << "请输入性别：\n1-----男\n2-----女" << endl;
		cin >> sex;
		if ( sex == 1 || sex == 2 )
		{
			abs.personArray[n].sex = sex;
			break;
		}
		else
		{
			cout << "非法的输入！" << endl;
		}
	}


	int age;
	cout << "请输入年龄：" << endl;
	cin >> age;
	abs.personArray[n].age = age;

	string phone;
	cout << "请输入手机号码：" << endl;
	cin >> phone;
	abs.personArray[n].phone = phone;

	string addr;
	cout << "请输入地址：" << endl;
	cin >> addr;
	abs.personArray[n].addr = addr;
	
	system ("pause");
	system ("cls");
}