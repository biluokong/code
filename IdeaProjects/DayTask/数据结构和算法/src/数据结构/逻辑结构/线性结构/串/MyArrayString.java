package 数据结构.逻辑结构.线性结构.串;

import java.util.Arrays;

/**
 * 顺序串
 */
public class MyArrayString {
    private char[] string;
    private int maxSize;
    private int length;

    /**
     * 无参构造方法创建一个容量大小为10的空顺序串
     */
    public MyArrayString() {
        maxSize = 10;
        string = new char[maxSize];
        length = 0;
    }

    /**
     * 有参构造方法创建一个容量大小为maxSize的空顺序串
     * @param maxSize
     */
    public MyArrayString(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            string = new char[maxSize];
            length = 0;
            return;
        }
        System.out.println("方法的容量大小！");
    }

    /**
     * 有参构造方法创建一个含有string字符串的顺序串
     * @param string
     */
    public MyArrayString(char[] string) {
        this.string = string;
        length = string.length;
    }

    /**
     * 创建一个数据容量大小为maxSize的含有sting字符串的顺序串
     * @param maxSize
     * @param string
     */
    public MyArrayString(int maxSize, char[] string) {
        if (maxSize >= string.length) {
            this.maxSize = maxSize;
            this.string = new char[maxSize];
            for (int i = 0; i < string.length; i++) {
                this.string[i] = string[i];
            }
            length = string.length;
            return;
        }
        System.out.println("串的容量太小！");
    }

    /**
     * KMP算法（重点）
     * 查找子串在主串中的位置，从主串下标为pos的位置找起，找到了就返回匹配成功的第一个字符的下标
     * @param str1
     * @param str2
     * @param pos
     * @return
     */
    public static int index_KMP(MyArrayString str1, MyArrayString str2, int pos) {
        int[] next = get_NextVal(str2);
        int i = pos, j = 0;
        while (i < str1.length && j < str2.length) {
            if (j == -1 || str1.string[i] == str2.string[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == str2.length) {
            return i - j;
        }
        return -1;
    }

    //获得nextVal数组的方法一：直接在获取next数组的同时获取nextVal数组
    public static int[] get_NextVal(MyArrayString str2) {
        int i = 0, j = -1;
        int[] nextVal = new int[str2.length];
        nextVal[0] = -1;
        while (i < str2.length - 1) {
            if (j == -1 || str2.string[i] == str2.string[j]) {
                i++;
                j++;
                if (str2.string[i] != str2.string[j]) {
                    nextVal[i] = j;
                } else {
                    nextVal[i] = nextVal[j];
                }
            } else {
                j = nextVal[j];
            }
        }
        return nextVal;
    }

    //获得nextVal数组的方法二：先获取next数组，在通过next数组获得nextVal数组
    public static int[] get_NextVal2(MyArrayString str2) {
        int[] next = get_Next(str2);
        int[] nextVal = new int[str2.length];
        nextVal[0] = -1;
        for (int j = 1; j < str2.length; j++){
            if (str2.string[next[j]] == str2.string[j])
                nextVal[j] = nextVal[next[j]];
            else
                nextVal[j] = next[j];
        }
        return nextVal;
    }

    /**
     * 得到字符串的next数组
     * @param str2
     * @return
     */
    public static int[] get_Next(MyArrayString str2) {
        int i = 0, j = -1;
        int[] next = new int[str2.length];
        next[0] = -1;
        while (i < str2.length - 1) {
            if (j == -1 || str2.string[i] == str2.string[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * BF算法
     * 查找子串在主串中的位置，从主串下标为pos的位置找起，找到了就返回匹配成功的第一个字符的下标
     * @param str1
     * @param str2
     * @return
     */
    public static int index_BF(MyArrayString str1, MyArrayString str2, int pos) {
        int i = pos, j = 0;
        while (i < str1.length && j < str2.length) {
            if (str1.string[i] == str2.string[j]) {
                i++;
                j++;
            } else {
                i += 1 - j;
                j = 0;
            }
        }
        if (j == str2.length) {
            return i - j;
        }
        return -1;
    }

    /**
     * 遍历顺序串
     */
    public void traverse() {
        for (int i = 0; i < length; i++) {
            System.out.print(string[i]);
        }
        System.out.println();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getLength() {
        return length;
    }
}
