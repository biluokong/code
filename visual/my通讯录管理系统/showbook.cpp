#include "通讯录管理系统.h"

void showbook()
{
    for ( int i = 0; i < c.getLength(); i++ )
    {
        c.display(i);
    }
    c.display(0);
    system("pause");
    system("cls");
}