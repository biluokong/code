package 面向对象抽象.day21;

public class Keyboard implements InsertDrawable {
    @Override
    public void use() {
        System.out.println("键盘已连接，可以使用");
    }
}
