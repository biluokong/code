#include"ͨѶ¼����ϵͳ.h"

void callMenu(Addressbooks& abs)
{
	int select = 0;
	while (true)
	{
		showMenu();
		cout << "��ѡ��������Ĳ�����" << endl;
		cin >> select;
		switch (select)
			{
			case 1:
				add(abs);
				break;
			case 2:
				traverse(abs);
				break;
			case 3:
				delet (abs);
				break;
			case 4:
				locate (abs);
				break;
			case 5:
				modify (abs);
				break;
			case 6:
				clear (abs);
				break;
			case 0:
				cout << "��ӭ�´�ʹ��" << endl;
				system("pause");
				return;
				break;
			default:
				cout << "�Ƿ������룡" << endl;
				system("pause");
				system("cls");
			}
	}
	
}
