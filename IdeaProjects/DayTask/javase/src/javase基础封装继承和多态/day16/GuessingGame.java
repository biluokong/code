package javase基础封装继承和多态.day16;

import java.util.InputMismatchException;
import java.util.Scanner;

/*猜数字游戏
一个类A有一个实例变量v，从键盘接收一个正整数作为实例变量v的初始值。
另外再定义一个类B，对A类的实例变量v进行猜测。
	如果大了则提示大了
	小了则提示小了
	等于则提示猜测成功*/
public class GuessingGame {

    class A {
        private int v;

        public A(int v) {
            this.v = v;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }

    class B {
        private int n;

        public B(int n) {
            this.n = n;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }

    public void guess(int v, int n) {
        A a = new A(v);
        B b = new B(n);
        if (a.getV() < b.getN()) {
            System.out.println("这个数太大了！");
        } else if (a.getV() > b.getN()) {
            System.out.println("这个数太小了！");
        } else {
            System.out.println("猜测成功！");
        }
    }
}

class GuessingGameTest {
    public static void main(String[] args) {
        GuessingGame guessingGame = new GuessingGame();
        System.out.println("请输入两个整数：");
        Scanner scanner = new Scanner(System.in);
        try {
            guessingGame.guess(scanner.nextInt(), scanner.nextInt());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("非法的输入！");
        } finally{
            scanner.close();
        }
    }
}

