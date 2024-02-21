package 实验五类和对象;

/**
 * 设计一个圆珠笔类BallPen，有1个属性boolean penPoint（笔尖是否伸出），有4个方法：
 *   	（1）构造方法BallPen ()，将penPoint置为false
 *   	（2）按压操作方法void  knock()，将penPoint置反
 *   	（3）获取笔尖状态方法 boollean getPenPoint()
 *   	（4）main方法
 *     	创建对象并对实例对象进行按压操作，显示笔尖的状态。
 * main方法测试BallPen对象
 */
public class Test01 {
    public static void main(String[] args) {
        //创建一个圆珠笔对象
        BallPen ballPen = new BallPen();
        System.out.println(ballPen.getPenPoint());

        //调用BallPen对象的knock方法，进行按压操作
        ballPen.knock();
        System.out.println(ballPen.getPenPoint());
    }
}

/**
 * 定义一个BallPen(圆珠笔)类
 */
class BallPen {
    //定义私有变量penPoint表示笔尖是否伸出
    private boolean penPoint;

    /**
     * 无参构造方法初始化penPoint属性，置为false
     */
    public BallPen() {
        penPoint = false;
    }

    /**
     * 按压方法将penPoint置反
     */
    public void knock() {
        if (penPoint) {
            penPoint = false;
            return;
        }
        penPoint = true;
    }

    /**
     * 获得笔尖状态，返回penPoint值
     * @return
     */
    public boolean getPenPoint() {
        return penPoint;
    }
}
