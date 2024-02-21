package 悲观锁和乐观锁;

import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作者：宁柱
 *
 * 悲观锁又叫行级锁
 *
 * 此程序开启一个事务，让这个事务专门进行查询，并且使用行级锁/悲观锁，锁住相关的记录
 */
public class Test01 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "select ename,job,sal from emp where job = ? for update ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "MANAGER");

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("ename") + "\t" + rs.getString("job") + "\t" + rs.getDouble("sal"));
            }

            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }
}
