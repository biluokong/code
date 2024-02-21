package 常用框架.Junit框架;

public class UserService {
    public String loginName(String username, String password) {
        if ("admin".equals(username) && "1234".equals(password))
            return "登录成功";
        else
            return "用户名或密码错误";
    }

    public void selectNames() {
//        System.out.println(10/0);   //模拟异常
        System.out.println("查询全部用户名成功");
    }
}
