#include"ͨѶ¼����ϵͳ.h"

int locate (Addressbooks& abs)
{
	string name;
	cout << "��������Ҫִ�в������˵�������" << endl;
	cin >> name;
	for ( int i = 0; i < abs.size; i++ )
	{
		if ( abs.personArray[i].name == name )
		{
			cout << "���ҵ�" << endl;
			cout << "������" << abs.personArray[i].name << '\t';
			cout << "�Ա�" << ((abs.personArray[i].sex == 1) ? "��" : "Ů") << '\t';
			cout << "���䣺" << abs.personArray[i].age << '\t';
			cout << "��ϵ�绰��" << abs.personArray[i].phone << "\t\t";
			cout << "��ַ��" << abs.personArray[i].addr << endl;
			system ("pause");
			system ("cls");
			return i;
		}
	}
	cout << "����ϵ�˲�����" << endl;
	system ("pause");
	system ("cls");
	return -1;
}