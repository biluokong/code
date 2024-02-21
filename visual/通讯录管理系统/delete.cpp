#include"通讯录管理系统.h"

void delet(Addressbooks& abs)
{
	int n = locate (abs);
	cout << "是否删除此联系人：\n1-----是\n2-----否" << endl;
	int flag;
	cin >> flag;
	if ( flag == 1 )
	{
		for ( int i = n; i < abs.size - 1; i++ )
		{
			abs.personArray[i] = abs.personArray[i + 1];
			abs.size--;
			cout << "已删除" << endl;
		}
	}
	else if ( flag == 2 );
	else
	{
		cout << "非法的输入" << endl;
	}
	system ("pause");
	system ("cls");
}