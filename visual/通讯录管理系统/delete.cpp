#include"ͨѶ¼����ϵͳ.h"

void delet(Addressbooks& abs)
{
	int n = locate (abs);
	cout << "�Ƿ�ɾ������ϵ�ˣ�\n1-----��\n2-----��" << endl;
	int flag;
	cin >> flag;
	if ( flag == 1 )
	{
		for ( int i = n; i < abs.size - 1; i++ )
		{
			abs.personArray[i] = abs.personArray[i + 1];
			abs.size--;
			cout << "��ɾ��" << endl;
		}
	}
	else if ( flag == 2 );
	else
	{
		cout << "�Ƿ�������" << endl;
	}
	system ("pause");
	system ("cls");
}