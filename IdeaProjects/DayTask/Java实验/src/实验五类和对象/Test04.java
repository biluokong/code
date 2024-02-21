package 实验五类和对象;

/**
 * 编写Java程序模拟简单的计算器。 定义名为Number的类，其中有两个私有的整型数据成员x和y。有7个方法：
 * （1）构造方法Number(int x,int y)
 * （2）加法运算方法 int addition(int x,int y)
 * （3）减法运算方法 int subtration(int x,int y)
 * （4）乘法运算方法 int multiplication(int x,int y)
 * （5）除法运算方法 int division(int x,int y)
 * 另外编写一个测试类，对Number类进行测试。
 */
public class Test04 {
    public static void main(String[] args) {
        Number number = new Number(3, 6);   //创建一个Number实例变量
        System.out.println( "4 + 2 = " + number.addition(2, 4));  //两数相加
        System.out.println("4 - 8 = " + number.subtraction(4, 8));   //两数相减
        System.out.println("4 / 2 = " + Number.division(4, 2));  //两数相除
        //尝试两数相除，若抛出了除数为0的异常，则将其捕捉，让接下来的语句继续执行
        try {
            System.out.println("4 / 0 = " + Number.division(4, 0));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("4 * 2 = " + Number.multiplication(4, 2));    //两数相乘
    }
}

/**
 * 定义名为Number的类
 */
class Number {
    private int x;
    private int y;

    /**
     * 有参构造方法初始化实例变量x、y
     * @param x
     * @param y
     */
    public Number(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 静态方法实现两个整型数值x和y的相加
     * @param x
     * @param y
     * @return
     */
    public static int addition(int x, int y) {
        return x + y;
    }

    /**
     * 静态方法实现两个整型数值x和y的相减
     * @param x
     * @param y
     * @return
     */
    public static int subtraction(int x, int y) {
        return x - y;
    }

    /**
     * 静态方法实现两个整型数值x和y的相乘
     * @param x
     * @param y
     * @return
     */
    public static int multiplication(int x, int y) {
        return x * y;
    }

    /**
     * 静态方法实现两个整型数值x和y的相除，若除数为0，则会抛出运行时异常“除数为0异常”给jvm虚拟机以终止程序的运行，可提前捕获
     * @param x
     * @param y
     * @return
     */
    public static int division(int x, int y) {
        return x / y;
    }
}
