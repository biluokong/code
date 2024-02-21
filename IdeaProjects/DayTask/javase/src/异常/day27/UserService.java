package 异常.day27;

public class UserService {
    public void register(String username, String password) throws UsernameLengthException {
        if (username.length() >= 6 && username.length() <= 14) {
            System.out.println("注册成功！");
            return;
        }
        throw new UsernameLengthException();
    }
}

