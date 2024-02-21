package 实验六继承和多态;

import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        //创建画家
        Paint paint = new Paint();

        //显示作品列表
        showArtWords();

        //选择展现作品
        selectWork(paint);
    }

    private static void selectWork(Paint paint) {
        Scanner input = new Scanner(System.in);
        System.out.print("请选择：");
        int select = input.nextInt();
        input.close();
        while (true) {
            switch (select) {
                case 1:
                    paint.setArt(new _Rectangle("矩形", "张三", 3, 8));
                    paint.draw();
                    return;
                case 2:
                    paint.setArt(new _Circle("圆形", "小丫", 4));
                    paint.draw();
                    return;
                case 3:
                    paint.setArt(new Rabbit("兔子", "李四"));
                    paint.draw();
                    return;
                default:
                    System.out.println("方法的输入，请重新输入：");
                    break;
            }
        }
    }

    private static void showArtWords() {
        System.out.println("==========作品列表==========");
        System.out.println("\t1.矩形");
        System.out.println("\t2.圆形");
        System.out.println("\t3.小兔子");
        System.out.println("===========================");
    }
}

class Paint {
    private AsciiArt art;   //艺术作品

    public void setArt(AsciiArt art) {
        this.art = art;
    }

    /**
     * 调用艺术作品的画画方法
     */
    public void draw() {
        art.draw();
    }
}

/**
 * 矩形作品类，继承了作品类
 */
class _Rectangle extends AsciiArt {
    private int width;  //矩形作品的宽
    private int height; //矩形作品的长

    /**
     * 有参构造方法创建标题名为title，作者为author，宽为width，长为weight的矩形作品对象
     * @param title 矩形作品标题
     * @param author 矩形作品作者
     * @param width 矩形作品的宽
     * @param height 矩形作品的长
     */
    public _Rectangle(String title, String author, int width, int height) {
        super(title, author);
        this.width = width;
        this.height = height;
    }

    /**
     * 重写作品的画画方法，能画出矩形
     */
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

/**
 * 圆形作品类，继承了作品类
 */
class _Circle extends AsciiArt {
    private int radius; //圆形作品的半径

    /**
     * 有参构造方法创建标题名为title，作者为author，半径为radius的圆形作品对象
     * @param title 圆形作品标题
     * @param author 圆形作品作者
     * @param radius 圆形作品半径
     */
    public _Circle(String title, String author, int radius) {
        super(title, author);
        this.radius = radius;
    }

    /**
     * 重写作品类的画画方法，能画出圆形
     */
    @Override
    public void draw() {
        int d = radius * 2; //直径
        for (int i = 0; i <= d; i++) {
            for (int j = 0; j <= d; j++) {
                if ((j - radius) * (j - radius) + (i - radius) * (i - radius) <= radius * radius) { //(i,j)在圆内
                    System.out.print("***");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

/**
 * 兔子作品类，继承了作品类
 */
class Rabbit extends AsciiArt {

    /**
     * 有参构造方法创建标题为title，作者为author的兔子作品对象
     * @param title 兔子作品标题
     * @param author 兔子作品作者
     */
    public Rabbit(String title, String author) {
        super(title, author);
    }

    /**
     * 重写作品类的画画方法，能画出兔子
     */
    @Override
    public void draw() {
        System.out.println(" /)/)" +
                         "\n(- -) )o" +
                         "\n  ||  ||");
    }
}

/**
 * 艺术作品抽象类
 */
abstract class AsciiArt {
    private String title;   //作品的标题
    private String author;  //作品的作者

    /**
     * 有参构造方法创建标题为title，作者为author的作品对象
     * @param title 作品标题
     * @param author 作品作者
     */
    public AsciiArt(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * 画画的抽象方法
     */
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