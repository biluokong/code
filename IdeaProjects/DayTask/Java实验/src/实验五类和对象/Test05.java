package 实验五类和对象;

/**
 * 定义长方形类Rectangle，含：
 * （1）属性
 * int width；
 * int height；
 *    	（2）方法
 *        	Rectangle()：宽、高默认值为1；
 *   	Rectangle(int val):宽、高均为参数值；
 * Rectangle(int width,int height)：
 * Double getSquare()：计算面积；
 * Double getPerimeter():计算周长；
 * 另外编写测试类进行测试。
 */
public class Test05 {
    public static void main(String[] args) {
        //用只需一个参数的构造方法创建一个长方形对象
        Rectangle rectangle1 = new Rectangle(4);
        //输出长方形的面积
        System.out.println("长和宽是4的长方形面积为：" + rectangle1.getSquare());
        //长方形的周长
        System.out.println("长和宽是4的长方形周长为：" + rectangle1.getPerimeter());
        //用需要两个参数的构造方法创建一个长方形对象
        Rectangle rectangle2 = new Rectangle(2, 4);
        System.out.println("长和宽分别是2和4的长方形面积为：" + rectangle2.getSquare());
        System.out.println("长和宽分别是2和4的长方形周长为：" + rectangle2.getPerimeter());
    }
}

/**
 * 定义长方形类Rectangle
 */
class Rectangle {
    private int width;
    private int height;

    /**
     * 无参构造方法，初始化实例变量长方形的高和宽为0
     */
    public Rectangle() {
        width = 0;
        height = 0;
    }

    /**
     * 有参构造方法，初始化成员变量高和宽为val
     * @param val
     */
    public Rectangle(int val) {
        this.width = val;
        this.height = val;
    }

    /**
     * 有参构造方法，初始化成员变量高为width,宽为height
     * @param width
     * @param height
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 获得长方形的面积
     * @return
     */
    public double getSquare() {
        return width * height;
    }

    /**
     * 获得长方形的周长
     * @return
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    /**
     * 获得width宽的值
     * @return width 长方形的宽
     */
    public int getWidth() {
        return width;
    }

    /**
     * 修改width宽的值
     * @param width 长方形的宽
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获得height高的值
     * @return height 长方形的高
     */
    public int getHeight() {
        return height;
    }

    /**
     * 修改height高的值
     * @param height 长方形的高
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
