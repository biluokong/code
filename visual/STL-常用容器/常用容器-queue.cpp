
/* 1����������
                ��1����һ���Ƚ��ȳ�(First In First Out, FIFO)�����ݽṹ��������������
                ��2���Ӷ�βback�����ݡ������push���Ӷ�ͷfront�����ݡ�������pop
                ��3��ֻ�ж�ͷ�Ͷ�β�ܱ������ʣ���˲��ܱ�����

    2�����ýӿ�
                ��1�����캯��
                                queue<T> que;
                                queue(const queue& que);
                ��2����ֵ����
                                queue& operator=(const queue& que);
                ��3�����ݴ�ȡ
                                push(elem)                      //�Ӷ�β���Ԫ��
                                pop();                              //�Ӷ�ͷ�Ƴ�Ԫ��
                                back();                             //�������һ��Ԫ��
                                front();                            //���ص�һ��Ԫ��
                ��4����С����
                                empty();
                                size();
*/