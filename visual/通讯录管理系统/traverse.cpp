#include"ͨѶ¼����ϵͳ.h"

void traverse(Addressbooks& abs)
{
	if (abs.size == 0)
	{
		cout << "��ǰ��¼Ϊ��" << endl;
	}
	else
	{
		for ( int i = 0; i < abs.size; i++)
		{
			cout << "������" << abs.personArray[i].name << '\t';
			cout << "�Ա�" << ((abs.personArray[i].sex == 1) ? "��" : "Ů") << '\t';
			cout << "���䣺" << abs.personArray[i].age << '\t';
			cout << "��ϵ�绰��" << abs.personArray[i].phone << "\t\t";
			cout << "��ַ��" << abs.personArray[i].addr << endl;
		}
	}
	system("pause");
	system("cls");
}