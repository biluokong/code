
    /* 1、简介
                    sort                         //对容器内元素进行排序
                    random_shuffle      //洗牌，指定范围内的元素随机调整次序
                    merge                    //容器元素合并，并储存到另一个容器中
                    reverse                   //反转指定范围的元素

        2、sort
                    （1）功能：按值查找元素，找到了就返回指定位置迭代器，找不到返回结束迭代器的位置
                    （2）函数原型
                                    sort(iterator beg, iterator end, _Pred);        //最后一个参数可不填，默认升序。若想改变排序方式，可放自定义函数、内建函数或谓词

        3、random_shuffle
                    （1）功能：随机范围内的元素随机调整次序，但每次原型打乱的顺序是一样的，需要加srand((unsigned int)time(NULL)); 给不同的随机种子
                    （2）函数原型
                                    random_shuffle(iterator beg, iterator end);

        4、merge
                    （1）功能：将两个容器合并到另一个容器中，两个容器必须使同向有序的，合并的结果也是有序的；默认两容器都要升序，若想合并两个降序的，需再传入一个_Pred参数
                    （2）函数原型
                                    merge(iterator beg1, iterator end1, iterator beg2, iterator end2, iterator dest, _Pred);       //dest—目标容器开始迭代器，_Pred—自定义函数、内建函数或谓词

        5、reverse
                    （1）功能：反转指定范围内的元素
                    （2）函数原型
                                    reverse(iterator beg, iterator end);
    */