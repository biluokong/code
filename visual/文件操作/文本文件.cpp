#include<iostream>
#include<fstream>
#include<string>
using namespace std;

//�ı��ļ����ı���ASCII����ʽ����

//�����ļ��������ࣺ     ��ofstream��д����       ��ifstream��������       ��fstream����д����

/*  1��д�ļ�
* 
*               ��1�����裺  �ٰ���ͷ�ļ���#include<fstream>        �ڴ���������ofstream ofs;        �۴��ļ���ofs.open("�ļ�·��"���򿪷�ʽ)��
*                                    ��д���ݣ�ofs<<"д�������"��        �ݹر��ļ���ofs.close();
* 
*               ��2���򿪷�ʽ��    ��ios::in    Ϊ���ļ������ļ�       ��ios::out   Ϊд�ļ������ļ���������󸲸ǣ�       ��ios::ate   ��ʼλ�ã��ļ�β��
*                                             ��ios::app     ׷�ӷ�ʽд�ļ�         ��ios::trunc     ����ļ�������ɾ�����ٴ���           ��ios::binary    �����Ʒ�ʽ
* 
*                                       ע�⣺�ļ��򿪷�ʽ�����ʹ�ã����á�|�����������磺ios::binary | ios::out
*/
//д�ļ�
void test01()
{
    ofstream ofs;
    //���ļ������ڣ��ᴴ���ļ��ڵ�ǰcpp�ļ�ͬĿ¼��
    ofs.open("test.txt", ios::out);
    ofs << "����������" << endl;
    ofs << "�Ա���" << endl;
    ofs.close();
}

void test02()
{
    ifstream ifs;
    ifs.open("test.txt", ios::in);
    if ( !ifs.is_open() )
    {
        cout << "�ļ���ʧ��" << endl;
        return;
    }
    //������
    //��һ�֣����ַ����飬һ���ַ�һ���ַ��Ķ�
    /*char buf1[1024] = { 0 };
    while ( ifs >> buf1 )
    {
        cout << buf1 << endl;
    }*/

    //�ڶ��ַ�ʽ��һ���ַ�һ���ַ��Ķ�
    /*char buf2[1024] = { 0 };
    while ( ifs.getline(buf2, sizeof(buf2)) )
    {
        cout << buf2 << endl;
    }*/

    //�����ַ�ʽ����ȫ�ֺ���getling()
    /*string buf;
    while ( getline(ifs, buf))
    {
        cout << buf << endl;
    }*/

    //�����ַ�ʽ�����ַ�������һ��һ���ַ��Ķ�, �˷�ʽ��ѻس������룬���ü�Ҳ���ܼ�endl
    char c;
    while ( (c = ifs.get()) != EOF )
    {
        cout << c;
    }

    ifs.close();
}

//void main()
//{
//   /* test01();*/
//
//    /* 2�����ļ�
//    *           ��1�����裺  �ٰ���ͷ�ļ���#include<fstream>        �ڴ���������ifstream ifs;        �۴��ļ����ж��ļ��Ƿ�򿪳ɹ���ifs.open("�ļ�·��"���򿪷�ʽ)��
//    *                                �ж�ifs.isope()�����               �ܶ����ݣ����ַ�ʽ��ȡ             �ݹر��ļ���ifs.close();
//    */
//    test02();
//    system("pause");
//}
