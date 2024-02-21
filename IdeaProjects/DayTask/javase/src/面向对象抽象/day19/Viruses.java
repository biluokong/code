package 面向对象抽象.day19;

public class Viruses {
    private String name;
    private double size;
    private String type;

    public Viruses() {
    }

    public Viruses(String name, double size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public void attack(Humans humans) {
        humans.ill();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
