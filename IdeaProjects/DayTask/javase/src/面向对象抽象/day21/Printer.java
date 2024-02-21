package 面向对象抽象.day21;

public class Printer implements InsertDrawable {
    @Override
    public void use() {
        System.out.println("打印机已连接，可以使用");
    }
}
