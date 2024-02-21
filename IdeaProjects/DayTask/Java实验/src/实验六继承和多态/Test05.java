package 实验六继承和多态;

import java.util.ArrayList;

public class Test05 {
    public static void main(String[] args) {
        //创建各种武器
        Tank tank1 = new Tank("96式主战坦克");
        Tank tank2 = new Tank("96式主战坦克");
        Tank tank3 = new Tank("63A式水陆坦克");

        Flighter flighter1 = new Flighter("歼10");
        Flighter flighter2 = new Flighter("歼15");
        Flighter flighter3 = new Flighter("歼16");
        Flighter flighter4 = new Flighter("歼20");

        WarShip warShip1 = new WarShip("055型驱逐舰");
        WarShip warShip2 = new WarShip("052D型驱逐舰");
        WarShip warShip3 = new WarShip("075型两栖攻击舰");

        //创建一支军队
        Army army = new Army();

        //给军队添置各种武器
        army.addWeapon(tank1);
        army.addWeapon(tank2);
        army.addWeapon(tank3);
        army.addWeapon(flighter1);
        army.addWeapon(flighter2);
        army.addWeapon(flighter3);
        army.addWeapon(flighter4);
        army.addWeapon(warShip1);
        army.addWeapon(warShip2);
        army.addWeapon(warShip3);

        //输出军队拥有的武器数量
        System.out.println("军队的武器数量为：" + army.getNum());

        //让军队所有武器装载弹药和发射弹药
        army.loadAll();
        army.luanchAll();
    }
}

/**
 * 军队类
 */
class Army {
    private ArrayList<Weapon> weapons;  //军队的装备库

    /**
     * 无参构造方法创建有一个武器装备库的军队对象
     */
    public Army() {
        weapons = new ArrayList<Weapon>();
    }

    /**
     * 添置武器的方法
     * @param weapon 添置的武器
     */
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    /**
     * 让所有武器都装载弹药的方法
     */
    public void loadAll() {
        System.out.println("\n所有武器开始装载弹药...");
        for (Weapon w : weapons) {
            w.load();
        }
    }

    /**
     * 让所有武器攻击的方法
     */
    public void luanchAll() {
        System.out.println("\n所有武器开始发起攻击...");
        for (Weapon w : weapons)
            w.launch();
    }

    /**
     * 获取军队武器数量的方法
     * @return 军队武器的数量
     */
    public int getNum() {
        return weapons.size();
    }
}

/**
 * 舰艇类
 */
class WarShip extends Weapon {

    /**
     * 有参构造方法创建舰艇名为name的舰艇对象
     * @param name
     */
    public WarShip(String name) {
        super(name);
        setBullet(new Bullet("鱼雷"));
    }
}

/**
 * 战斗机类
 */
class Flighter extends Weapon {

    /**
     * 有参构造方法创建战斗机名为name的战斗机对象
     * @param name 战斗机名称
     */
    public Flighter(String name) {
        super(name);
        setBullet(new Bullet("导弹"));
    }
}

/**
 * 坦克类
 */
class Tank extends Weapon {

    /**
     * 有参构造方法创建坦克名为name的坦克对象
     * @param name 坦克名称
     */
    public Tank(String name) {
        super(name);
        setBullet(new Bullet("炮弹"));
    }
}

/**
 * 武器类，实现了装弹和发射的接口
 */
class Weapon implements Loadable, Launchable {
    private String name;    //武器名称
    private Bullet bullet;  //可使用的弹药

    /**
     * 有参构造方法创建武器名称为name的武器对象
     * @param name 武器名称
     */
    public Weapon(String name) {
        this.name = name;
    }

    /**
     * 有参构造方法创建武器名称为name，可使用弹药为bullet的武器对象
     * @param name 武器名
     * @param bullet 可使用的弹药
     */
    public Weapon(String name, Bullet bullet) {
        this.name = name;
        this.bullet = bullet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    /**
     * 重写的装载方法，可输出装载的弹药
     */
    @Override
    public void launch() {
        System.out.println(name + "发射了" + bullet.getName());
    }

    /**
     * 重写的方射方法，可输出发射的弹药
     */
    @Override
    public void load() {
        System.out.println(name + "装载了" + bullet.getName());
    }
}

/**
 * 发射弹药的接口
 */
interface Launchable {
    void launch();
}

/**
 * 装载弹药的接口
 */
interface Loadable {
    void load();
}

/**
 * 弹药类
 */
class Bullet {
    private String name;    //弹药名

    /**
     * 有参构造方法创建一个弹药名为name的弹药对象
     * @param name 弹药名
     */
    public Bullet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
