package 实验六继承和多态;

public class USBTest {
    public static void main(String[] args) {
        //创建手机和电脑对象
        Mobile mobile = new Mobile("小米");
        Computer computer = new Computer("联想");

        //创建Charger和UDisk对象
        Charger charger = new Charger("小米CDQ012M");
        UDisk uDisk = new UDisk("kingston");

        //给手机充电，让电脑连接U盘器
        System.out.print(mobile.getBrand() + "手机");
        mobile.insertUsb(charger);
        System.out.print(computer.getBrand() + "电脑");
        computer.insertUsb(uDisk);
    }
}

/**
 * 手机类
 */
class Mobile {
    private String brand;   //手机的品牌

    /**
     * 有参构造方法创建一个品牌名为brand的手机对象
     * @param brand
     */
    public Mobile(String brand) {
        this.brand = brand;
    }

    /**
     * 用来连接充电器的方法
     * @param device 具体的USB充电连接线方法
     */
    public void insertUsb(Usb device) {
        device.connect();
    }

    public String getBrand() {
        return brand;
    }
}

/**
 * 电脑类
 */
class Computer {
    private String brand;   //电脑的品牌

    /**
     * 有参构造方法创建一个品牌名为brand的电脑对象
     * @param brand 品牌名
     */
    public Computer(String brand) {
        this.brand = brand;
    }

    /**
     * 用来连接USB的方法
     * @param device 具体的USB连接对象
     */
    public void insertUsb(Usb device) {
        device.connect();
    }

    public String getBrand() {
        return brand;
    }
}

/**
 * 充电类
 */
class Charger implements Usb {
    private String brand;   //充电器的品牌型号名

    /**
     * 有参构造方法创建一个品牌型号名为brand的充电器对象
     * @param brand 品牌型号名
     */
    public Charger(String brand) {
        this.brand = brand;
    }

    /**
     * 重写连接方法，可以用来连接手机，给手机充电
     */
    @Override
    public void connect() {
        System.out.println("已连接" + brand + "充电器，正在充电...");
    }
}

/**
 * U盘器类
 */
class UDisk implements Usb {
    private String brand;   //U盘的品牌型号名

    /**
     * 有参构造方法创建一个品牌型号名为brand的U盘对象
     * @param brand 品牌型号名
     */
    public UDisk(String brand) {
        this.brand = brand;
    }

    /**
     * 重写连接方法，可以与电脑连接，传输数据
     */
    @Override
    public void connect() {
        System.out.println("已连接" + brand + "U盘器，正在读取数据...");
    }
}

/**
 * Usb接口，用来连接USB
 */
interface Usb {
    /**
     * 连接方法，用来连接各种对象的插口
     */
    void connect();
}
