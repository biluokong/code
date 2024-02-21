package 数据结构.逻辑结构.线性结构.线性表.应用.线性表的合并;

import 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点.MyLinkedList;
import 数据结构.逻辑结构.线性结构.线性表.顺序表示.MyArrayList;

/**问题描述：
 *      假设利用两个线性表La和Lb分别表示两个集合A和B，求新集合A=A∪B
 *          La=(7,5,3,2,11)  Lb=(2,6,3)   ------>     La=(7,5,3,2,11,6)
 */
public class Test {
    public static void main(String[] args) {
        /*MyArrayList<Integer> arr1= new MyArrayList();
        MyArrayList<Integer> arr2 = new MyArrayList();
        arr1.add(7);
        arr1.add(5);
        arr1.add(3);
        arr1.add(2);
        arr1.add(11);
        arr2.add(2);
        arr2.add(6);
        arr2.add(3);
        arr2.add(34);
        arr1.traverse();
        arr2.traverse();
        arrayListMerge(arr1, arr2);
        arr1.traverse();*/
        MyLinkedList<Integer> link1 = new MyLinkedList();
        MyLinkedList<Integer> link2 = new MyLinkedList();
        link1.addTail(7);
        link1.addTail(5);
        link1.addTail(3);
        link1.addTail(2);
        link1.addTail(11);
        link2.addTail(2);
        link2.addTail(6);
        link2.addTail(3);
        link2.addTail(34);
        link1.traverse();
        link2.traverse();
        linkedListMerge(link1, link2);
        link1.traverse();
    }

    /**
     * 链式线性表和并求并集
     * 时间复杂度：O(m*n)
     * @param link1
     * @param link2
     */
    public static void linkedListMerge(MyLinkedList link1, MyLinkedList link2) {
        /*for (int i = 1; i <= link2.getLength(); i++) {
            boolean flag = false;
            for (int i1 = 1; i1 <= link1.getLength(); i1++) {
                if (link2.getData(i).equals(link1.getData(i1))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                link1.addTail(link2.getData(i));
            }
        }*/
        //或者
        for (int i = 1; i <= link2.getLength(); i++) {
            if (link1.locate(link2.getData(i)) == -1) {
                link1.addTail(link2.getData(i));
            }
        }
    }

    /**
     * 顺序表和并求并集
     * 时间复杂度：O(m*n)
     * 链式结构合并代码类似
     * 时间复杂度同样为：O(m*n)
     * @param arr1
     * @param arr2
     */
    public static void arrayListMerge(MyArrayList arr1, MyArrayList arr2) {
        /*for (int i = 0; i < arr2.getLength(); i++) {
            boolean flag = false;
            for (int i1 = 0; i1 < arr1.getLength(); i1++) {
                if (arr2.getValue(i).equals(arr1.getValue(i1))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                arr1.add(arr2.getValue(i));
            }
        }*/
        //或者
        for (int i = 0; i < arr2.getLength(); i++) {
            if (arr1.locate(arr2.getValue(i)) == -1) {
                arr1.add(arr2.getValue(i));
            }
        }
    }
}
