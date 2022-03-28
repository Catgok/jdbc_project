package dao.impl;

import dao.AdminDao;
import po.Admin;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public Admin getAdminByNameByPass(String adminName, String password) {
        Admin admin = null;
        String sql = "select * from admin where adminName=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);//准备陈述
            pst.setString(1, adminName);//setString表示必须为String类型 用于防注入
            pst.setString(2, password);
            rs = pst.executeQuery();//execute* 返回类型不同
            while (rs.next()) {//按行读取
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));//get* 实质是类型转换 object->*
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//无论是否成功 finally都会执行
            DBUtil.close(rs, pst, con);
        }
        return admin;
    }
}
