package util;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;
        final String div = "com.mysql.cj.jdbc.Driver";
        final String rooturl = "jdbc:mysql://127.0.0.1:3306/elm";
        final String user = "test";
        final String pass = "test";
        try {
            Class.forName(div);
            conn = DriverManager.getConnection(rooturl, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

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
