package javase基础封装继承和多态.day16;

/*在程序中经常要对时间进行操作但是并没有时间类型的数据。
那么我们可以自己实现一个时间类来满足程序中的需要。
定义名为MyTime的类其中应有三个整型成员时hour分minute秒second
为了保证数据的安全性这三个成员变量应声明为私有。
为MyTime类定义构造方法以方便创建对象时初始化成员变量。
再定义display方法用于将时间信息打印出来。
为MyTime类添加以下方法
	addSecond(int sec)
	addMinute(int min)
	addHour(int hou)
	subSecond(int sec)
	subMinute(int min)
	subHour(int hou)
分别对时、分、秒进行加减运算。*/
public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void addSecond(int second) {
        this.second += second;
        if (this.second >= 60) {
            int t = this.second / 60;
            addMinute(t);
            this.second -= t * 60;
        }
    }

    public void addMinute(int minute) {
        this.minute += minute;
        if (this.minute >= 60) {
            int t = this.minute / 60;
            addHour(t);
            this.minute -= t * 60;
        }
    }

    public void addHour(int hour) {
        this.hour += hour;
        if (this.hour >= 24) {
            this.hour -= this.hour / 24 * 24;
        }
    }

    public void subSecond(int second) {
        this.second -= second;
        if (this.second < 0) {
            int t = (-this.second / 60) + 1;
            subMinute(t);
            this.second += t * 60;
            if (this.second == 60) {
                addSecond(1);
                this.second = 0;
            }
        }
    }

    public void subMinute(int minute) {
        this.minute -= minute;
        if (this.minute < 0) {
            int t = (-this.minute / 60) + 1;
            subHour(t);
            this.minute += t * 60;
            if (this.minute == 60) {
                addHour(1);
                this.minute = 0;
            }
        }
    }

    public void subHour(int hour) {
        this.hour -= hour;
        if (this.hour < 0) {
            this.hour += (-this.hour / 24 + 1) * 24;
            if (this.hour == 0) {
                this.hour = 0;
            }
        }
    }

    public void display() {
        System.out.printf("%02d时%02d分%02d秒\n", hour, minute, second);
    }
}

class MyTimeTest {
    public static void main(String[] args) {
        MyTime time = new MyTime(23, 50, 55);
        time.display();
        time.addSecond(125);
        time.display();
        time.addHour(25);
        time.display();
        time.subSecond(122);
        time.display();
        time.subHour(26);
        time.display();
    }
}