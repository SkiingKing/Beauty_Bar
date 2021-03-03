package beautybar.vn.database;



import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBManager {

    private final String URL = "jdbc:mysql://localhost:3306/test_project_bd?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "14042003";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

//    private static String url;
//    private static final Logger log = Logger.getLogger(DBManager.class);
//
//
//    private static DBManager instance = null;
//
//    public static DBManager getInstance(){
//        if (instance==null)
//            instance = new DBManager();
//        return instance;
//    }
//
//    public Connection getConnection(){
//        Connection con = null;
//        try {
//            Context initContext = new InitialContext();
//            Context envContext  = (Context)initContext.lookup("java:/comp/env");
//
//            DataSource ds = (DataSource)envContext.lookup("jdbc/context");
//            con = ds.getConnection();
//        } catch (NamingException ex) {
//            log.error("Cannot obtain a connection from the pool", ex);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return con;
//    }
}

