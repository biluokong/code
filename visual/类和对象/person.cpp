#include"person.h"

/*
* ������::��ʾ���������������
*/
    void Person:: setName(string name)
    {
        this->name = name;
    }

    string Person:: getName()
    {
        return name;
    }

    void Person:: setSex(bool sex)
    {
        this->sex = sex;
    }

    bool Person:: getSex()
    {
        return sex;
    }

    void Person:: display()
    {
        cout << "������" << name << "\t�Ա�" << (sex ? "��" : "Ů") << endl;
    }