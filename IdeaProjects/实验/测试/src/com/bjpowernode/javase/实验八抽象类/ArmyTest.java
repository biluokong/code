package com.bjpowernode.javase.实验八抽象类;

import java.util.ArrayList;

public class ArmyTest {
    public static void main(String[] args) {
        //创建一系列武器类实例对象
        Weapon tank1 = new Tank("96式坦克");
        Weapon tank2 = new Tank("99A坦克");
        Weapon fighter1 = new Flighter("歼10");
        Weapon fighter2 = new Flighter("歼20");
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

interface Loadable {
    void load();
}

interface Launchable {
    void launch();
}

abstract class Weapon implements Loadable, Launchable {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Tank extends Weapon {

    public Tank(String name) {
        super.setName(name);
    }

    @Override
    public void load() {
        System.out.println(this.getName() + "开始装载炮弹！");
    }

    @Override
    public void launch() {
        System.out.println(this.getName() + "开始发射炮弹！");
    }
}

class Flighter extends Weapon {

    public Flighter(String name) {
        super.setName(name);
    }

    @Override
    public void load() {
        System.out.println(this.getName() + "开始装载导弹！");
    }

    @Override
    public void launch() {
        System.out.println(this.getName() + "开始发射导弹！");
    }
}

class WarShip extends Weapon {

    public WarShip(String name) {
        super.setName(name);
    }

    @Override
    public void load() {
        System.out.println(this.getName() + "开始装载鱼雷！");
    }

    @Override
    public void launch() {
        System.out.println(this.getName() + "开始发射鱼雷！");
    }
}

class Army {
    
    private ArrayList<Weapon> weapons;

    public Army() {
        weapons = new ArrayList<>();
    }

    public int getNum() {
        return weapons.size();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void loadAll() {
        System.out.println("\n所有武器开始装载弹药...");
        for (Weapon weapon : weapons) {
            weapon.load();
        }
        System.out.println("所有武器弹药已装载完成！");
    }

    public void launchAll() {
        System.out.println("\n所有武器开始发起攻击...");
        for (Weapon weapon : weapons) {
            weapon.launch();
        }
        System.out.println("所有武器已发起进攻！");
    }
}