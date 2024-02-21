package 实验八异常处理;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个第一个整数：");
        try {
            int num1 = input.nextInt();
            System.out.println("请输入一个算术运算符（+、-、*、/）：");
            String arithmeticOperator = getArithmeticOperator(input.next());
            System.out.println("请输入第二个整数：");
            try {
                int num2 = input.nextInt();
                //获取运算结果并输出
                System.out.println("运算结果为：" + getOperationResult(num1, num2, arithmeticOperator));
            } catch (InputMismatchException e) {    //捕捉数据格式异常
                System.out.println("输入的第二个数据不是整数！");
            } catch (ArithmeticException e) {   //捕捉除零异常
                System.out.println("除数不能为0！");
            }
        } catch (InputMismatchException e) {    //捕捉数据格式异常
            System.out.println("输入的第一个数据不是整数！");
        } catch (IllegalOperatorException e) {  //捕捉非法运算符异常
            System.out.println(e.getMessage());
        } finally {
            input.close();
            System.out.println("程序结束！");
        }
    }

    /**
     * 获取运算结果的方法
     * @param num1 第一个数
     * @param num2 第二个数
     * @param arithmeticOperator 运算符
     * @return 返回运算结果
     */
    private static int getOperationResult(int num1, int num2, String arithmeticOperator) {
        switch (arithmeticOperator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }

    /**
     * 获取一个算术运算符的方法
     * @param str 输入的算术运算符
     * @return  返回一个算术运算符
     * @throws IllegalOperatorException 当输入的运算符不是+、-、*、/时，抛出非法运算符异常
     */
    public static String getArithmeticOperator(String str) throws IllegalOperatorException {
        //判断输入的算术运算符是否合法
        if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
            return str;
        }
        //若不合法，则抛出相关异常
        throw new IllegalOperatorException();
    }
}

/**
 * 非法运算符异常类
 */
class IllegalOperatorException extends Exception {
    public IllegalOperatorException() {
    }

    @Override
    public String getMessage() {
        return "输入了非法的算术运算符！";
    }
}
