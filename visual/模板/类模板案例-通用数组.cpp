#include <iostream>
#include <string>
using namespace std;
#include "myarray.hpp"

class Car
{
public:
    Car() {}
    Car(string name, int age)
    {
        this->m_Name = name;
        this->m_age = age;
    }
    string m_Name;
    int m_age;
};

template<class T>
void printArr(MyArray<T> arr)
{
    cout << "数据：" << endl;
    for ( int i = 0; i < arr.getSize(); i++ )
    {    
        cout << arr[i];
    }
    cout << "容量:" << arr.getCapacity() << endl;
    cout << "长度:" << arr.getSize() << endl;
}

void test11()
{
    MyArray<int> arr1(5);
    for ( int i = 0; i < 5; i++ )
    {
        arr1.Push_Back(i);
    }
    printArr(arr1);
    arr1.Pop_Back();
    arr1.Pop_Back();
    printArr(arr1);
    /*MyArray<int> arr2(arr1);
    MyArray<int> arr3(100);
    arr3 = arr1;*/
}

void test12()
{
    MyArray<Car> arr(10);
    Car c("大众", 2);
    Car c1("奥迪", 3);
    arr.Push_Back(c);
    arr.Push_Back(c1);
    for ( int i = 0; i < arr.getSize(); i++ )
    {
        cout << arr[i].m_Name << arr[i].m_age << endl;
   }
}

void main()
{
    /*test11();*/
    test12();
    system("pause");
}