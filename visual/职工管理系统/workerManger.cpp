#include "workerManager.h"

WorkerManager::WorkerManager()
{
    ifstream ifs;
    ifs.open(FILENAME, ios::in);

    //����ļ�������
    if ( !ifs.is_open() )
    {
        cout << "�ļ������ڣ�" << endl;    //�������
                                    
    //��ʼ������
    this->m_EmpNum = 0;
    this->m_FileIsEmpty = true;
    this->m_EmpArray = NULL;
    ifs.close();
    return;
    }

    //�ļ����ڣ�����û�м�¼
    char ch;
    ifs >> ch;  //ifs����һ���ַ�
    if ( ifs.eof() )    //�ж��ļ��Ƿ�Ϊ��
    {
        cout << "�ļ�Ϊ�գ�" << endl;
        //��ʼ������
        this->m_EmpNum = 0;
        this->m_FileIsEmpty = true;
        this->m_EmpArray = NULL;
        ifs.close();
        return;
    }

    //�ļ����ڣ����Ҽ�¼����
    int num = this->get_EmpNum();
    cout << "ְ������Ϊ��" << num << endl;    //���Դ���
    this->m_EmpNum = num;       //���³�Ա����
    //����ְ������������
    this->m_EmpArray = new Worker * [this->m_EmpNum];
    //��ʼ��ְ��
    init_Emp();

    //��ʼ����
    for ( int i = 0; i < m_EmpNum; i++ )
    {
        cout << "ְ���ţ�" << this->m_EmpArray[i]->m_Id
            << "\tְ��������" << this->m_EmpArray[i]->m_Name
            << "\t���ű�ţ�" << this->m_EmpArray[i]->m_Deptid << endl;
    }
}

void WorkerManager::Show_Menu()
{
    cout << "*******************************************" << endl;
    cout << "*********  ��ӭʹ��ְ������ϵͳ��**********" << endl;
    cout << "************  0. �˳�����ϵͳ  ************" << endl;
    cout << "************  1. ����ְ����Ϣ  ************" << endl;
    cout << "************  2. ��ʾְ����Ϣ  ************" << endl;
    cout << "************  3. ɾ��ְ����Ϣ  ************" << endl;
    cout << "************  4. �޸�ְ����Ϣ  ************" << endl;
    cout << "************  5. ����ְ����Ϣ  ************" << endl;
    cout << "************  6. ���ձ������  ************" << endl;
    cout << "************  7. ���������Ϣ  ************" << endl;
    cout << "*******************************************" << endl;
}

void WorkerManager::ExitSystem()
{
    cout << "��ӭ�´�ʹ��" << endl;
    system("pause");
    exit(0);
}

void WorkerManager::Add_Emp()
{
    cout << "��������ӵ�ְ��������" << endl;

    int addNum = 0; //�����û�����������
    cin >> addNum;

    if ( addNum > 0 )
    {
        //���
        //������ӿռ�Ĵ�С
        int newSize = this->m_EmpNum + addNum;  //�¿ռ�Ĵ�С = ԭ����¼������ + ��������

        //�����¿ռ�
        Worker** newSpace = new Worker * [newSize];

        //��ԭ���ռ��µ����ݣ��������¿ռ���
        if ( this->m_EmpArray != NULL )
        {
            for ( int i = 0; i < this->m_EmpNum; i++ )
            {
                newSpace[i] = this->m_EmpArray[i];
            }
        }

        //�������������
        for ( int i = 0; i < addNum; i++ )
        {
            int id; //ְ�����
            string name;    //ְ������
            int dSelect;    //���ű��ѡ��

            cout << "�������" << i + 1 << "����ְ���ı�ţ�" << endl;
            cin >> id;
            cout << "�������" << i + 1 << "����ְ����������" << endl;
            cin >> name;
            cout << "��ѡ���ְ����λ��" << endl;
            cout << "1. ��ְͨ��" << endl;
            cout << "2. ����" << endl;
            cout << "3. �ϰ�" << endl;
            cin >> dSelect;

            Worker* worker = NULL;
            switch ( dSelect )
            {
                case 1:
                    worker = new Employee(id, name, 1);
                    break;
                case 2:
                    worker = new Manager(id, name, 2);
                    break;
                case 3:
                    worker = new Boss(id, name, 3);
                    break;
                default:
                    break;
            }
            //��������ְ�������浽������
            newSpace[this->m_EmpNum + i] = worker;
        }
        //�ͷ�ԭ�пռ�
        delete[] this->m_EmpArray;

        //�����¿ռ��ָ��
        this->m_EmpArray = newSpace;

        //������ְ��������
        this->m_EmpNum = newSize;

        //���ļ���־Ϊ��Ϊ��
        this->m_FileIsEmpty = false;

        //����ְ������Ϣ
        this->save();

        //��ʾ
        cout << "�ɹ����" << addNum << "��ְ��" << endl;
    }
    else
    {
        cout << "�������������" << endl;
    }

    system("pause");
    system("cls");
}

