
/* 1、copy
            （1）功能：将容器内指定范围的元素拷贝到另一个容器中
            （2）函数原型
                            copy(iterator beg, iterator end, iterator dest);    //dest是目标起始迭器
                                
    2、replace
            （1）功能：将指定范围内的所有旧元素替换成新元素
            （2）函数原型
                            replace(iterator beg, iterator end, oldvalue, newvalue);

    3、replace_if
            （1）功能：将指定范围内满足条件的所有元素替换成新元素
            （2）函数原型
                            replace_if(iterator beg, iterator end, _Pred, newvalue);        //_Pred—自定义函数或谓词

    4、swap
            （1）功能：互换两个容器的元素，本质上是将两个容器的指针所指的首地址互换了
            （2）函数原型
                            swap(container c1, container c2);       //需同种容器
*/