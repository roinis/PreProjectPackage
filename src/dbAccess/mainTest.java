package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mainTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        database d=new database();
        String connectionUrl = "jdbc:sqlserver://DESKTOP-5FLNA96;"
                + "database=Football;"
                + "user=sa;"
                + "password=123;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                ;
        //"loginTimeout=30;"
        Connection cc2;
        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            cc2=connection;
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO dbo.Budget " +
                    "VALUES (4, 100)";
            statement.executeUpdate(sql);
            statement = cc2.createStatement();
            sql = "INSERT INTO dbo.Budget " +
                    "VALUES (5, 100)";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return ;
        }
    }
}
