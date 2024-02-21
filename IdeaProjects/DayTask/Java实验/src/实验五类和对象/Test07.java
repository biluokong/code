package 实验五类和对象;

/**
 * 编写程序使用复数类Complex验证两个复数 2+2i 和3+3i 相加产生一个新的复数5+5i 。复数类Complex满足如下要求：
 * （1）属性
 * int realPart ：复数的实部；
 * int imaginPart：复数的虚部；
 * （2）方法
 * Complex( ) : 构造方法，将复数的实部和虚部都置0；
 * Complex( int r , int i ) : 
 * Complex complexAdd(Complex a) : 将当前复数对象与形参复数对象相加，所得的结	果仍是一个复数值，返回给此方法的调用者。
 * String toString( ) : 把当前复数对象的实部、虚部组合成 a+bi 的字符串形式，其中	a 和 b分别为实部和虚部的数据。
 * 另外编写一个测试类Test，对Complex类进行测试。
 */
public class Test07 {
    public static void main(String[] args) {
        //创建一个复数对象
        Complex c1 = new Complex(4,8);
        System.out.println(c1); //输出复数对象
        Complex c2 = new Complex(-2, -8);
        System.out.println(c2);
        System.out.println("4+8i和-2-8i相加结果为：" + c1.complexAdd(c2));  //输入两复数相加的结果
    }
}

/**
 * 定义复数类
 */
class Complex {
    private int realPart;   //定义私有属性realPart表示复数的实部
    private int imaginePart;    //定义私有属性imaginePart表示复数的虚部

    /**
     * 无参构造方法，初始化实例属性为0
     */
    public Complex() {
    }

    /**
     * 有参构造方法初始化实例属性为传入的参数
     * @param realPart
     * @param imaginePart
     */
    public Complex(int realPart, int imaginePart) {
        this.realPart = realPart;
        this.imaginePart = imaginePart;
    }

    /**
     * 实现当前复数和传入复数的相加，并返回相加后的结果
     * @param c
     * @return the value of Complex
     */
    public Complex complexAdd(Complex c) {
        Complex complex = new Complex(realPart + c.realPart, imaginePart + c.imaginePart);
        return complex;
    }

    /**
     * 将实例属性转换为字符串
     * @return
     */
    @Override
    public String toString() {
        return imaginePart < 0 ? realPart + "" + imaginePart + "i" : (imaginePart > 0 ? realPart + "+" + imaginePart + "i" : realPart + "");
    }
}
