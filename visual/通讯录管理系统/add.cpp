#include"ͨѶ¼����ϵͳ.h"

void add(Addressbooks& abs)
{
	if (abs.size == MAX)
	{
		cout << "�޷�����µ���ϵ�ˣ�ͨѶ¼������" << endl;
		return;
	}

	string name;
	cout << "������������" << endl;
	cin >> name;
	abs.personArray[abs.size].name = name;

	int sex;
	while (true)
	{
		cout << "�������Ա�\n1-----��\n2-----Ů" << endl;
		cin >> sex;
		if (sex == 1 || sex == 2)
		{
			abs.personArray[abs.size].sex = sex;
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
	abs.personArray[abs.size].age = age;
	
	string phone;
	cout << "�������ֻ����룺" << endl;
	cin >> phone;
	abs.personArray[abs.size].phone = phone;
	
	string addr;
	cout << "�������ַ��" << endl;
	cin >> addr;
	abs.personArray[abs.size].addr = addr;

	abs.size++;
	cout << "��ӳɹ���" << endl;
	system("pause");    //�밴���������
	system("cls");    //����
}