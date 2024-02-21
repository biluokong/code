package 设计模式.工厂设计模式;

public abstract class Computer {
    private String name;
    private double price;

    public abstract void start();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Huawei extends Computer {
    @Override
    public void start() {
        System.out.println(getName() + "以非常霸气的方式启动了，展示了一个菊花的logo");
    }
}

class Mac extends Computer {
    @Override
    public void start() {
        System.out.println(getName() + "以非常优雅的方法启动了，展示了一个apple的logo");
    }
}