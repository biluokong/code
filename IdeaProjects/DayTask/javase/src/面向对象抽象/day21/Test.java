package 面向对象抽象.day21;

public class Test {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(new Monitor());
        notebook.useInsertDrawable();
        notebook.setInsertDrawable(new Mouse());
        notebook.useInsertDrawable();
        notebook.setInsertDrawable(new Keyboard());
        notebook.useInsertDrawable();
        notebook.setInsertDrawable(new Printer());
        notebook.useInsertDrawable();
    }
}