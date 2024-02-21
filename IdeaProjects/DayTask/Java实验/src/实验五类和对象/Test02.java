package 实验五类和对象;

/**
 * 设计一个汽车类Car，有2个属性车主owner和油量oil，有7个方法：
 * （1）构造方法Car(String owner,double oil)
 *   	（2）构造方法Car(String owner)，油量置为0
 *   	（3）加油操作方法void  addOil(double oil)
 *   	（4）行驶操作方法void  drive(int distance)
 *         假设每100公里的耗油量为定值（自己设置），根据行驶的公里数更新油量。
 *   	（5）获得车主信息方法String  getOwner()
 *   	（6）获得油量方法double getOil()
 *   	（7）main方法
 *         创建对象并对实例对象进行加油、行驶操作，显示车主、油量。
 */
public class Test02 {
    public static void main(String[] args) {
        //创建Car对象
        Car car = new Car("张三");
        try {
            car.addOil(15);     //对车进行加油操作
            car.drive(10);     //对车进行行驶操作
        } catch (IllegalOilInputException e) {
            e.printStackTrace();
        } catch (IllegalRouteInputException e) {
            e.printStackTrace();
        }
        System.out.println("车主是：" + car.getOwner());
        System.out.println("油量还剩：" + car.getOil() + "L");
    }
}

/**
 * 定义一个Car类
 */
class Car {
    private String owner;
    private double oil;

    /**
     * 有参构造方法将传入的owner和oil参数赋值给实例变量，初始化车主和油量
     * 若输入了非法油量，则抛出一个IllegalOilInputException异常
     * @param owner
     * @param oil
     * @throws IllegalOilInputException
     */
    public Car(String owner, double oil) throws IllegalOilInputException {
        this.owner = owner;
        if (oil < 0) {
            throw new IllegalOilInputException();
        } else {
            this.oil = oil;
        }
    }

    /**
     * 有参构造方法将传入的owner赋值给实例变量owner，初始化车主
     * 油量初始化为0
     * @param owner
     */
    public Car(String owner) {
        this.owner = owner;
        oil = 0;
    }

    /**
     * 对车加油的方法
     * 若输入了非法油量，则抛出一个IllegalOilInputException异常
     * @param oil
     * @throws IllegalOilInputException
     */
    public void addOil(double oil) throws IllegalOilInputException {
        if (oil < 0) {
            throw new IllegalOilInputException();
        } else {
            this.oil += oil;
        }
    }

    /**
     * 让车行驶的方法
     * 若输入的路程不合法(小于0，或其耗油量大于所剩油量)，则抛出一个IllegalRouteInputException异常
     * @param distance
     * @throws IllegalRouteInputException
     */
    public void drive(int distance) throws IllegalRouteInputException {
        if (distance < 0 || oil < distance / 100.0 * 5) {
            throw new IllegalRouteInputException();
        } else {
            this.oil -= distance / 100.0 * 5;
        }
    }

    public String getOwner() {
        return owner;
    }

    public double getOil() {
        return oil;
    }
}

/**
 * 定义一个非法油量输入的异常类
 */
class IllegalOilInputException extends Exception {
    public IllegalOilInputException() {
    }

    @Override
    public String getMessage() {
        return "非法的油量输入！";
    }
}

/**
 * 定义一个非法路程输入的异常类
 */
class IllegalRouteInputException extends Exception {
    public IllegalRouteInputException() {
    }

    @Override
    public String getMessage() {
        return "非法的路程输入！";
    }
}
