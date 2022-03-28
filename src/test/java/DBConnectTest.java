import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import org.junit.Test;
import po.Admin;
import util.DBUtil;

import java.sql.Connection;

public class DBConnectTest {
    @Test
    public void testConnect() {
        Connection con = DBUtil.getConnection();
        System.out.println(1);
    }

    @Test
    public void testAdminDao() {
        AdminDao ado = new AdminDaoImpl();
        Admin admin = ado.getAdminByNameByPass("1", "pass");
        System.out.println(1);
    }
}