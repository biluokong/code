package javase基础封装继承和多态.day16;
/*请定义一个交通工具(Vehicle)的类
其中有属性：
	速度(speed)
	体积(size)等等
	方法移动(move())
	设置速度(setSpeed(int speed))
	加速speedUp(),
	减速speedDown()等等.

最后在测试类Vehicle中的main()中实例化一个交通工具对象
并通过方法给它初始化speed,size的值并且打印出来。
另外调用加速减速的方法对速度进行改变。*/
public class Vehicle {
    private double speed;
    private double size;

    public Vehicle(double speed, double size) {
        if (speed >= 0 && size > 0) {
            this.speed = speed;
            this.size = size;
            System.out.println("已初始化速度为：" + speed + "km/h,体积为：" + size + "t");
        } else {
            System.out.println("非法的赋值！");
        }
    }

    public void move() {
        System.out.println("交通工具正在行驶！");
    }

    public void speedUp(double up) {
        if (up < 0) {
            System.out.println("加速失败！");
        } else {
            speed += up;
            System.out.println("当前速度为：" + speed + "km/h");
        }
    }

    public void speedDown(double down) {
        if (speed < down) {
            System.out.println("减速失败！");
        } else {
            speed -= down;
            System.out.println("当前速度为：" + speed + "km/h");
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

class VehicleTest {
    public static void main(String[] args) {
        Vehicle plane = new Vehicle(100, 100);
        plane.speedUp(30);
        plane.speedDown(40);
    }
}