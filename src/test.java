import com.xiezilailai.example.conn;

import java.sql.Connection;
import java.sql.SQLException;

import com.xiezilailai.example.model.UserTable;
/**
 * Created by 蝎子莱莱123 on 2016/2/11.
 */
public class test {
    public static void main(String[] args) {
        Connection co=new conn().getCon();
        try {
            co.prepareCall("SELECT * FROM studentinfo");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
