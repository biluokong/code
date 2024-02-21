package javase基础封装继承和多态.day09;
/*
小芳的妈妈每天给她2.5元钱，她都会存起来，但是，每当这一天是存钱的第5天
或者5的倍数的话，她都会花去6元钱，请问，经过多少天，小芳才可以存到100元钱。
*/
public class Test05 {
    public static void main(String[] args) {
        int money = 0;
        int day = 0;
        while (money < 100) {
            day++;
            money += 2.5;
            if (day % 5 == 0) {
                money -= 6;
            }
        }
        System.out.println("经过" + day + "天可以存到100元");
    }
}

