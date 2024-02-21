package 数据结构.逻辑结构.线性结构.串;

public class Test {
    public static void main(String[] args) {
        MyArrayString str1 = new MyArrayString(new char[]{'c','b','a', 'a', 'a', 'b', 'b','c','d','a','a','a','a','b'});
        MyArrayString str2 = new MyArrayString( new char[]{'a', 'a','a','b'});
        /*for (int i = 0; i < MyArrayString.get_Next(str1).length; i++) {
            System.out.print(MyArrayString.get_Next(str1)[i] + "  ");
        }
        System.out.println();
        for (int i = 0; i < MyArrayString.get_Nextval(str1).length; i++) {
            System.out.print(MyArrayString.get_Nextval(str1)[i] + "  ");
        }*/
        /*System.out.println(MyArrayString.index_BF(str1, str2, 3));
        System.out.println(MyArrayString.index_KMP(str1, str2, 3));*/

        MyArrayString str3 = new MyArrayString(new char[]{'a','a','a','a','b'});
        int[] next = MyArrayString.get_Next(str3);
        for (int i : next) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : MyArrayString.get_NextVal2(str3)) {
            System.out.print(i + " ");
        }

    }
}
