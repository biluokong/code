import javax.xml.transform.Result;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1、解决SQL注入现象
 *      只要用户提供的信息不参与SQL语句的编译过程，问题就解决了
 *      要想用户信息不参与编译，要用java.sql.PrepareStatement此接口
 *      它继承了Statement,是属于预编译的数据库操作对象
 *      其原理是：预先对SQL语句的框架进行编译，然后再给SQL语句传“值”。
 *
 * 2、解决SQL注入的关键是什么？
 *      让用户提供的信息中即使有sql语句的关键字，当也不会参与编译，不起作用
 *
 * 3、对比Statement与PreparedStatement
 *      ①Statement存在sql注入问题，PreparedStatement解决了sql注入问题
 *      ②Statement是编译一次，执行一次；PreparedStatement是编译一次，执行n次，效率较高
 *      ③PrepareStatement会在编译阶段做类型的安全检查
 *      综上所述：PrepareStatement使用较多，只有极少情况需要使用Statement
 *
 * 4、什么情况必须使用Statement（字符串拼接用Statement，只是传入值用PreparedStatement）
 *        业务方面要求必须支持SQL语句的时候。凡是业务方面要求进行sql语句拼接的必须使用此类型（比如只需输入desc和asc来进行排序时）
 */
public class SQL注入现象解决 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String, String> userLoginInfo = initializeUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    /**
     * 用户登录
     *
     * @param userLoginInfo 用户登录信息
     * @return false表示失败，true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记的意识
        boolean loginSuccess = false;

        //JDBC代码
        Connection conn = null;
        PreparedStatement ps = null;    //这里使用了预编译的数据库操作对象
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、获取驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=Asia/Shanghai&useSSL=false", "root", "3238");

            //3、获取预编译的数据操作对象
            //SQL语句的框子(架)，一个问号代表一个占位符，一个？将来接收一个“值”，注意：占位符不能用单引号扩起来
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";   //这里的？是占位符，只能放值
            //程序执行到此处，会发送sql语句框子给DBMS，然后DBMS进行sql语句的预先编译
            ps = conn.prepareStatement(sql);
            //接下来就能给占位符赋值了（第几个问号下就是第几个下标）
            ps.setString(1, userLoginInfo.get("loginName"));
            ps.setString(2, userLoginInfo.get("loginPwd"));

            //4、执行sql
            rs = ps.executeQuery();     //这里则括号内不用再加sql了，传入sql语句了

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
            if (ps != null) {
                try {
                    ps.close();
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
     *
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
