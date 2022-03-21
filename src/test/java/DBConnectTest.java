import org.junit.Test;
import util.DBUtil;

import java.sql.Connection;

public class DBConnectTest {
    @Test
    public void testConnect() {
        Connection con = DBUtil.getConnection();
        System.out.println(1);
    }
}