#include<iostream>
#include<string>
#include"person.h"
using namespace std;
/*
* 1�����壺
*		��1���ܽ����Ժ���Ϊ��Ϊһ�����壬���������е�����
*		��2���ܽ����Ժ���Ϊ����Ȩ�޿���
* 
* 2������Ȩ�������֣�
		��1��public(����Ȩ��)�����������Լ����඼���Է���
		��2��protected(����Ȩ��)�����ڿ��Է��ʣ����ⲻ���Է��ʣ�������Է���
		��3��private(˽��Ȩ��)�����ڿ��Է��ʣ����ⲻ���Է��ʣ����಻���Է���

 3��C++��struct��class������structĬ��Ȩ��Ϊpublic��classĬ��Ȩ��Ϊprivate�������ط�����û������ָֻ��c++�У� 

 4�����ļ���д����ͷ�ļ��з��������������������Ժͺ�����������.cpp�ļ��зź��������ʵ�֣���������ǰҪ�� "����::"  ( "����" �� "::" ��ʾ���������������)
*/

class Student
{
public :  //����Ȩ��
	//����
	string m_Name;    //����
	string m_Id;	//ѧ��

	//��Ϊ
	//��ѧ����������г�Ա���Ը�ֵ
	void setStudent(string name, string id)
	{
		m_Name = name;
		m_Id = id;
	}
	//��ѧ���������Ը�ֵ
	void setName(string name)
	{
		m_Name = name;
	}
	//��ѧ��ѧ�����Ը�ֵ
	void setId(string id)
	{
		m_Id = id;
	}
	//��ӡѧ����Ϣ
	void display()
	{
		cout << "������" << m_Name << "\tѧ�ţ�" << m_Id << endl;
	}

};

//void main()
//{
//	Student student;
//	student.setStudent("����", "12341");
//	student.display();
//	Person p;
//	p.setName("����");
//	p.setSex(true);
//	p.display();
//	system("pause");
//}