void WorkerManager::save()
{
    ofstream ofs;
    ofs.open(FILENAME, ios::out);

    for ( int i = 0; i < this->m_EmpNum; i++ )
    {
        ofs << this->m_EmpArray[i]->m_Id << " "
            << this->m_EmpArray[i]->m_Name << " "
            << this->m_EmpArray[i]->m_Deptid << endl;
    }

    ofs.close();
}

int WorkerManager::get_EmpNum()
{
    ifstream ifs;
    ifs.open(FILENAME, ios::in);

    int id;
    string name;
    int dId;

    int num = 0;

    while ( ifs >> id && ifs >> name && ifs >> dId )
    {
        //��¼����
        num++;
    }
    ifs.close();

    return num;
}

void WorkerManager::init_Emp()
{
    ifstream ifs;
    ifs.open(FILENAME, ios::in);

    int id;
    string name;
    int dId;

    int index = 0;
    while ( ifs >> id && ifs >> name && ifs >> dId )
    {
        Worker* worker = NULL;
        //���ݲ�ͬ�Ĳ���Id������ͬ����
        if ( dId == 1 )
        {
            worker = new Employee(id, name, dId);
        }
        else if ( dId == 2 )
        {
            worker = new Manager(id, name, dId);
        }
        else
        {
            worker = new Boss(id, name, dId);
        }
        //�����������
        this->m_EmpArray[index] = worker;
        index++;
    }
}

void WorkerManager::Show_Emp()
{
    if ( this->m_FileIsEmpty )
    {
        cout << "�ļ������ڻ��¼Ϊ�գ�" << endl;
    }
    else
    {
        for ( int i = 0; i < m_EmpNum; i++ )
        {
            //���ö�̬���ýӿ�
            this->m_EmpArray[i]->showInfo();
        }
    }

    system("pause");
    system("cls");
}

int WorkerManager::IsExist(int id)
{
    int index = -1;
    for ( int i = 0; i < this->get_EmpNum(); i++ )
    {
        if ( this->m_EmpArray[i]->m_Id == id )
        {
            index = i;
            break;
        }
    }
    return index;
}

void WorkerManager::Del_Emp()
{
    if ( this->m_FileIsEmpty )
    {
        cout << "�ļ������ڻ��¼Ϊ�գ�" << endl;
    }
    else
    {
        //����ְ�����ɾ��
        cout << "����������Ҫɾ����ְ����ţ�" << endl;
        int id = 0;
        cin >> id;

        int index = this->IsExist(id);

        if ( index != -1 )
        {
            //����ǰ��
            for ( int i = index; i < this->m_EmpNum - 1; i++ )
            {
                this->m_EmpArray[i] = this->m_EmpArray[i + 1];
            }
            this->m_EmpNum--;
            //����ͬ�����µ��ļ���
            this->save();

            cout << "ɾ���ɹ���" << endl;
        }
        else
        {
            cout << "ɾ��ʧ�ܣ�δ�ҵ���ְ��" << endl;
        }
    }
    system("pause");
    system("cls");
}

void WorkerManager::Mod_Emp()
{
    if ( this->m_FileIsEmpty )
    {
        cout << "�ļ������ڻ��¼Ϊ�գ�" << endl;
    }
    else
    {
        cout << "�������޸�ְ���ı�ţ�" << endl;
        int id;
        cin >> id;

        int ret = this->IsExist(id);
        if ( ret != -1 )
        {
            //���ҵ���ŵ�ְ��
            delete this->m_EmpArray[ret];

            int newId = 0;
            string newName = "";
            int dSelect = 0;

            cout << "�鵽��" << id << "��ְ������������ְ���ţ�" << endl;
            cin >> newId;

            cout << "��������������" << endl;
            cin >> newName;

            cout << "�������λ��" << endl;
            cout << "1. ��ͨ��λ" << endl;
            cout << "2. ����" << endl;
            cout << "3. �ϰ�" << endl;
            cin >> dSelect;

            Worker* worker = NULL;
            switch ( dSelect )
            {
                case 1 :
                    worker = new Employee(newId, newName, dSelect);
                    break;
                case 2 :
                    worker = new Manager(newId, newName, dSelect);
                    break;
                case 3 :
                    worker = new Boss(newId, newName, dSelect);
                    break;
                default:
                    break;
            }
            //�������ݵ�������
            this->m_EmpArray[ret] = worker;

            cout << "�޸ĳɹ���" << this->m_EmpArray[ret]->m_Deptid << endl;

            //�����ļ�
            this->save();
        }
        else
        {
            cout << "�޸�ʧ�ܣ����޴���" << endl;
        }
    }
    system("pause");
    system("cls");
}

