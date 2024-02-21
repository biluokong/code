import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 1、JDBC中的事务是自动提交的（默认情况下），只要执行一条DML语句，则自动提交一次。
 * 2、实际业务中，通常都是多条DML语句共同联合才能完成的，必须保证它们同时失败或成功
 * 3、重点：
 *      conn.setAutoCommit(false);  false表示关闭事务自动提交
 *      conn.commit();      //手动提交事务
 *      conn.rollback();    //手动回滚事务
 */
public class 事务 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=Asia/Shanghai", "root", "3238");
            //关闭默认自动提交
            conn.setAutoCommit(false);

            String sql1 = "update t_count set money = ? where count = ?";
            ps = conn.prepareStatement(sql1);
            ps.setDouble(1, 200);
            ps.setString(2, "张三");
            int count = ps.executeUpdate();

            /*String s = null;
            s.toString();*/

            String sql2 = "update t_count set money = ? where count = ?";
            ps = conn.prepareStatement(sql2);
            ps.setDouble(1, 200);
            ps.setString(2, "jack");
            count += ps.executeUpdate();

            System.out.println(count);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //如果事务执行失败（遇到异常或其它问题），为保证数据的安全性，必须回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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