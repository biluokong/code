package javase基础封装继承和多态.day14;
//设计日期类，每个日期对象都可以描述年月日信息。
public class Date {
    private int year;
    private int moon;
    private int day;

    public Date() {
        this(1970, 1, 1);
    }

    public Date(int year, int moon, int day) {
        this.year = year;
        this.moon = moon;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMoon() {
        return moon;
    }

    public void setMoon(int moon) {
        this.moon = moon;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", moon=" + moon +
                ", day=" + day +
                '}';
    }
}
