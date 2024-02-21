import javax.xml.transform.Result;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 实现功能：
 *      1、需求：模拟用户登录功能的实现
 *      2、业务描述：
 *              程序运行时，提供一个输入的入口，让用户输入用户名和密码
 *              用户输入信息后，提交后java连接数据库验证用户名和密码是否合法
 *              合法：显示登录成功；不合法：显示登录失败
 *      3、数据的准备
 *              用建模工具：PowerDesigner
 *      4、当前程序存在的问题：
 *          用户名：fdsa
 *          密码：fdsa' or '1'='1
 *          登录成功
 *          这种现象被称为SQL注入（安全隐患）。（黑客经常使用）
 *      5、dzSQL注入的根本原因：
 *          用户输入的信息中含有sql语句的关键字，并且这些关键字参与sql语句的编译过程，让sql语句的原意被扭曲，进而达到sql注入。
 */
public class SQL注入现象 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String, String> userLoginInfo = initializeUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false表示失败，true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记的意识
        boolean loginSuccess = false;

        //JDBC代码
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、获取驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=Asia/Shanghai&useSSL=false", "root", "3238");

            //3、获取数据操作对象
            stmt = conn.createStatement();

            //4、执行sql
            String sql = "select * from t_user where loginName = '" + userLoginInfo.get("loginName")
                    + "' and loginPwd = '" + userLoginInfo.get("loginPwd") + "'";
            //以上完成了sql语句的拼接，然后让下面的语句将sql语句发送给DBMS，让其进行编译。此方式会让用户提供的非法信息编译进去，导致了原sql语句的含义被扭曲了
            rs = stmt.executeQuery(sql);

            //5、处理结果集
            if (rs.next()) {
                loginSuccess = true;
            }

            //6、释放资源

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return loginSuccess;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initializeUI() {
        Scanner s = new Scanner(System.in);

        System.out.print("用户名：");
        String loginName = s.nextLine();

        System.out.print("密码：");
        String loginPwd = s.nextLine();

        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);

        return userLoginInfo;
    }
}
