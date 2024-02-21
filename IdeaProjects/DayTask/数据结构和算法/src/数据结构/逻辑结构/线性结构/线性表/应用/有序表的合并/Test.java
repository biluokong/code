package 数据结构.逻辑结构.线性结构.线性表.应用.有序表的合并;

import 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点.MyLinkedList;
import 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点.Node;
import 数据结构.逻辑结构.线性结构.线性表.顺序表示.MyArrayList;

/**问题描述：
 *      两个非递减有序排列线性表La和Lb，将两表归并为一个新表，新表数据元素仍按非递减有序排列
 *          La=(1,2,7,8)  Lb=(2,4,6,8,10,11)  ------>   Lc=(1,2,2,4,6,7,8,8,10,11)
 */
public class Test {
    public static void main(String[] args) {
        /*MyArrayList<Integer> arr1 = new MyArrayList();
        arr1.add(1);
        arr1.add(2);
        arr1.add(7);
        arr1.add(8);
        MyArrayList<Integer> arr2 = new MyArrayList();
        arr2.add(2);
        arr2.add(4);
        arr2.add(6);
        arr2.add(8);
        arr2.add(10);
        arr2.add(11);
        MyArrayList arr3 = arrayOrderedTableMerge(arr1, arr2);
        arr3.traverse();*/
        MyLinkedList<Integer> list1 = new MyLinkedList();
        list1.addTail(1);
        list1.addTail(2);
        list1.addTail(7);
        list1.addTail(8);
        MyLinkedList<Integer> list2 = new MyLinkedList();
        list2.addTail(2);
        list2.addTail(4);
        list2.addTail(6);
        list2.addTail(8);
        list2.addTail(10);
        list2.addTail(11);
        MyLinkedList list3 = linkedOrderedTableMerge(list1, list2);
        list3.traverse();
    }

    /**
     * 将两个非递减有序排列顺序表合并为一个非递减有序排列
     * @param arr1
     * @param arr2
     * @return
     */
    public static MyArrayList arrayOrderedTableMerge(MyArrayList<Integer> arr1, MyArrayList<Integer> arr2) {
        MyArrayList<Integer> arr3 = new MyArrayList(arr1.getLength()+arr2.getLength());
        while (!arr1.isEmpty() && !arr2.isEmpty()) {    //两线性表都不为空时，每一轮选出其中较大的放入新表
            int a1 = arr1.getValue(0);
            int a2 = arr2.getValue(0);
            if (a1 <= a2) {
                arr3.add(a1);
                arr1.delete(0);
            } else {
                arr3.add(a2);
                arr2.delete(0);
            }
        }
        //任意一表为空时，将另一表的剩余元素放入新表
        for (int i = 0; i < arr1.getLength(); i++) {
            arr3.add(arr1.getValue(i));
        }
        for (int i = 0; i < arr2.getLength(); i++) {
            arr3.add(arr2.getValue(i));
        }
        return arr3;
    }

    /**
     * 将两个非递减有序排列链式线性表合并为一个非递减有序排列
     * 法二的时间复杂度：O(list1.getLength + list2.getLength)
     *      空间复杂度：O(1)
     * @param list1
     * @param list2
     * @return
     */
    public static MyLinkedList linkedOrderedTableMerge(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2) {

        //法一：只将数据插入表中
        /*for (int i = 1; i <= list1.getLength(); i++) {
            int l1 = list1.getData(i);
            for (int i1 = i; i1 <= list2.getLength(); i1++) {
                int l2 = list2.getData(i1);
                if (l1 <= l2) {

                    if (i1 == 1) {
                        list2.addHead(l1);
                        break;
                    }
                    list2.insert(l1, i1);
                    break;
                }

            }
        }
        return list2;*/

        //法二：将结点整个插入表中
        Node t1 = list1.locate(1);
        Node t2 = list2.locate(1);
        MyLinkedList list3 = list1;
        Node t3 = list3.getNode();
        while (t1 != null && t2 != null) {
            if ((int) t1.getData() <= (int) t2.getData()) {
                t3.setNext(t1);
                t3 = t3.getNext();
                t1 = t1.getNext();
            }
            t3.setNext(t2);
            t3 = t3.getNext();
            t2 = t2.getNext();
        }
        t3.setNext((t1 == null ? t2 : t1));
        list2 = null;
        return list3;
    }
}
