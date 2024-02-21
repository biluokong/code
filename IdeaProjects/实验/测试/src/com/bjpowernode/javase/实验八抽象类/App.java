package com.bjpowernode.javase.实验八抽象类;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Paint paint = new Paint();
        System.out.println("========作品列表========\n" +
                           "1.矩形\n" + "2.圆\n" + "3.小兔子\n" +
                           "=======================\n请选择：");
        Scanner input = new Scanner(System.in);
        int serialNum = input.nextInt();
        input.close();
        if (1 == serialNum || 2 == serialNum || 3 == serialNum) {
            if (1 == serialNum) {
                paint.setArt(new Rectangle("矩形", "东方易羽", 4, 7));
            } else if (2 == serialNum) {
                paint.setArt(new Circle("圆形", "李剑锋", 2));
            } else {
                paint.setArt(new Rabbit("小兔子", "上官诗雨"));
            }
            paint.draw();
        }
        else {
            System.out.println("非法输入");
        }
    }
}

abstract class AsciiArt {

    private String title;
    private String author;

    public AsciiArt(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void draw();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Paint {

    private AsciiArt art;

    public void setArt(AsciiArt art) {
        this.art = art;
    }

    public void draw() {
        System.out.println("作品：" + art.getTitle());
        System.out.println("作者：" + art.getAuthor());
        art.draw();
    }
}

class Rabbit extends AsciiArt {

    public Rabbit(String title, String author) {
        super(title, author);
    }

    @Override
    public void draw() {
        System.out.println("  /)/)\n" +
                           " (- -) )o\n" +
                           "   || ||");
    }
}

class Rectangle extends AsciiArt {

    private int width;
    private int height;

    public Rectangle(String title, String author, int width, int height) {
        super(title, author);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Circle extends AsciiArt {

    private int radius;

    public Circle(String title, String author, int radius) {
        super(title, author);
        this.radius = radius;
    }

    @Override
    public void draw() {
        for (int y = 0; y <= 2 * radius; y++) {
            for (int x = 0; x <= 2 * radius; x++) {
                if ((x - radius) * (x - radius) + (y - radius) * (y - radius) <= radius * radius) {
                    System.out.print("**");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
