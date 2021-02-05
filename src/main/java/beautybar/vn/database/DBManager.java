package beautybar.vn.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DBManager {

    private final String URL = "jdbc:mysql://localhost:3306/test_project_bd?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "14042003";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}