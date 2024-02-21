#include"通讯录管理系统.h"

void callMenu(Addressbooks& abs)
{
	int select = 0;
	while (true)
	{
		showMenu();
		cout << "请选择接下来的操作：" << endl;
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
				cout << "欢迎下次使用" << endl;
				system("pause");
				return;
				break;
			default:
				cout << "非法的输入！" << endl;
				system("pause");
				system("cls");
			}
	}
	
}