void WorkerManager::Find_Emp()
{
    if ( this->m_FileIsEmpty )
    {
        cout << "�ļ������ڻ��¼Ϊ�գ�" << endl;
    }
    else
    {
        cout << "��������ҵķ�ʽ��" << endl;
        cout << "1. ����ְ����Ų���" << endl;
        cout << "2. ������������" << endl;

        int select = 0;
        cin >> select;

        if ( select == 1 )  //����ְ���Ų���
        {
            int id;
            cout << "����������Ҫ���ҵ�ְ���ţ�" << endl;
            cin >> id;

            int ret = IsExist(id);
            if ( ret != -1 )
            {
                cout << "���ҳɹ�����ְ����Ϣ���£�" << endl;
                this->m_EmpArray[ret]->showInfo();
            }
            else
            {
                cout << "����ʧ�ܣ����޴���" << endl;
            }
        }
        else if ( select == 2 ) //������������
        {
            string name;
            cout << "����������Ҫ���ҵ�������" << endl;
            cin >> name;

            bool flag = false;  //���ҵı�־
            for ( int i = 0; i < m_EmpNum; i++ )
            {
                if ( this->m_EmpArray[i]->m_Name == name )
                {
                    cout << "���ҳɹ���ְ�����Ϊ��"
                        << m_EmpArray[i]->m_Id
                        << "�ŵ���Ϣ���£�" << endl;

                    flag = true;

                    this->m_EmpArray[i]->showInfo();
                }
            }
            if ( flag == false )
            {
                //���޴���
                cout << "����ʧ�ܣ����޴���" << endl;
            }
        }
        else
        {
            cout << "����ѡ������" << endl;
        }
    }
    system("pause");
    system("cls");
}

void WorkerManager::Sort_Emp()
{
    if ( this->m_FileIsEmpty )
    {
        cout << "�ļ������ڻ��¼Ϊ�գ�" << endl;
        system("pause");
        system("cls");
    }
    else
    {
        cout << "��ѡ������ʽ��" << endl;
        cout << "1. ����ְ�������������" << endl;
        cout << "2. ����ְ����Ž�������" << endl;

        int select = 0;
        cin >> select;

        for ( int i = 0; i < m_EmpNum; i++ )
        {
            int minOrMax = i;
            for ( int j = i + 1; j < m_EmpNum; j++ )
            {
                if ( select == 1 )  //����
                {
                    if ( m_EmpArray[minOrMax]->m_Id > m_EmpArray[j]->m_Id )
                    {
                        minOrMax = j;
                    }
                }
                else if ( select == 2 )    //����
                {
                    if ( m_EmpArray[minOrMax]->m_Id < m_EmpArray[j]->m_Id )
                    {
                        minOrMax = j;
                    }
                }
                else
                {
                    cout << "����ѡ������" << endl;
                    system("pause");
                    system("cls");
                    return;
                }
            }
            if ( i != minOrMax )
            {
                Worker* temp = m_EmpArray[i];
                m_EmpArray[i] = m_EmpArray[minOrMax];
                m_EmpArray[minOrMax] = temp;
            }
        }
        cout << "����ɹ����������Ϊ��" << endl;
        this->save();
        this->Show_Emp();
    }
}

void WorkerManager::Clean_File()
{
    cout << "ȷ����գ�" << endl;
    cout << "1. ȷ��" << endl;
    cout << "2. ����" << endl;

    int select = 0;
    cin >> select;

    if ( select == 1 )
    {
        //��ģʽ ios::turnc ���������ɾ���ļ������´���
        ofstream ofs(FILENAME, ios::trunc);
        ofs.close();

        if ( this->m_EmpArray != NULL )
        {
            for ( int i = 0; i < this->m_EmpNum; i++ )
            {
                if ( this->m_EmpArray[i] != NULL )
                {
                    delete this->m_EmpArray[i];
                }
            }
            this->m_EmpNum = 0;
            delete[] this->m_EmpArray;
            this->m_EmpArray = NULL;
            this->m_FileIsEmpty = true;
        }
        cout << "��ճɹ���" << endl;
    }
    system("pause");
    system("cls");
}

WorkerManager::~WorkerManager()
{
    if ( this->m_EmpArray != NULL )
    {
        for ( int i = 0; i < this->m_EmpNum; i++ )
        {
            if ( this->m_EmpArray[i] != NULL )
            {
                delete this->m_EmpArray[i];
            }
        }
        delete[] this->m_EmpArray;
        this->m_EmpArray = NULL;
    }
}