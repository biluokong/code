package com.bjpowernode.javase.实验七接口继承和多态;

import java.util.ArrayList;

/**
 * 定义Army测试类
 */
public class 实验七ArmyTest01 {
    public static void main(String[] args) {
        //创建一系列武器类实例对象
        Weapon tank1 = new Tank("96式坦克");
        Weapon tank2 = new Tank("99A坦克");
        Weapon fighter1 = new Fighter("歼10");
        Weapon fighter2 = new Fighter("歼20");
        Weapon warShip1 = new WarShip("黄河号舰艇");
        Weapon warShip2 = new WarShip("天狼星号舰艇");

        //创建一支军队，并给军队添加武器
        Army army = new Army();
        army.addWeapon(tank1);
        army.addWeapon(tank2);
        army.addWeapon(fighter1);
        army.addWeapon(fighter2);
        army.addWeapon(warShip1);
        army.addWeapon(warShip2);

        System.out.println("军队的武器数量为："+army.getNum());
        army.loadAll();    //给所有武器装载弹药
        army.launchAll();    //让所有武器发起进攻
    }
}

//定义一个弹药类
class Bullet {

    //定义一个私有String属性name为弹药名称
    private String name;

    /**
     * 创建有参构造方法
     * @param name
     */
    public Bullet(String name) {
        this.name = name;
    }

    /**
     * 创建get方法
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * 创建set方法
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 装载弹药的接口Loadable
 * 有一个装载的抽象方法load()
 */
interface Loadable {
    void load();
}

/**
 * 发射弹药的接口Launchable
 * 有一个发射的抽象方法launch()
 */
interface Launchable {
    void launch();
}

/**
 * 定义武器类Weapon
 * 可装弹和发射
 */
class Weapon implements Loadable, Launchable {

    private String name;    //定义私有String属性name为武器名称
    private Bullet bullet;  //定义可使用的弹药bullet对象

    public Weapon(String name, Bullet bullet) {
        this.name = name;
        this.bullet = bullet;
    }

    //重写接口Loadable的load()方法
    @Override
    public void load() {
        System.out.println(name+"正在装载"+bullet.getName());
    }

    //重写接口Launchable的launch()方法
    @Override
    public void launch() {
        System.out.println(name+"正在发射"+bullet.getName());
    }

    /**
     * 创建name的get方法
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * 创建name的set方法
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 创建bullet的get方法
     * @return the bullet
     */
    public Bullet getBullet() {
        return bullet;
    }

    /**
     * 创建bullet的set方法
     * @param bullet
     */
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}

/**
 * 定义三个普通武器类：Tank、Flighter、WarShip
 * 都继承武器类Weapon，带一个参数为name的构造方法
 */
class Tank extends Weapon {

    /**
     * 创建Tank类的有参构造方法
     * @param name
     * 并用super()调用父类的构造方法给父类的私有属性赋值
     */
    public Tank(String name) {
        super(name, new Bullet("炮弹"));
    }
}

class Fighter extends Weapon {

    /**
     * 创建Fighter类的有参构造方法
     * @param name
     * 并用super()调用父类的构造方法给父类的私有属性赋值
     */
    public Fighter(String name) {
        super(name, new Bullet("导弹"));
    }
}

class WarShip extends Weapon {

    /**
     * 创建WarShip的有参构造方法
     * @param name
     * 并用super()调用父类的构造方法给父类的私有属性赋值
     */
    public WarShip(String name) {
        super(name, new Bullet("鱼雷"));
    }
}

/**
 * 定义军队Army类
 * 含有：
 *（1）属性：ArrayList<Weapon> weapon（用来存放军队装备的各种武器）
 *（2) 获取军队拥有的武器数量方法getNum
 *（3）添置武器的方法addWeapon
 *（4) 让所有武器都装载弹药的方法loadAll
 *（5）让所有武器都发起攻击的方法launchAll
 */
class Army {

    private ArrayList<Weapon> weapons;  //定义私有ArrayList<Weapon>属性weapon

    /**
     * 创建Army类的无参构造方法
     */
    public Army() {
        weapons = new ArrayList<>();
    }

    /**
     * 创建获取军队拥有的武器数量方法getNum
     * @return the weapon.size()
     */
    public int getNum() {
        return weapons.size();
    }

    /**
     * 创建添置武器的方法addWeapon
     * @param weapon
     */
    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    /**
     * 创建让所有武器都装载弹药的方法loadAll
     */
    public void loadAll() {
        System.out.println("所有武器装备装载弹药...");
        for (int i = 0; i < weapons.size(); i++) {
            weapons.get(i).load();
        }
        System.out.println("所有武器装载弹药完成！\n");
    }

    /**
     * 创建让所有武器都发起攻击的方法launchAll
     */
    public void launchAll() {
        System.out.println("所有武器准备发起攻击...");
        for (int i = 0; i < weapons.size(); i++) {
            weapons.get(i).launch();
        }
        System.out.println("所有武器已发起攻击！");
    }
}

