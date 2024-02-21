package javase基础封装继承和多态.day17;
/*编写程序模拟“主人”喂养“宠物”的场景：
提示1：
	主人类：Master
	宠物类：Pet
	宠物类子类：Dog、Cat、YingWu
提示2：
	主人应该有喂养的方法：feed()
	宠物应该有吃的方法：eat()
	只要主人喂宠物，宠物就吃。

要求：主人类中只提供一个喂养方法feed()，要求达到可以喂养各种类型的宠物。

编写测试程序：
	创建主人对象
	创建各种宠物对象
	调用主人的喂养方法feed()，喂养不同的宠物，观察执行结果。

通过该案例，理解多态在开发中的作用。
重要提示：feed方法是否需要一个参数，参数选什么类型！！*/
public class Test02 {
    public static void main(String[] args) {
        Master master = new Master();
        master.feed(new Dog());
        master.feed(new Cat());
        master.feed(new YingWu());
    }
}

class Master {
    public void feed(Pet pet) {
        pet.eat();
    }
}

abstract class Pet {
    abstract void eat();
}

class Dog extends Pet {
    @Override
    void eat() {
        System.out.println("小狗在啃骨头");
    }
}

class Cat extends Pet {
    @Override
    void eat() {
        System.out.println("小猫在吃鱼");
    }
}

class YingWu extends Pet {
    @Override
    void eat() {
        System.out.println("鹦鹉说“吃饭了，吃饭了”");
    }
}