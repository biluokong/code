#include"ͨѶ¼����ϵͳ.h"

void modify (Addressbooks& abs)
{
	int n = locate (abs);
	cout << "���޸�" << endl;

	string name;
	cout << "������������" << endl;
	cin >> name;
	abs.personArray[n].name = name;

	int sex;
	while ( true )
	{
		cout << "�������Ա�\n1-----��\n2-----Ů" << endl;
		cin >> sex;
		if ( sex == 1 || sex == 2 )
		{
			abs.personArray[n].sex = sex;
			break;
		}
		else
		{
			cout << "�Ƿ������룡" << endl;
		}
	}


	int age;
	cout << "���������䣺" << endl;
	cin >> age;
	abs.personArray[n].age = age;

	string phone;
	cout << "�������ֻ����룺" << endl;
	cin >> phone;
	abs.personArray[n].phone = phone;

	string addr;
	cout << "�������ַ��" << endl;
	cin >> addr;
	abs.personArray[n].addr = addr;
	
	system ("pause");
	system ("cls");
}