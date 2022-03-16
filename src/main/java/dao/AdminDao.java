package dao;

import po.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
}
