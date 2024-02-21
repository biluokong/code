#include"person.h"

/*
* 类名加::表示是这个的作用域下
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
        cout << "姓名：" << name << "\t性别：" << (sex ? "男" : "女") << endl;
    }