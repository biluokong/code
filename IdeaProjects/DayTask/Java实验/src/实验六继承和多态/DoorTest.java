package 实验六继承和多态;

public class DoorTest {
    public static void main(String[] args) {
        //创建普通门
        Door door1 = new Door("梦天");
        Door door2 = new Door("兔宝宝");
        //创建报警门
        AlarmDoor door3 = new AlarmDoor("BOSCH博世安防");
        AlarmDoor door4 = new AlarmDoor("豪恩HORN");

        //调用门的开门、关门和报警方法
        door1.open();
        door1.close();
        door2.close();
        door3.alarm();
        door4.close();
        door4.open();
    }
}

/**
 * 报警门类
 */
class AlarmDoor extends Door implements Alarm {

    /**
     * 有参构造创建一个品牌类型名为name的报警门
     * @param name
     */
    public AlarmDoor(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println(getName()  + "报警门被打开了");
    }

    @Override
    public void close() {
        System.out.println(getName() + "报警门被关闭了");
    }

    @Override
    public void alarm() {
        System.out.println(getName() + "报警门开始报警了");
    }
}

/**
 * 普通门类
 */
class Door {
    private String name;    //门的品牌类型名

    /**
     *有参构造方法创建一个品牌类型名为name的门类
     * @param name 品牌类型名
     */
    public Door(String name) {
        this.name = name;
    }

    /**
     * 开门方法
     */
    public void open() {
        System.out.println(name + "普通门被打开了");
    }

    /**
     * 关门方法
     */
    public void close() {
        System.out.println(name + "普通门被关闭了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 拥有报警功能的警报接口
 */
interface Alarm {
    void alarm();
}
