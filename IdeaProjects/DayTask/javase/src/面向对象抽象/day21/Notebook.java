package 面向对象抽象.day21;

public class Notebook {
    private InsertDrawable insertDrawable;

    public Notebook() {
    }

    public Notebook(InsertDrawable insertDrawable) {
        this.insertDrawable = insertDrawable;
    }

    public void useInsertDrawable() {
        insertDrawable.use();
    }

    public InsertDrawable getInsertDrawable() {
        return insertDrawable;
    }

    public void setInsertDrawable(InsertDrawable insertDrawable) {
        this.insertDrawable = insertDrawable;
    }
}
