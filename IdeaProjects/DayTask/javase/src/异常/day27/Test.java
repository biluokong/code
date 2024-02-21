package 异常.day27;

import javax.crypto.spec.PSource;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("用户开始注册：请输入用户名和密码：");
        Scanner input = new Scanner(System.in);
        UserService user = new UserService();
        try {
            user.register(input.nextLine(), input.nextLine());
        } catch (UsernameLengthException e) {
            e.printStackTrace();
        } finally{
            input.close();
        }
    }
}
