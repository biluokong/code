#include <iostream>
using namespace std;

    /* 1����������
                    ��1�������һ���Ƚ����(First In Last Out, FILO)�����ݽṹ����ֻ��һ������
                    ��2��ջ��ֻ�ж��˵�Ԫ�ؿ��Ա����ʹ�ã���˲��ܱ�����
                    ��3��ջ�н������ݳ�Ϊ��ջpush
                    ��4��ջ�е������ݳ�Ϊ��ջpop

        2�����ýӿ�
                    ��1�����캯��
                                    stack<T> stk;
                                    stack(const stack& stk);        //��������
                    ��2����ֵ����
                                    stack& operator=(const stack& stk);
                    ��3�����ݴ�ȡ
                                    push(elem);                         //��ջ�����Ԫ��
                                    pop();                                  //��ջ���Ƴ�Ԫ��
                                    top();                                   //����ջ��Ԫ��
                    ��4����С����
                                    empty();
                                    size();
    */