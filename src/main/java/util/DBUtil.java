package util;

import java.sql.*;

public class DBUtil {
    // 建立连接
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(ConfigManager.getProp("div"));
            con = DriverManager.getConnection(ConfigManager.getProp("url"), ConfigManager.getProp("user"), ConfigManager.getProp("pass"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭连接
    public static void close(ResultSet rs, PreparedStatement pst, Connection con) {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (pst != null) pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
