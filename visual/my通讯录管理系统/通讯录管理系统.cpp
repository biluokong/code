#include <iostream>
using namespace std;
#include "通讯录管理系统.h"

int main()
{
    int select = 0;
    while ( true )
    {
        showMenu();
        cin >> select;
        switch ( select )
        {
            case 1 :
                add();
                break;
            case 2 :
                showbook();
                break;
            case 3 :
                break;
            case 4 :
                break;
            case 5 :
                break;
            case 6 :
                break;
            case 7 :
                cout << "欢迎下次使用" << endl;
                system("pause");
                return 0;
                break;
            default:
                system("cls");
                break;
        }
    }
    system("pause");
}
