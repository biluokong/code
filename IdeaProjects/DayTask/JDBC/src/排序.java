import java.sql.*;
import java.util.Scanner;

/**
 * 排序，desc降序，asc升序
 * 这里只能用Statement对象，用PreparedStatement对象运行时会报错
 */
public class 排序 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入排序方式（desc降序，asc升序）：");
        String keyWords = s.nextLine();

        //执行sql
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=Asia/Shanghai&useSSL=false", "root", "3238");
            //获取数据操作对象
            stmt = conn.createStatement();
            //执行sql并获取结果集
            String sql = "select ename from emp order by ename " + keyWords;
            rs = stmt.executeQuery(sql);
            //处理结果集 遍历
            while (rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
