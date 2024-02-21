package 实验三Java语言基础;

import java.util.Scanner;

/**
 * 输入1到7之间的某个整数，输出相应的星期:Monday、 Tuesday 等等，用switch语句实现
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     //定义一个扫描仪
        System.out.println("请输入1-7之间的整数：");
        int n = input.nextInt();    //读取键盘输入的一个整数
        input.close();  //关闭扫描仪
        String day = "";    //用来保存day名

        //使用switch语句来输出对应的星期数
        switch (n) {
            case 1 :
                day = "Monday";
                break;
            case 2 :
                day = "Tuesday";
                break;
            case 3 :
                day = "wednesday";
                break;
            case 4 :
                day = "Thursday";
                break;
            case 5 :
                day = "Friday";
                break;
            case 6 :
                day = "Saturday";
                break;
            case 7 :
                day = "Sunday";
                break;
            default:
                //若输入非法的星期数值，则抛出相关异常，并将其捕捉，以不影响后面代码的执行
                try {
                    throw new IllegalIntNumberInputException();
                } catch (IllegalIntNumberInputException e) {
                    e.printStackTrace();
                }
        }
        System.out.print(day);
    }
}

/**
 * 自定义一个非法星期数的输入异常
 */
class IllegalIntNumberInputException extends Exception {
    public IllegalIntNumberInputException() {
    }

    @Override
    public String getMessage() {
        return "非法的星期数值输入！";
    }
}
