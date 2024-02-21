package 面向对象抽象.day22;
/*按要求编写一个Java应用程序程序：
（1）定义一个接口CanFly，描述会飞的方法public void fly();
（2）分别定义类飞机和鸟，实现CanFly接口。
（3）定义一个测试类，测试飞机和鸟，在main方法中创建飞机对象和鸟对象，

再定义一个makeFly()方法，其中让会飞的事物飞。并在main方法中调用该方法，让飞机和鸟起飞。*/
public class Test03 {
    public static void main(String[] args) {
       CanFly plane = new Plane();
       CanFly bird = new Bird();
       plane.makeFly();
       bird.makeFly();
    }
}

class Plane implements CanFly {

    @Override
    public void fly() {
        System.out.println("飞机可以飞翔！");
    }

    @Override
    public void makeFly() {
        System.out.println("飞机在飞翔！");
    }
}

class Bird implements CanFly {

    @Override
    public void fly() {
        System.out.println("鸟儿可以翱翔！");
    }

    @Override
    public void makeFly() {
        System.out.println("鸟儿在翱翔！");
    }
}

interface CanFly {
    void fly();

    void makeFly();
}