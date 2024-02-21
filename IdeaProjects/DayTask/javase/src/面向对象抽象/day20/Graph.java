package 面向对象抽象.day20;

public abstract class Graph {
    private String brushColor;
    private boolean filling;

    public Graph() {
    }

    public Graph(String brushColor, boolean filling) {
        this.brushColor = brushColor;
        this.filling = filling;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getBrushColor() {
        return brushColor;
    }

    public void setBrushColor(String brushColor) {
        this.brushColor = brushColor;
    }

    public boolean isFilling() {
        return filling;
    }

    public void setFilling(boolean filling) {
        this.filling = filling;
    }
}
