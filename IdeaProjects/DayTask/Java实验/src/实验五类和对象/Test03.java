package 实验五类和对象;

/**
 * 3.编写一个类表示坐标点，类中包含构造方法在新建类的时候对坐标赋值。另编写一个关于坐标点的工具类。
 * （1）编写坐标点类Point。
 *   	（2）编写工具类PointUtil，包含方法 double distance(Point a,Point b)用于求两个坐标点之间的距离，和方法double area(Point a,Point b)用于求两点连线为对角线的矩形面积。
 *   	（3）编写主方法求坐标（2，10）到坐标（4，55）之间的距离和矩形面积。
 */
public class Test03 {
    public static void main(String[] args) {
        //创建两个坐标点对象
        Point a = new Point(2, 10);
        Point b = new Point(4, 55);

        System.out.println("a和b两坐标点之间的距离为：" + PointUtil.distance(a, b));
        System.out.println("以a和b两坐标点的连线为对角线的矩形的面积为：" + PointUtil.area(a, b));
    }
}

/**
 * 定义一个有关坐标点操作的工具类
 */
class PointUtil {
    /**
     * 获得两坐标点之间的距离
     * @param a
     * @param b
     * @return
     */
    public static double distance(Point a, Point b) {
        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }

    /**
     * 获得以两坐标点连线为对角线的矩形的面积
     * @param a
     * @param b
     * @return
     */
    public static double area(Point a, Point b) {
        return Math.abs(a.getX() - b.getX()) * Math.abs(a.getY() - b.getY());
    }
}

/**
 * 定义一个坐标点类
 */
class Point {
    private double x;   //x坐标
    private double y;   //y坐标

    /**
     * 有参构造方法初始化x和y坐标
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 获得x坐标的值
     * @return x的坐标
     */
    public double getX() {
        return x;
    }

    /**
     * 修改坐标x的值
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * 获得y坐标的值
     * @return y的坐标
     */
    public double getY() {
        return y;
    }

    /**
     * 修改y坐标的值
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
}
