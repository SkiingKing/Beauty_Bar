package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.Role;
import beautybar.vn.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAO {
    private static UserDAO instance;


    private static final String ADD__USER =
            "INSERT INTO users (nameandsurname,email, password,role_role_id) VALUES (?,?,?,?)";
    private static final String MAX_ID =
            "SELECT MAX(id) FROM users";
    private static final String GET__ALL__USERS =
            "SELECT * FROM users";

    private static final String GET__USER =
            "SELECT id,role_role_id FROM users WHERE password = ? AND email = ?";

    private static final String FIND_MASTER_BY_EMAIL =
            "SELECT nameandsurname FROM users WHERE email = ?";

    private static final String FIND_USER_BY_ID =
            "SELECT email FROM users WHERE id = ?";
    private static final String NUMBER_OF_ROWS =
            "SELECT count(record_id) FROM record";



    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    /**
     * Add new user.
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultAdded = 0;

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(ADD__USER);

            statement.setString(1, user.getNameAndSurname());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRoleId());

            resultAdded = statement.executeUpdate();

            ResultSet rs = statement.executeQuery(MAX_ID);
            rs.next();
            int userId = rs.getInt(1);
            user.setId(userId);


        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return resultAdded;
    }

    /**
     * Return all user.
     *
     * @return Set<User>
     */
    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<User>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(GET__ALL__USERS);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nameandsurname");
                String password = rs.getString("password");
                int role = rs.getInt("role_role_id");

                User user = new User();
                user.setId(id);
                user.setEmail(name);
                user.setPassword(password);
                user.setRoleId(role);
                users.add(user);
            }
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return users;
    }

    /**
     * Return user if he is in the bd.
     *
     * @param email
     * @param password
     * @return user
     */

    public User getUser(String email, String password) {
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(GET__USER);

            statement.setString(1,password);
            statement.setString(2,email);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                int role_id = rs.getInt("role_role_id");
                user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
                user.setRoleId(role_id);
                return user;
            }

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return null;
    }

    /**
     * Find master by email, and return his name and surname.
     *
     * @param email
     * @return String
     */
    public String findMasterByEmail(String email){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_MASTER_BY_EMAIL);

            statement.setString(1,email);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String master_name = rs.getString("nameandsurname");
                return master_name;
            }
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return null;
    }

    /**
     * Return user email by id.
     * @param id
     * @return
     */

    public String findUserEmailById(int id){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_USER_BY_ID);

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");
                return email;
            }
        }catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return null;
    }
    /**
     * Return number of record rows.
     * @return Integer
     */
    public Integer getNumberOfRows() {
        Connection connection = null;
        PreparedStatement statement = null;
        Integer numOfRows = 0;

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(NUMBER_OF_ROWS);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }

        return numOfRows;
    }

}
