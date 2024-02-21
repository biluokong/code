package 面向对象抽象.day20;

public class Test {
    public static void main(String[] args) {
        Artboard painter = new Artboard();
        painter.paint(new Circle("绿色", true, 3));
        painter.paint(new Rectangle("红色", false, 10, 5));
        painter.paint(new Square("黄色", false, 4));
    }
}
