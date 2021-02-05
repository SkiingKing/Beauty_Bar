package beautybar.vn.dao;

public class DaoFactory {

    private static DaoFactory factory;

    private DaoFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DaoFactory getInstance() {
        if (factory == null) {
            factory = new DaoFactory();
        }
        return factory;
    }

    public UserDAO getUserDAO() {
        return UserDAO.getInstance();
    }

}