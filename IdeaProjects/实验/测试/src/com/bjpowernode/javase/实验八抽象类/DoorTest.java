package com.bjpowernode.javase.实验八抽象类;

/**
 * 定义测试类DoorTest
 */
public class DoorTest {
    public static void main(String[] args) {

        //创建door实例对象
        Door door1 = new AlarmDoor("平安2021");
        Door door2 = new CommonDoor("平安2015");
        Door door3 = new CommonDoor("家和2019");
        Door door4 = new AlarmDoor("家和2020");

        //door实例对象的开关门操作
        door1.close();
        door2.open();

        //防止出现空引用异常，并判断door实例对象是哪种类型的门，从而进行对应的向下转型，以取的子类中独有的方法
        if (door3 == null) {
            System.out.println("door3赋了非法的值");
        } else if (door3 instanceof CommonDoor) {
            CommonDoor commonDoor3 = (CommonDoor) door3;
            commonDoor3.alarm();
        } else {
            AlarmDoor alarmDoor3 = (AlarmDoor) door3;
            alarmDoor3.alarm();
        }
        if (door4 == null) {
            System.out.println("door4赋了非法的值");
        } else if (door4 instanceof AlarmDoor) {
            AlarmDoor alarmDoor4 = (AlarmDoor) door4;
            alarmDoor4.alarm();
        } else {
            CommonDoor commonDoor4 = (CommonDoor) door4;
        }
    }
}

/**
 * 定义接口Alarm
 * 含有报警方法void alarm()
 */
interface Alarm {
    void alarm();   //创建抽象的报警方法
}

/**
 * 定义抽象类Door
 * 含有：
 * 1个私有属性name（品牌）；
 * 2个公有方法getName、setName；
 * 2个抽象方法开门void open( )、关门void close( )
 */
abstract class Door {

    private String name;    //定义私有String属性name为品牌

    //创建name的get方法
    public String getName() {
        return name;
    }

    //创建name的set方法
    public void setName(String name) {
        this.name = name;
    }

    //创建抽象开门方法open()
    public abstract void open();

    //创建抽象关门方法
    public abstract void close();
}

/**
 * 定义报警门AlarmDoor类
 * 继承Door类并实现接口Alarm
 * 并重写抽象类、接口中的所有抽象方法
 */
class AlarmDoor extends Door implements Alarm {

    /**
     * 创建AlarmDoor类的有参构造方法
     * @param name
     * 并用this。的方式调用set方法给私有属性赋值
     */
    public AlarmDoor(String name) {
        this.setName(name);
    }

    @Override   //重写接口Alarm中的报警方法void alarm
    public void alarm() {
        System.out.println(this.getName() + "开始报警！");
    }

    //重写父类AlarmDoor中的开门方法void open()和关门方法void close()
    @Override
    public void open() {
        System.out.println(this.getName() + "门被打开了！");
    }

    @Override
    public void close() {
        System.out.println(this.getName() + "门被关闭了！");
    }
}

/**
 * 定义普通门CommonDoor类
 * 继承Door
 * 并重写抽象方法
 */
class CommonDoor extends Door implements Alarm {

    /**
     * 创建CommonDoor类的有参构造方法
     * @param name
     * 并用this。的方式调用set方法给私有属性赋值
     */
    public CommonDoor(String name) {
        this.setName(name);
    }

    @Override   //重写接口Alarm中的报警方法void alarm
    public void alarm() {
        System.out.println(this.getName() + "不是报警门，没有报警功能！");
    }

    //重写父类AlarmDoor中的开门方法void open()和关门方法void close()
    @Override
    public void open() {
        System.out.println(this.getName() + "门被打开了！");
    }

    @Override
    public void close() {
        System.out.println(this.getName() + "门被关闭了！");
    }
}