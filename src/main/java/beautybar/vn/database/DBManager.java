package beautybar.vn.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {

    private final String URL = "jdbc:mysql://localhost:3306/test_project_bd?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "14042003";


    private DBManager() {
    }


    private static DBManager instance = null;

    public static DBManager getInstance(){
        if (instance==null)
            instance = new DBManager();
        return instance;
    }


    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager

                .getConnection( URL+"&user="+USER+"&password="+PASSWORD);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        connection.setAutoCommit(false);
        return connection;
    }

    public void commitAndClose(Connection con) {
        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void rollbackAndClose(Connection con) {
        try {
            con.rollback();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

