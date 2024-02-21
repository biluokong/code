package test;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String x = a + b;
        //String ab = "a" + "b";
        String ab2 = new String("a") + new String("b");
        String ab = ab2.intern();
        System.out.println(x == "ab");
        System.out.println(x == ab2);
        System.out.println(ab == "ab");
        System.out.println(ab == ab2);
        System.out.println(ab2 == "ab");
    }
}
