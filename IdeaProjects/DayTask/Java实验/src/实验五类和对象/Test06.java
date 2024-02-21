package 实验五类和对象;

/**
 * 定义一个时间类MyTime，有三个属性hour，minute，second。为MyTime类定义构造方法，以便创建对象时初始化成员变量。除了构造方法外，还要创建以下方法：
 * （1）nextSecond( )：时间经过1秒
 * （2）nextMinute( )：时间经过1分
 * （3）nextHour( )：时间经过1小时
 * （4）prevSecond( )：前1秒
 * （5）prevMinute( )：前1分
 * （6）prevHour( )：前一小时
 * （7）display( )：以HH:MM:SS格式显示时间
 * 另外编写测试类，进行测试。
 */
public class Test06 {
    public static void main(String[] args) throws IllegalTimeEntryException {
        MyTime time1 = new MyTime(26, 120, 60); //创建一个时间实例变量
        time1.display();    //显示时间
        MyTime time2 = new MyTime(23, 59, 59);
        time2.nextHour();   //增加一小时
        time2.display();
        time2.nextMinute();     //增加一分钟
        time2.display();
        time2.nextSecond();     //增加一秒
        time2.display();
        MyTime time3 = new MyTime(0, 0, 0);
        time3.prevHour();   //减少一小时
        time3.display();
        time3.prevMinute();     //减少一分钟
        time3.display();
        time3.prevSecond();     //减少一秒
        time3.display();
        MyTime time4 = new MyTime(-2, 3, 5);    //创建时间实例变量，并传入非法数值
        time4.display();
    }
}

/**
 * 定义一个时间类MyTime
 */
class MyTime {
    private int hour;
    private int minute;
    private int second;

    /**
     * 有参构造方法，初始化实例变量小时数hour、分钟数minute和秒数second，若传入的参数值为负值，则抛出异常“非法时间数值参数异常”
     * @param hour
     * @param minute
     * @param second
     * @throws IllegalTimeEntryException
     */
    public MyTime(int hour, int minute, int second) throws IllegalTimeEntryException {
        if (hour < 0 || minute < 0 || second < 0) { //若传入参数值为负值，则抛出异常
            throw new IllegalTimeEntryException();
        }
        if (second > 59) {  //若传入的秒数大于59，则让其变为合法秒数
            minute += second / 60;
            this.second = second % 60;
        } else {
            this.second = second;
        }
        if (minute > 59) {  //若传入的分钟数大于59，则让其变为合法分钟数
            hour += minute / 60;
            this.minute = minute % 60;
        } else {
            this.minute = minute;
        }
        this.hour = hour % 24;  //若传入的小时数大于23，则让其变为合法小时数
    }

    /**
     * 以HH:MM:SS格式显示时间
     */
    public void display() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }

    /**
     * 增加一秒
     */
    public void nextSecond() {
        if (second == 59) { //若为59秒，则增加一秒后变为0秒
            second = 0;
            nextMinute();
        } else {
            second++;
        }
    }

    /**
     * 增加一分钟
     */
    public void nextMinute() {
        if (minute == 59) { //若为59分钟，则增加一分钟后变为0分钟
            minute = 0;
            nextHour();
        } else {
            minute++;
        }
    }

    /**
     * 增加一小时
     */
    public void nextHour() {
        hour = ++hour % 24; //若为23点，则增加一小时后变为0点
    }

    /**
     * 减少一秒
     */
    public void prevSecond() {
        if (second == 0) {  //若为0秒，则减少一秒后变为59秒
            second = 59;
            prevMinute();
        } else {
            second--;
        }
    }

    /**
     * 减少一分钟
     */
    public void prevMinute() {
        if (minute == 0) {  //若为0分钟，则减少一分钟后变为59分钟
            minute = 59;
            prevHour();
        } else {
            minute--;
        }
    }

    /**
     * 减少一小时
     */
    public void prevHour() {
        if (hour == 0) {    //若为0点，则减少一小时后变为23点
            hour = 23;
        } else {
            hour--;
        }
    }
}

/**
 * 定义一个非法时间数值参数异常
 */
class IllegalTimeEntryException extends Exception {
    public IllegalTimeEntryException() {
    }

    @Override
    public String getMessage() {
        return "非法的时间数值参数！";
    }
}
