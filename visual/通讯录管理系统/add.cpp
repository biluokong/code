#include"通讯录管理系统.h"

void add(Addressbooks& abs)
{
	if (abs.size == MAX)
	{
		cout << "无法添加新的联系人，通讯录已满！" << endl;
		return;
	}

	string name;
	cout << "请输入姓名：" << endl;
	cin >> name;
	abs.personArray[abs.size].name = name;

	int sex;
	while (true)
	{
		cout << "请输入性别：\n1-----男\n2-----女" << endl;
		cin >> sex;
		if (sex == 1 || sex == 2)
		{
			abs.personArray[abs.size].sex = sex;
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
	abs.personArray[abs.size].age = age;
	
	string phone;
	cout << "请输入手机号码：" << endl;
	cin >> phone;
	abs.personArray[abs.size].phone = phone;
	
	string addr;
	cout << "请输入地址：" << endl;
	cin >> addr;
	abs.personArray[abs.size].addr = addr;

	abs.size++;
	cout << "添加成功！" << endl;
	system("pause");    //请按任意键继续
	system("cls");    //清屏
}