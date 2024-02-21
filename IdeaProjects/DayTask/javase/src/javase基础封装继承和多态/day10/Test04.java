package javase基础封装继承和多态.day10;
/*题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半再落下，
        求它在第10次落地时，共经过多少米*/
public class Test04 {
    public static void main(String[] args) {
        double high = 100;
        double meter = 0;
        for (int i = 1; i <= 10; i++) {
            meter += high;
            System.out.println(meter);
            high /= 2;
        }
        System.out.println("经过了" + meter + "米");
    }
}
