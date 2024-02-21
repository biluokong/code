package 数据结构.逻辑结构.线性结构.线性表.应用.一元多项式的运算;

import 数据结构.逻辑结构.线性结构.线性表.顺序表示.MyArrayList;

/*
    Pa(x) = 10 + 5x - 4x^2 + 3x^3 + 2x^4
    Pb(x) = -3 + 8x + 4x^2 - 5x^4 + 7x^5 - 2x^6
    实现两个多项式的加减运算，普通数组方法实现
 */
public class Test01 {
    public static void main(String[] args) {
        MyArrayList<Integer> arr1 = new MyArrayList(5);
        MyArrayList<Integer> arr2 = new MyArrayList(7);

        arr1.add(10);
        arr1.add(5);
        arr1.add(-4);
        arr1.add(3);
        arr1.add(2);
        arr2.add(-3);
        arr2.add(8);
        arr2.add(4);
        arr2.add(0);
        arr2.add(-5);
        arr2.add(7);
        arr2.add(-2);
//        add(arr2, arr1).traverse();
//        sub(arr1, arr2).traverse();
    }

    /**
     * 实现两个多项式的加法
     * @param arr1
     * @param arr2
     * @return
     */
    public static MyArrayList add(MyArrayList<Integer> arr1, MyArrayList<Integer> arr2) {
        MyArrayList arr3 = (arr1.getLength() > arr2.getLength() ? arr1 : arr2);
        for (int i = 0; i < (arr3 == arr1 ? arr2.getLength() : arr1.getLength()); i++) {
            arr3.setDate(arr1.getValue(i) + arr2.getValue(i), i);
        }
        return arr3;
    }

    /**
     * 实现两个多项式的减法
     * @param arr1
     * @param arr2
     * @return
     */
    public static MyArrayList sub(MyArrayList<Integer> arr1, MyArrayList<Integer> arr2) {
        MyArrayList arr3 = (arr1.getLength() > arr2.getLength() ? arr1 : arr2);
        for (int i = 0; i < (arr3 == arr1 ? arr1.getLength() : arr2.getLength()); i++) {
            if (arr3 == arr2 && i >= (arr3 == arr1 ? arr2.getLength() : arr1.getLength())) {
                arr3.setDate(-arr2.getValue(i), i);
            } else if (i < (arr3 == arr1 ? arr2.getLength() : arr1.getLength())) {
                arr3.setDate(arr1.getValue(i) - arr2.getValue(i), i);
            }
        }
        return arr3;
    }
}
