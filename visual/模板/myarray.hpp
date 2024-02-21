#pragma once
#include <iostream>
using namespace std;

template<class T>
class MyArray
{
public:
    //有参构造
    MyArray(int capacity)
    {
        cout << "有参构造" << endl;
        this->m_Capacity = capacity;
        this->m_Size = 0;
        this->pAddress = new T[this->m_Capacity];
    }

    //拷贝函数
    MyArray(const MyArray& arr)
    {
        cout << "拷贝构造" << endl;
        this->m_Capacity = arr.m_Capacity;
        this->m_Size = arr.m_Size;
        //深拷贝
        this->pAddress = new T[arr.m_Capacity];
        for ( int i = 0; i < this->m_Size; i++ )
        {
            this->pAddress[i] = arr.pAddress[i];
        }
    }

    //防止浅拷贝问题
    MyArray& operator=(const MyArray& arr)
    {
        cout << "=运算符" << endl;
        //判断用来堆区是否有数据，如果有先释放
        if ( this->pAddress != NULL )
        {
            delete[] this->pAddress;
            this->pAddress = NULL;
            this->m_Capacity = 0;
            this->m_Size = 0;
        }
        //深拷贝
        this->m_Capacity = arr.m_Capacity;
        this->m_Size = arr.m_Size;
        this->pAddress = new T[arr.m_Capacity];
        for ( int i = 0; i < this->m_Size; i++ )
        {
            this->pAddress[i] = arr.pAddress[i];
        }
        return *this;
    }

    //尾插法
    void Push_Back(const T& val)
    {
        //判断容量大小
        if ( this->m_Capacity == this->m_Size )
        {
            cout<<"插入失败，数组容量已满！"<<endl;
            return;
        }
        this->pAddress[this->m_Size] = val;
        this->m_Size++;
    }

    //尾删法
    void Pop_Back()
    {
        //只是逻辑上的删除，即让用户访问不到
        if ( this->m_Size == 0 )
        {
            cout << "删除失败，数组为空！" << endl;
            return;
        }
        this->m_Size--;
    }

    //通过下标方式访问数组中的元素，重载[]运算符
    T& operator[](int index)
    {
        return this->pAddress[index];
    }

    //得到数组的容量
    int getCapacity()
    {
        return this->m_Capacity;
    }

    //得到数组的大小
    int getSize()
    {
        return this->m_Size;
    }

    //析构函数
    ~MyArray()
    {
        cout << "析构" << endl;
        if ( this->pAddress != NULL )
        {
            delete[] this->pAddress;
            this->pAddress = NULL;
        }
    }
private:
    T* pAddress;    //指针指向堆区开辟的真实数组
    int m_Capacity;     //数组的容量
    int m_Size;     //数组的长度
};