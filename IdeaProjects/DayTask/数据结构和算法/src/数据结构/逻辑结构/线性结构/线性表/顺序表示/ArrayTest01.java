package 数据结构.逻辑结构.线性结构.线性表.顺序表示;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 顺序表优点：储存密度大（数据元素所占储存/结点结构所占储存）为1
 *           末尾添加元素效率高、查找效率极高（随机存取）
 *      缺点；插入、删除效率极低
 *           浪费储存空间
 *           不能自由扩充容量
 */
public class ArrayTest01 {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList(6);
        arrayList.add(5);
        arrayList.add(0);
        arrayList.add(4);
        arrayList.add(7);
        arrayList.traverse();
        arrayList.insert(8, 2);
        arrayList.insert(12, 5);
        arrayList.expansion();
        System.out.println(arrayList.getMaxSize());
        arrayList.add(45);
        arrayList.traverse();
        arrayList.delete(3);
        arrayList.delete(new Integer(12));
        arrayList.traverse();
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.getValue(2));
        arrayList.clear();
        arrayList.add(8);
        arrayList.traverse();
    }
}