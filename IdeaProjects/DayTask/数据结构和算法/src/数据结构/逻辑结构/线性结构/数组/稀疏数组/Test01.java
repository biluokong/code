package 数据结构.逻辑结构.线性结构.数组.稀疏数组;

import java.io.*;

/*原数组如果有许多无意义的值（如0），在其储存时会花费不必要的内存，尤其在数组内容所含数据非常大时
通过稀疏数组的使用可以大大减少需要储存的数据
它的格式是；
             【0】      【1】       【2】
            row(行)  columns(列)  value(值)
       【0】  总行数     总列数       总值数（有意义的）
       【1】 值的行标    值的列标      值的内容（第一个值）
       【2】 值的行标    值的列标      值的内容（第二个值）
       ......以此类推，是一个二维数组
*/
public class Test01 {
    public static void main(String[] args) {
        save(convert(initialArray()));
        reduce(load());
    }

    //还原成初始数组
    public static void reduce(int[][] arr) {
        int[][] array = new int[arr[0][0]][arr[0][1]];
        for (int i = 1; i < arr.length; i++) {
            array[arr[i][0]][arr[i][1]] = arr[i][2];
        }
        System.out.println("还原后的数组：");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%-4d", anInt);
            }
            System.out.println();
        }
    }

    //转化为稀疏数组
    public static int[][] convert(int[][] array) {
        int count = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }
        int[][] sparse = new int[count + 1][3];
        sparse[0][0] = array.length;
        sparse[0][1] = array[0].length;
        sparse[0][2] = count;
        count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[0].length; i1++) {
                if (array[i][i1] != 0) {
                    count++;
                    sparse[count][0] = i;
                    sparse[count][1] = i1;
                    sparse[count][2] = array[i][i1];
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] ints : sparse) {
            for (int anInt : ints) {
                System.out.printf("%-4d", anInt);
            }
            System.out.println();
        }
        return sparse;
    }

    //构建初始数组
    public static int[][] initialArray() {
        int[][] initial = new int[6][7];
        initial[0][1] = 12;
        initial[1][5] = 6;
        initial[4][2] = 15;
        initial[2][6] = 9;
        System.out.println("原始数组：");
        for (int[] ints : initial) {
            for (int anInt : ints) {
                System.out.printf("%-4d", anInt);
            }
            System.out.println();
        }
        return initial;
    }

    //读取稀疏数组的数据
    public static int[][] load() {
        try {
            ObjectInputStream arr = new ObjectInputStream(new FileInputStream("array"));
            try {
                return (int[][]) arr.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            arr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //保存对象的数据
    public static void save(int[][] array) {
        try {
            ObjectOutputStream arr = new ObjectOutputStream(new FileOutputStream("array"));
            arr.writeObject(array);
            arr.flush();
            arr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
